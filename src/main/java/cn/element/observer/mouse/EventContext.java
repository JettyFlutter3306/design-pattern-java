package cn.element.observer.mouse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 被观察者的抽象
 */
public abstract class EventContext {

    protected final Map<String, Event> eventMap = new HashMap<>();

    public void addListener(String eventType, EventListener target, Method callback) {
        eventMap.put(eventType, new Event(target, callback));
    }

    public void addListener(String eventType, EventListener target) {
        try {
            addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    private void trigger(Event event) {
        event.setSource(this)
                .setTime(System.currentTimeMillis());

        try {
            if (event.getCallback() != null) {
                event.getCallback().invoke(event.getTarget(), event);  //使用反射调用回调函数
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String trigger) {
        if (!eventMap.containsKey(trigger)) {
            return;
        }

        trigger(eventMap.get(trigger).setTrigger(trigger));
    }
}
