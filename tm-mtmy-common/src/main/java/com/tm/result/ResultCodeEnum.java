package com.tm.result;

public enum ResultCodeEnum {
    /**
     * 枚举属性
     */
    SUCCESS(200,"操作成功"),
    FAIL(301,"操作失败"),
    TOKEN_FAIL(2003, "token解析异常"),
    TOKEN_UNDEFINED(2004, "token不存在"),
    GET_BAIDU_TOKEN_ERROR(2007, "token生成异常")
    ;

    /**
     * 属性
     */
    private int code;
    private String msg;

    /**
     * 有参构造
     * @param code
     * @param msg
     */
    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * GET方法
     * @return
     */
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
