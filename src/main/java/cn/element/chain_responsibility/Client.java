package cn.element.chain_responsibility;

import cn.element.chain_responsibility.filter.FaceFilter;
import cn.element.chain_responsibility.filter.HTMLFilter;
import cn.element.chain_responsibility.filter.SensitiveFilter;
import cn.element.chain_responsibility.filter.URLFilter;

public class Client {

    public static void main(String[] args) {

        Message msg = new Message();
        msg.setMsg("大家好:),<script>,欢迎访问腾讯课堂.com,大家都是996</script>");

        FilterChain chain1 = new FilterChain();
        chain1.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());

        FilterChain chain2 = new FilterChain();
        chain2.addFilter(new FaceFilter())
                .addFilter(new URLFilter());

        chain1.addFilter(chain2);

        chain1.doFilter(msg);

        System.out.println(msg.getMsg());
    }
}
