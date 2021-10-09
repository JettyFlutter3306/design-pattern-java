package cn.element.chain_responsibility.filter;

import cn.element.chain_responsibility.Filter;
import cn.element.chain_responsibility.Message;

public class URLFilter implements Filter {

    @Override
    public boolean doFilter(Message message) {

        String msg = message.getMsg();

        String s = msg.replace("腾讯课堂.com", "http://www.mashibing.com");

        message.setMsg(s);

        return true;
    }
}
