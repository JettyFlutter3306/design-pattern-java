package cn.element.chainresponsibility.filter;

import cn.element.chainresponsibility.Filter;
import cn.element.chainresponsibility.Message;

public class URLFilter implements Filter {

    @Override
    public boolean doFilter(Message message) {

        String msg = message.getMsg();

        String s = msg.replace("腾讯课堂.com", "http://www.mashibing.com");

        message.setMsg(s);

        return true;
    }
}
