#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base;

import java.util.function.Function;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jinyanan
 * @since 2020/8/27 08:26
 */
@Getter
@AllArgsConstructor
public class PageParam {

    /** 分页页数 */
    private final Integer pageNum;

    /** 每页数量 */
    private final Integer size;

    /**
     * pageInfo泛型转换
     */
    public static <T, R> PageInfo<R> convert(PageInfo<T> pageInfo, Function<T, R> function) {
        Page<T> page = (Page<T>) pageInfo.getList();
        PageInfo<R> newPageInfo = page.toPageInfo(function::apply);
        newPageInfo.setTotal(page.getTotal());
        return newPageInfo;
    }

    public <T> PageInfo<T> nullPageInfo() {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(size);
        return pageInfo;
    }
}
