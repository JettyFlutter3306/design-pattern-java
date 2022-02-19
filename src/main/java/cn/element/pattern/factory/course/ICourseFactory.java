package cn.element.pattern.factory.course;

import cn.element.pattern.factory.simple.detail.ICourse;

/**
 * 使用工厂方法模式实现产品扩展
 */
public interface ICourseFactory {

    ICourse create();
}
