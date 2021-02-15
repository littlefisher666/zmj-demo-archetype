#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.configuration.advice;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ${package}.base.ExceptionEnum;
import ${package}.base.Response;
import ${package}.exception.${artifactIdCamelCaseZmjRemove}Exception;

import lombok.extern.log4j.Log4j2;

/**
 * @author jinyanan
 * @since 2020/5/22 15:12
 */
@Log4j2
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response<Void> handleException(Exception ex) {
        log.error("内部异常", ex);
        return Response.fail(ExceptionEnum.BUSINESS_BUSY.getCode());
    }

    @ExceptionHandler(${artifactIdCamelCaseZmjRemove}Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response<Void> handle${artifactIdCamelCaseZmjRemove}Exception(${artifactIdCamelCaseZmjRemove}Exception ex) {
        log.error("内部异常", ex);
        return Response.fail(ex.getCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response<Void> handleValidationException(MethodArgumentNotValidException e) {
        log.error("RequestBody参数校验失败", e);
        String errorMessage = e.getBindingResult().getAllErrors().stream().map(input -> {
            if (input instanceof FieldError) {
                FieldError fieldError = (FieldError) input;
                String field = fieldError.getField();
                return field + input.getDefaultMessage();
            }
            return input.getDefaultMessage();
        }).collect(Collectors.joining(","));
        return Response.fail(errorMessage);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response<Void> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("参数校验异常", e);
        String errorMessage = e.getParameterName() + e.getMessage();
        return Response.fail(errorMessage);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response<Void> handleMissingPathVariableException(MissingPathVariableException e) {
        log.error("参数校验异常", e);
        String errorMessage = e.getVariableName() + e.getMessage();
        return Response.fail(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response<Void> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("参数校验失败", e);
        String errorMessage = e.getConstraintViolations().stream().map(input -> {
            String message = input.getPropertyPath() + input.getMessage();
            if (input.getPropertyPath() instanceof PathImpl) {
                PathImpl propertyPath = (PathImpl) input.getPropertyPath();
                message = propertyPath.getLeafNode() + input.getMessage();
            }
            return message;
        }).collect(Collectors.joining(","));
        return Response.fail(errorMessage);
    }

}
