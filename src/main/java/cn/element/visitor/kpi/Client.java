package cn.element.visitor.kpi;

public class Client {

    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=============CEO查看报表===========");
        report.showReport(new CEOVisitor());

        System.out.println("=============CTO查看报表===========");
        report.showReport(new CTOVisitor());
    }

}
