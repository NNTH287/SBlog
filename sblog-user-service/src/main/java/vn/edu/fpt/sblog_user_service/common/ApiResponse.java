package vn.edu.fpt.sblog_user_service.common;

public record ApiResponse<T>(int status, String message, T data) {
}
