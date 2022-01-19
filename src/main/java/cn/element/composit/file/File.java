package cn.element.composit.file;

public class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}
