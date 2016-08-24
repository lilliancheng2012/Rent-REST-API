package nz.co.zufang.controller;

/**
 * Created by Mark on 2/25/2016.
 */
public class GenericResponse {
    String code;
    String message;
    String token;

    public String getCode() {
        return code;
    }

    public GenericResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GenericResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getToken() {
        return token;
    }

    public GenericResponse setToken(String token) {
        this.token = token;
        return this;
    }

}