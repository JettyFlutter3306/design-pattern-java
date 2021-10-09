package cn.element.chain_responsibility.filter;

import cn.element.chain_responsibility.Filter;
import cn.element.chain_responsibility.Message;

public class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Message message) {

        String msg = message.getMsg();

        String s = msg.replace("996", "955");

        message.setMsg(s);

        return false;
    }
}
