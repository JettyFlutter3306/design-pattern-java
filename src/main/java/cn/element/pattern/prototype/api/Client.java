package cn.element.pattern.prototype.api;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        // 创建原型对象
        ConcretePrototype type = new ConcretePrototype("original");
        List<String> hobbies = new ArrayList<String>() {{
            add("书法");
            add("美术");
        }};

        type.setDesc("clone")
            .setName("洛必达")
            .setHobbies(hobbies);

        // 复制原型对象
        ConcretePrototype cloneType = type.deepClone();
        cloneType.getHobbies()
                 .add("技术宅");

        System.out.println("原型对象: " + type);
        System.out.println("克隆对象: " + cloneType);
        System.out.println(type == cloneType);

        System.out.println("原型对象的爱好: " + type.getHobbies());
        System.out.println("克隆对象的爱好: " + cloneType.getHobbies());
        System.out.println(type.getHobbies() == cloneType.getHobbies());



    }

}
