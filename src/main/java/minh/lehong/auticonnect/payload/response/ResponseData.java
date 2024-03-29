package minh.lehong.auticonnect.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponseData<T> {
    @JsonProperty("data")
    private T data;

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("message")
    private String message;
}
