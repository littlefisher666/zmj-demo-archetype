#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author jinyanan
 */
@Configuration
@EnableConfigurationProperties(RemoteProperties.class)
public class RemoteConfiguration {
}
