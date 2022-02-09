package cn.element.visitor.kpi;

import java.util.LinkedList;
import java.util.List;

/**
 * 员工业务报表类
 */
public class BusinessReport {

    private final List<Employee> employees = new LinkedList<>();

    public BusinessReport() {
        employees.add(new Manager("经理-A"));
        employees.add(new Engineer("工程师-A"));
        employees.add(new Engineer("工程师-B"));
        employees.add(new Engineer("工程师-C"));
        employees.add(new Manager("经理-B"));
        employees.add(new Engineer("工程师-D"));
    }

    /**
     * 为访问者展示报表类
     * @param visitor 公司的高层,如CEO,CTO
     */
    public void showReport(IVisitor visitor) {
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}
