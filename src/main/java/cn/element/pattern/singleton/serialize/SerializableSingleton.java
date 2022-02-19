package cn.element.pattern.singleton.serialize;

import java.io.Serializable;

/**
 * 反序列化破坏了单例模式
 */
public class SerializableSingleton implements Serializable {

    /*
    序列化就是把内存中的状态通过转换成字节码的形式
    从而转换为一个I/O流,写入其他的地方(可以是磁盘,网络I/O)
    内存中的状态会被永久保存下来
    反序列化就是将已经持久化的字节码内容换成I/O流
    通过I/O流的读取,进而将读取的内容转换成Java对象
    在转换的过程中会重新创建对象

    只需要增加readResolve()方法即可保证在序列化的情况下也能够实现单例模式
     */
    public static final SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {

    }

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

}
