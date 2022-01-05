package cn.element.adpater;

import java.io.*;

/**
 * 设计模式之 适配器模式 Adapter
 */
public class Client {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("src/main/resources/test.txt");

        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);

        String line = "";

        while ((line = br.readLine()) != null && !line.equals("")) {
            System.out.println(line);
        }

        br.close();

    }
}
