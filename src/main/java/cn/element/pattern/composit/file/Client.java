package cn.element.pattern.composit.file;

public class Client {

    public static void main(String[] args) {
        System.out.println("===============安全组合模式==============");

        File qq = new File("QQ.exe");
        File wx = new File("Wechat.exe");

        Folder office = new Folder("办公软件", 2);

        File word = new File("Word.exe");
        File ppt = new File("PowerPoint.exe");
        File excel = new File("Excel.exe");

        office.add(word)
              .add(ppt)
              .add(excel);

        Folder wps = new Folder("金山软件", 3);
        wps.add(new File("WPS.exe"));
        office.add(wps);

        Folder root = new Folder("根目录", 1);
        root.add(qq)
            .add(wx)
            .add(office);

        System.out.println("==================show()方法效果=================");
        root.show();

        System.out.println("==================list()方法效===================");
        root.list();
    }

}
