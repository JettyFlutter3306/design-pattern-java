package cn.element.chainresponsibility.common;

public class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("requestA".equals(request)) {
            System.out.println(getClass().getSimpleName() + " deal with request: " + request);
            return;
        }

        if (next != null) {
            next.handleRequest(request);
        }
    }
}
