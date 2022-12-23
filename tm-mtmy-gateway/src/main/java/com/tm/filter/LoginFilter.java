package com.tm.filter;

import com.alibaba.fastjson.JSONObject;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoginFilter implements GlobalFilter, Ordered {

    //请求白名单的路径
    private static final String WHITE_URL[] = {"/user/userLogin","/user/sendCode"};

    @Autowired
    private RedisTemplate redisTemplate;

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /**
         * 1. 判断一个是否需要进行拦截 如果是登陆接口，获取验证码接口 需要进行过滤
         * 2. 拿到请求头中的token，判断token是否有效
         * 3. 直接往下走，解析出来请求头中的token中的用户id，并将用户id传递下去
         * 4. token续命
         */
        //1. 判断一个是否需要进行拦截 如果是登陆接口，获取验证码接口 需要进行过滤
        //1.1 获得request请求
        ServerHttpRequest request = exchange.getRequest();
        //1.2 获得请求路径
        String path = request.getPath().toString();
        //1.3 检查路径是否在白名单中
        if (checkUrl(path)) {
            return chain.filter(exchange);
        }
        //获得response响应
        ServerHttpResponse response = exchange.getResponse();
        //获得请求头
        HttpHeaders headers = request.getHeaders();
        //获得请求头的值
        String token = headers.getFirst("token");
        //判断值是否为空
        if(StringUtils.isEmpty(token)){
            return resultProcess(ResultCodeEnum.TOKEN_UNDEFINED,response);
        }
        //分割值做为token的键和值
        String[] arr = token.split(",");
        //判断数组长度
        if(arr.length != 2){
            // 异常情况直接返回
            return resultProcess(ResultCodeEnum.TOKEN_FAIL,response);
        }
        //获取token的键
        String tokenKey = arr[0];
        //判断redis中是否有这个token
        if (!redisTemplate.hasKey(tokenKey)) {
            // 异常情况直接返回
            return resultProcess(ResultCodeEnum.TOKEN_UNDEFINED,response);
        }
        //认证通过
        return chain.filter(exchange);
    }

    /**
     * 校验是否需要拦截这次请求
     * @param path
     */
    private Boolean checkUrl(String path) {
        for (String url : WHITE_URL) {
            if (path.contains(url)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 处理返回值信息
     * @param resultCode
     * @param response
     * @return
     */
    private Mono<Void> resultProcess(ResultCodeEnum resultCode, ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.OK);
        Result result = Result.FAIL(resultCode);
        byte[] bytes = JSONObject.toJSONString(result).getBytes();
        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(wrap));
    }

    public int getOrder() {
        return 0;
    }
}
