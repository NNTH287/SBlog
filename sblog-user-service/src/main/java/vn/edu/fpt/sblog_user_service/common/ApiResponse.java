package vn.edu.fpt.sblog_user_service.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
}
