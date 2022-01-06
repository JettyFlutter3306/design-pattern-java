package cn.element.observer.mouse;

import java.lang.reflect.Method;

/**
 * 标准事件格式的定义
 */
public class Event {

    private Object source;  //事件源,动作的发出者
    private final EventListener target;  //事件触发,要通知谁
    private final Method callback;  //观察者的回应
    private String trigger;  //事件的名称
    private long time;  //事件的触发时间

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public EventListener getTarget() {
        return target;
    }

    public Method getCallback() {
        return callback;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback.getName() +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
