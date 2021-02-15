#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author jinyanan
 */
@Data
@ConfigurationProperties("zmj.remote")
public class RemoteProperties {

    /** 各个微服务远程调用的url */
    private Map<String, String> url;
}
