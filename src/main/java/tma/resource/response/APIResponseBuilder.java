package tma.resource.response;

public class APIResponseBuilder<T> {
    private String status;
    private Integer code;
    private String message;
    private T data;

    public APIResponseBuilder<T> status(String status) {
        this.status = status;
        return this;
    }

    public APIResponseBuilder<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public APIResponseBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public APIResponseBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    public APIResponse<T> build() {
        return new APIResponse<>(status, code, message, data);
    }
}