package cn.element.factory.course;

import cn.element.factory.simple.detail.ICourse;

/**
 * 使用工厂方法模式实现产品扩展
 */
public interface ICourseFactory {

    ICourse create();
}
