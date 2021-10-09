package cn.element.chain_responsibility.filter;

import cn.element.chain_responsibility.Filter;
import cn.element.chain_responsibility.Message;

public class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Message message) {

        String msg = message.getMsg();

        String s = msg.replace(":)", "^v^");

        message.setMsg(s);

        return true;
    }
}
