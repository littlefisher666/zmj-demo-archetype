#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author jinyanan
 */
@Slf4j
@SpringBootApplication
@MapperScan("${groupId}.**.mapper")
public class ${artifactIdCamelCaseZmjRemove}Application {
    public static void main(String[] args) {
        SpringApplication.run(${artifactIdCamelCaseZmjRemove}Application.class, args);
        log.info("SpringApplication run.");
    }
}
