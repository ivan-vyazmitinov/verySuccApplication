package com.succapplication.model;  //название пакета полный отстой! почитай clean code

public class ApiResponse<T> {

    private final T response;

    public ApiResponse(T response) {
        this.response = response;
    }   // если у тебя есть паблик статик метод для создания,
    // то зачем тебе тут паблик? этот метод должен быть private

    public static <T> ApiResponse<T> answer(T value) {
        return new ApiResponse<>(value);
    }

    public T getResponse() {
        return response;
    }
}
