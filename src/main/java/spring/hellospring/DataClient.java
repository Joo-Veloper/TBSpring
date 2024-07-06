package spring.hellospring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.hellospring.order.Order;


import java.math.BigDecimal;

public class DataClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        EntityManagerFactory emf = beanFactory.getBean(EntityManagerFactory.class);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();// 트랜젝션 시작

        Order order = new Order("100", BigDecimal.TEN);
        em.persist(order);

        System.out.println(order);

        em.getTransaction().commit(); // 앞에서 일어난일 저장

        em.close();
    }
}
