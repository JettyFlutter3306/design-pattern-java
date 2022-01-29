package cn.element.prototype.api;

import java.io.*;
import java.util.List;

/**
 * 使用JavaAPI来实现原型模式
 * super.clone()方法直接从堆内存中以二进制流的方式来进行复制
 * 重新分配一个内存块,因此其效率很高,由于super.clone()方法
 * 基于内存复制,因此不会调用对象的构造函数,也就是不需要经过初始化过程.
 * 但是super.clone()方法是浅拷贝,会产生风险.
 */
public class ConcretePrototype implements Cloneable, Serializable {

    private String desc;
    private String name;
    private List<String> hobbies;

    public ConcretePrototype(String desc) {
        this.desc = desc;
    }

    @Override
    protected ConcretePrototype clone() throws CloneNotSupportedException {
        ConcretePrototype cloneType = null;

        try {
            cloneType = (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return cloneType;
    }

    public ConcretePrototype deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ConcretePrototype) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDesc() {
        return desc;
    }

    public ConcretePrototype setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getName() {
        return name;
    }

    public ConcretePrototype setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public ConcretePrototype setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
