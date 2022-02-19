package cn.element.pattern.templatemethod.hook;

/**
 * 使用模板方法模式解决实际问题
 */
public abstract class AbstractCourse {

    public final void createCourse() {
        // 1.发布预习资料
        postPreResource();

        // 2.制作可见资料
        createPPT();

        // 3.在线直播
        liveVideo();

        // 4.上传课后资料
        postResource();

        // 5.布置作业
        postHomework();

        if (needCheckHomework()) {
            checkHomework();
        }
    }

    protected abstract void checkHomework();

    /**
     * 钩子方法
     */
    protected boolean needCheckHomework() {
        return false;
    }

    protected void postHomework() {
        System.out.println("布置作业");
    }

    protected void postResource() {
        System.out.println("上传课后资料");
    }

    protected void liveVideo() {
        System.out.println("直播授课");
    }

    protected void createPPT() {
        System.out.println("制作课件");
    }

    protected void postPreResource() {
        System.out.println("发布预习资料");
    }
}