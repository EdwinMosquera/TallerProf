package co.edu.poli.ces4.movie.helper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private Integer code;
    private Object data;
}
