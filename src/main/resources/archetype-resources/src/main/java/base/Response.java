#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author amj
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Response<T> implements Serializable {

    /**
     * 是否成功，true-成功，false-失败
     */
    private Boolean success;
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述信息
     */
    private String message;

    /**
     * 业务数据
     */
    private T data;

    private static <T> Response<T> generate(boolean success, ExceptionEnum response, T data) {
        return Response.<T>builder().success(success).code(response.getCode()).message(response.getMessage()).data(data)
            .build();
    }

    public static <T> Response<T> success(T data) {
        return generate(true, ExceptionEnum.SUCCESS, data);
    }

    public static <T> Response<T> success() {
        return generate(true, ExceptionEnum.SUCCESS, null);
    }

    public static <T> Response<T> fail(Integer status) {
        return generate(false, ExceptionEnum.parse(status), null);
    }

    public static <T> Response<T> fail(T data) {
        return generate(false, ExceptionEnum.FAIL, data);
    }

    public static <T> Response<T> fail(ExceptionEnum response) {
        return generate(false, response, null);
    }

    public static <T> Response<T> fail(Integer code, String message) {
        return Response.<T>builder().success(false).code(code == null ? ExceptionEnum.FAIL.getCode() : code).message(
            message).build();
    }

    public static <T> Response<T> fail(String message) {
        return fail(null, message);
    }
}
