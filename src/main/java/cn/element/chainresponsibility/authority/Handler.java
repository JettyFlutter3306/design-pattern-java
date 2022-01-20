package cn.element.chainresponsibility.authority;

/**
 * 责任链模式和建造者模式结合使用
 */
public abstract class Handler<T> {

    protected Handler<T> chain;

    private void next(Handler<T> chain) {
        this.chain = chain;
    }

    public abstract void doHandle(Member member);

    public static class Builder<T> {
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler) {
            if (head == null) {
                head = tail = handler;
                return this;
            }

            tail.next(handler);
            tail = handler;

            return this;
        }

        public Handler<T> build() {
            return head;
        }
    }
}