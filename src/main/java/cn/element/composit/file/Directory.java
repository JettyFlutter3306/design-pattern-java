package cn.element.composit.file;

/**
 * 使用安全组合模式实现无限文件系统
 *
 * 文件系统有两个大的层次: 文件夹和文件,其中,文件夹能容纳其他层次
 * 为树枝节点,文件是最小的单位,为叶子节点.由于目录西永层次较少,而且
 * 树枝节点(文件夹)结构相对稳定,而文件其实可以有很多类型,所以使用安全
 * 组合模式来实现目录系统,可以避免为叶子节点类型(文件)引入冗余方法
 */
public abstract class Directory {

    protected final String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}
