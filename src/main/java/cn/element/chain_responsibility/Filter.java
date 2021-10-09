package cn.element.chain_responsibility;

public interface Filter {

    boolean doFilter(Message message);
}
