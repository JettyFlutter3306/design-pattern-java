package cn.element.chainresponsibility.filter;

import cn.element.chainresponsibility.Filter;
import cn.element.chainresponsibility.Message;

public class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Message message) {

        String msg = message.getMsg();

        String s = msg.replaceAll("<", "[")
                .replaceAll(">", "]");

        message.setMsg(s);

        return true;
    }
}
