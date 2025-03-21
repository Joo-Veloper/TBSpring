package spring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.hellospring.payment.Payment;
import spring.hellospring.payment.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(PaymentConfig.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);

//        OrderServiceImpl orderService = beanFactory.getBean(OrderServiceImpl.class);
//        System.out.println(orderService.exRateProvider == orderService.exRateProvider);

        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("payment = " + payment);
        /*System.out.println("------------------------------------\n");

        TimeUnit.SECONDS.sleep(1);

        Payment payment2 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("payment2 = " + payment2);
        System.out.println("------------------------------------\n");

        TimeUnit.SECONDS.sleep(2);

        Payment payment3 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println("payment3 = " + payment3);*/
    }
}