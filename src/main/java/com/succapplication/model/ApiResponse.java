package com.succapplication.model;

public class ApiResponse<T> {

    private final T response;

    private ApiResponse(T response) {
        this.response = response;
    }

    public static <T> ApiResponse<T> ok(T value) {
        return new ApiResponse<>(value);
    }

    public T getResponse() {
        return response;
    }
}
