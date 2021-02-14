package com.zj.baseservice.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果类
 */
@Data
public class R {

    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("响应状态码")
    private Integer code;

    @ApiModelProperty("响应信息")
    private String message;

    @ApiModelProperty("响应数据")
    public Map<String, Object> data = new HashMap<>();

    // 构造方法私有，外界不能自行创建对象
    private R() {
    };

    // 成功
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.success);
        r.setMessage("成功");
        return r;
    }

    // 失败
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.error);
        r.setMessage("失败");
        return r;
    }

    // 响应消息
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    // 响应状态码
    public  R code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 设置单个响应数据
    public R data(String key,Object value) {
        this.data.put(key,value);
        return this;
    }

    // 响应数据是map集合
    public R data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }
}
