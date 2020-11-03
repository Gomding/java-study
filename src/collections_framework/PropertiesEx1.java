package collections_framework;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx1 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        //prop에 키와 값 (key, value)를 저장한다,
        prop.setProperty("timeout", "30");
        prop.setProperty("language", "kr");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        //prop에 저장된 요소들을 Enumeration을 이용해서 출력한다.
        Enumeration e = prop.propertyNames();

        while (e.hasMoreElements()) {
            String element = (String)e.nextElement();
            System.out.println(element + "=" + prop.getProperty(element));
        }

        System.out.println();
        prop.setProperty("size", "20");
        System.out.println("size=" + prop.getProperty("size"));
        System.out.println("capacity=" + prop.getProperty("capacity"));
        System.out.println("loadfactor=" + prop.getProperty("loadfactor", "0.75"));

        System.out.println(prop);
        prop.list(System.out);
    }
}
