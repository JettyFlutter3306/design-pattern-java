package cn.element.chainresponsibility.filter;

import cn.element.chainresponsibility.Filter;
import cn.element.chainresponsibility.Message;

public class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Message message) {

        String msg = message.getMsg();

        String s = msg.replace("996", "955");

        message.setMsg(s);

        return false;
    }
}
