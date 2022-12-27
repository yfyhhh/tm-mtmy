package com.tm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ConvertLatLngIntoRegion {

    //逆地理编码主函数
    public static String inverseGeocoding(String longitude,String latitude){
        String location=longitude+","+latitude;
        //wgs84坐标系（GPS经纬度/GPS传感器获得的GPS数据一般用这个）
        //String url="http://api.map.baidu.com/reverse_geocoding/v3/?ak=您的ak&output=json&coordtype=wgs84ll&location="+location;
        //gcj02坐标系（国测局经纬度坐标）
        //String url="http://api.map.baidu.com/reverse_geocoding/v3/?ak=您的ak&output=json&coordtype=gcj02ll&location="+location;
        //bd09坐标系（百度经纬度坐标）
        String url="http://api.map.baidu.com/reverse_geocoding/v3/?ak=QDeyKI7eXOYx3tUjT0FzTdWKIsWbMNZZ&output=json&coordtype=bd09ll&location="+location;
        //bd09mc坐标系（百度米制坐标）
        //String url="http://api.map.baidu.com/reverse_geocoding/v3/?ak=您的ak&output=json&coordtype=bd09mc&location="+location;
        System.out.println(url);  //打印url，可访问url获得全部的Json数据体，可按需提取数据
        String res=acquire(url);
        JSONObject addressComponent = JSON.parseObject(res).getJSONObject("result").getJSONObject("addressComponent");
        String province = addressComponent.getString("province");
        String city = addressComponent.getString("city");

        System.out.println(province+","+city);
        return province+","+city;
    }

    //Http处理函数
    public static String acquire(String url){
        CloseableHttpClient httpClient= HttpClientBuilder.create().build();
        HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse response=null;
        try {
            response=httpClient.execute(httpGet);
            HttpEntity responseEntity=response.getEntity();
            if (responseEntity!=null){
                return EntityUtils.toString(responseEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(httpClient!=null){
                    httpClient.close();
                }
                if (response!=null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //测试函数
    public static void main(String[] args) {
        String longitude="23.265984844558725";
        String latitude="113.45526449303498";
        inverseGeocoding(longitude,latitude);
    }

}