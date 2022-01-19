package cn.element.composit.file;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Directory {

    private final List<Directory> directories;

    private final Integer level;

    public Folder(String name, int level) {
        super(name);
        this.level = level;
        this.directories = new ArrayList<>();
    }

    public Folder add(Directory directory) {
        directories.add(directory);
        return this;
    }

    public Folder remove(Directory directory) {
        directories.remove(directory);
        return this;
    }

    public Directory get(int index) {
        return directories.get(index);
    }

    public void list() {
        for (Directory directory : directories) {
            System.out.println(directory.name);
        }
    }

    @Override
    public void show() {
        System.out.println(name);

        for (Directory directory : directories) {
            // 控制显示格式
            if (level != null) {
                for (int i = 0; i < level; i++) {
                    // 打印控制显示格式
                    System.out.print(" ");
                }

                for (int i = 0; i < level; i++) {
                    // 每一行开始打印一个+号
                    if (i == 0) {
                        System.out.print("+");
                    }

                    System.out.print("-");
                }
            }

            // 打印名称
            directory.show();
        }
    }


}
