package cn.element.chainresponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    private final List<Filter> list;

    public FilterChain() {

        this.list = new ArrayList<>();
    }

    public FilterChain addFilter(Filter filter) {

        this.list.add(filter);

        return this;
    }

    @Override
    public boolean doFilter(Message message) {

        for (Filter filter : list) {
            if (!filter.doFilter(message)) {
                return false;
            }
        }

        return true;
    }
}
