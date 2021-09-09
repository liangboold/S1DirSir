package com.bw.net.protocol;

/**
 * @package:com.bw.net.protocol
 * @fileName:BaseRespEntry
 * @date on:2021/9/9 8:38
 * @another:HG
 * @email:1572651596@qq.com
 */
public class BaseRespEntry<T> {
    private int code;
    private T data;
    private String msg;

    @Override
    public String toString() {
        return "BaseRespEntry{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public BaseRespEntry() {
    }

    public BaseRespEntry(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
