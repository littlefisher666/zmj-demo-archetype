#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import ${package}.base.ExceptionEnum;

import lombok.Getter;

/**
 * 公共业务异常
 *
 * @author jinyanan
 */
@Getter
public class ${artifactIdCamelCaseZmjRemove}Exception extends RuntimeException {
    private final Integer code;

    public ${artifactIdCamelCaseZmjRemove}Exception(Integer code) {
        this.code = code;
    }

    public ${artifactIdCamelCaseZmjRemove}Exception(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public ${artifactIdCamelCaseZmjRemove}Exception(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ${artifactIdCamelCaseZmjRemove}Exception(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public ${artifactIdCamelCaseZmjRemove}Exception(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public ${artifactIdCamelCaseZmjRemove}Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
        Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

}
