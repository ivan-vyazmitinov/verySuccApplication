package com.succApplication.model;

import static java.util.Collections.singletonList;

public class ApiResponse<T> {

    private final T response;

    public ApiResponse(T response) {
        this.response = response;
    }

    public static <T> ApiResponse<T> answer(T value) {
        return new ApiResponse<>(value);
    }

    public T getResponse() {
        return response;
    }
}
