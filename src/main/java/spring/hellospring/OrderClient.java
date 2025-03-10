package spring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.hellospring.order.Order;
import spring.hellospring.order.OrderService;
import spring.hellospring.order.OrderServiceImpl;


import java.math.BigDecimal;

public class OrderClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderService service = beanFactory.getBean(OrderService.class);


        Order order = service.createOrder("0100", BigDecimal.TEN);
        System.out.println(order);
    }
}
