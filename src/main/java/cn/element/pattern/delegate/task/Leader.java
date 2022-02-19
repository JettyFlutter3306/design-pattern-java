package cn.element.pattern.delegate.task;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目经理
 */
public class Leader implements IEmployee {

    private final Map<String, IEmployee> map = new HashMap<>();

    public Leader() {
        map.put("爬虫", new EmployeeA());
        map.put("海报图", new EmployeeB());
    }

    @Override
    public void doing(String task) {
        if (map.containsKey(task)) {
            map.get(task).doing(task);
        } else {
            System.out.println("这个任务: " + task + "超出我的能力范围");
        }
    }
}
