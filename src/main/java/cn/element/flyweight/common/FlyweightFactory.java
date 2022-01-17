package cn.element.flyweight.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class FlyweightFactory {

    private static final Map<String, IFlyweight> pool = new HashMap<>();

    /**
     * 从缓存中获取对象,没有就创建
     * @param intrinsicState            对象的关键字
     */
    public static IFlyweight getFlyweight(String intrinsicState) {
        if (!pool.containsKey(intrinsicState)) {
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState, flyweight);
        }

        return pool.get(intrinsicState);
    }
}
