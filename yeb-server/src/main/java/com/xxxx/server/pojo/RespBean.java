package com.xxxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 公共返回对象
 *
 * @author zhangwei
 * @date 2022/06/05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }
    public static RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }
    public static RespBean error(String message,Object obj){
        return new RespBean(500,message,obj);
    }

}
