package spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import spring.hellospring.data.JpaOrderRepository;
import spring.hellospring.order.OrderRepository;
import spring.hellospring.order.OrderService;

@Configuration
@Import(DataConfig.class)
public class OrderConfig {
    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository();
    }
    @Bean
    public OrderService orderService(JpaTransactionManager transactionManager){
        return new OrderService(orderRepository(),transactionManager);
    }
}
