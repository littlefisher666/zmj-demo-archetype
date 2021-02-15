#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jinyanan
 * @since 2020/5/27 14:32
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    /* 成功状态码 */
    SUCCESS(1, "成功"),
    /* 服务器错误 */
    FAIL(0, "失败"),
    /* 参数错误：10001-19999 */
    PARAMETER_INVALID(10001, "参数无效"),
    PARAMETER_NULL(10002, "参数为空"),
    PARAMETER_TYPE_ERROR(10003, "参数类型错误"),
    PARAMETER_MISSING(10004, "参数缺失"),
    /* 用户错误：20001-29999*/
    NOT_LOGIN(20001, "用户未登录"),
    ACCOUNT_NOT_EXISTED(20002, "账号不存在或密码错误"),
    ACCOUNT_DELETED(20003, "账号已被删除"),
    ACCOUNT_NOT_PASS(20004, "账号未审核通过"),
    ACCOUNT_EXISTED(20005, "用户已存在"),
    /* 业务错误：30001-39999 */
    BUSINESS_ERROR(30001, "某业务出现问题"),
    /* 系统错误：40001-49999 */
    BUSINESS_BUSY(40001, "系统繁忙，请稍后重试"),
    /* 数据错误：50001-599999 */
    DATA_NOT_FOUND(50001, "数据未找到"),
    DATA_ERROR(50002, "数据有误"),
    DATA_EXISTED(50003, "数据已存在"),
    QUERY_ERROR(50004, "查询出错"),
    /* 接口错误：60001-69999 */
    INNER_ERROR(60001, "内部系统接口调用异常"),
    OUTER_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_NOT_ALLOW(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_ERROR(60004, "接口地址无效"),
    INTERFACE_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_LOAD_HIGH(60006, "接口负载过高"),
    /* 权限错误：70001-79999 */
    NOT_AUTH(70001, "无权限访问"),
    /* 远程错误：80001-89999 */
    REMOTE_IS_FAIL(80001, "远程调用失败"),
    ;
    private final int code;

    private final String message;

    public static ExceptionEnum parse(int code) {
        return Arrays.stream(ExceptionEnum.values()).filter(input -> input.getCode() == code).findFirst().orElse(null);
    }
}
