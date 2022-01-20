package cn.element.chainresponsibility.common;

public class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("requestB".equals(request)) {
            System.out.println(getClass().getSimpleName() + " deal with request: " + request);
            return;
        }

        if (next != null) {
            next.handleRequest(request);
        }
    }
}
