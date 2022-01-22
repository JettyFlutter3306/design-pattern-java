package cn.element.adpater.common;

public class Client {

    public static void main(String[] args) {
        DC adapterDC = new PowerAdapterInterface(new AC220());
        DC5 adapter = new PowerAdapter();

        System.out.println(adapterDC.output5V());
        System.out.println(adapter.output5V());
    }

}
