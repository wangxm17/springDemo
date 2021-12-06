package com.vo;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:40
 */
public class CodeMsg {
    private int code;
    private String msg;

    //错误码
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg INSERT_ERROR = new CodeMsg(100001,"插入失败");
    public static CodeMsg SELECT_ERROR = new CodeMsg(100002,"查询失败");
    public static CodeMsg UPDATE_ERROR = new CodeMsg(100003,"更新失败");
    public static CodeMsg CODE_ERROR = new CodeMsg(100004,"验证码错误！");
    public static CodeMsg USER_ERROR = new CodeMsg(100005,"用户不存在！");

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
