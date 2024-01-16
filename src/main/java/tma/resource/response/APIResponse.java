package tma.resource.response;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class APIResponse<T> {
    private final String status;
    private final Integer code;
    private final String message;
    private final T data;

    protected APIResponse(String status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private static <T> APIResponseBuilder<T> builder() {
        return new APIResponseBuilder<>();
    }

    public static <T> ResponseEntity<APIResponse<T>> response(
        HttpStatus status,
        @Nullable String message,
        @Nullable T data
    ) {
        APIResponse<T> response = APIResponse
            .<T>builder()
            .status(status.name())
            .code(status.value())
            .message(message != null ? message : "no message")
            .data(data)
            .build();

        return ResponseEntity.status(status).body(response);
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}