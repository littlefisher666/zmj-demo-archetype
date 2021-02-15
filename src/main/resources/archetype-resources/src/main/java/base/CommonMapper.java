#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author jinyanan
 * @since 2020/9/1 15:14
 */
public interface CommonMapper<T> extends BaseMapper<T>, ExampleMapper<T>, MySqlMapper<T> {
}
