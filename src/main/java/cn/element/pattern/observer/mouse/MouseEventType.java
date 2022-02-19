package cn.element.pattern.observer.mouse;

/**
 * 鼠标事件类型接口
 */
public interface MouseEventType {

    String ON_CLICK = "click";  //单击
    String ON_DOUBLE_CLICK = "doubleClick";  //双击
    String ON_UP = "up";  //弹起
    String ON_DOWN = "down";  //按下
    String ON_MOVE = "move";  //移动
    String ON_WHEEL = "wheel";  //滚动
    String ON_OVER = "over";  //悬停
    String ON_BLUR = "blur";  //失去焦点
    String ON_FOCUS = "focus";  //获得焦点
}
