package com.tm.result;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 无参构造
     */
    public Result() {

    }
    /**
     * 有参构造
     * @param code
     * @param msg
     * @param data
     */
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     * 有参构造,没有data
     * @param code
     * @param msg
     */
    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /**
     * 枚举类创建有参构造,有data
     * @param resultCodeEnum
     * @param data
     */
    public Result(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = data;
    }
    /**
     * 根据枚举类创建构造方法,无data
     * @param resultCodeEnum
     */
    public Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
    }


    /**
     * success的静态方法，传入返回的数据
     * @param data
     * @return
     */
    public static Result SUCCESS(Object data){
        return new Result(ResultCodeEnum.SUCCESS,data);
    }
    /**
     * success的静态方法,传入枚举对象
     * @return
     */
    public static Result SUCCESS(ResultCodeEnum resultCodeEnum){
        return new Result(resultCodeEnum);
    }
    /**
     * success的静态方法，没有返回参数
     * @return
     */
    public static Result SUCCESS(){
        return SUCCESS(null);
    }
    /**
     * FAIL的静态方法,无参
     * @return
     */
    public static Result FAIL(){
        return new Result(ResultCodeEnum.FAIL);
    }
    /**
     * FAIL的静态方法,有参
     * @return
     */
    public static Result FAIL(int code ,String msg){
        return new Result(code,msg);
    }

    /**
     * fail的静态方法，传入返回的数据
     * @param msg
     * @return
     */
    public static Result FAIL(String msg){
        return new Result(ResultCodeEnum.FAIL,msg);
    }
    /**
     * FAIL的静态方法,自定义枚举code
     * @param resultCodeEnum
     * @return
     */
    public static Result FAIL(ResultCodeEnum resultCodeEnum){
        return new Result(resultCodeEnum);
    }

}
