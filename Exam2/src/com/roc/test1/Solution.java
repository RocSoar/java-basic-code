package com.roc.test1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws DocumentException {
        File file = new File("Exam2/orders.xml");
        SAXReader reader = new SAXReader();
        List<Order> orders = new ArrayList<>();

        Document document = reader.read(file);

//        只能在src目录下找文件, 但是能做到比较好的解耦
//        Document document = reader.read(Solution.class.getResourceAsStream("/orders.xml"));

        Element rootElement = document.getRootElement();

        List<Element> elements = rootElement.elements("order");

        for (Element e : elements) {
            orders.add(new Order(Integer.parseInt(e.attributeValue("id")), e.elementText("name"), Double.parseDouble(e.elementText("price")), e.elementText("time")));
        }

        orders.stream().filter(o -> o.getDateTime().isBefore(LocalDateTime.of(2023, 8, 8, 12, 0))).forEach(o -> System.out.println(o));

        Order order = orders.stream().max((a, b) -> Double.compare(a.getPrice(), b.getPrice())).get();
        System.out.println("最贵的订单是: " + order);

        System.out.println("-------价格降序排列---------");
        orders.stream().sorted((a, b) -> Double.compare(b.getPrice(), a.getPrice())).forEach(o -> System.out.println(o));
    }
}
