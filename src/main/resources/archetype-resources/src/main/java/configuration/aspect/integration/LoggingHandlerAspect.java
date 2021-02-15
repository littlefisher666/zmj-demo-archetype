#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.configuration.aspect.integration;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jinyanan
 * @since 2020/8/17 08:37
 */
@Slf4j
@Aspect
@Component
public class LoggingHandlerAspect {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * aop处理 controller出入参打印
     *
     * @param jp jp
     * @return Object
     * @throws Throwable Throwable
     */
    @Around(
        value = "@within(org.springframework.web.bind.annotation.RestController) && execution(* ${groupId}..*.controller..*(..))")
    public Object aroundMethod(final ProceedingJoinPoint jp) throws Throwable {
        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        Method method = methodSignature.getMethod();
        Class<?> clazz = jp.getTarget().getClass();
        String clazzName = clazz.getSimpleName();
        Object[] args = jp.getArgs();
        // 由于日志打印时，如果直接把数组放在logger方法中，仅会打印数组中的第一个元素，所以这里把数组转为集合来处理
        if (log.isInfoEnabled()) {
            log.info("{}${symbol_pound}{}入参为${symbol_escape}n{}", clazzName, method.getName(), Arrays.stream(args).map(this::encode)
                .collect(Collectors.toList()));
        }
        Object result = jp.proceed();
        if (log.isDebugEnabled()) {
            log.debug("{}${symbol_pound}{}出参为${symbol_escape}n{}", clazzName, method.getName(), encode(result));
        }
        return result;
    }

    private String encode(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return StringUtils.EMPTY;
        }
    }
}
