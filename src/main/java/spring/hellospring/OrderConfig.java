package spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.hellospring.data.JdbcOrderRepository;
import spring.hellospring.order.OrderRepository;
import spring.hellospring.order.OrderService;
import spring.hellospring.order.OrderServiceImpl;


import javax.sql.DataSource;

@Configuration
@Import(DataConfig.class)
@EnableTransactionManagement //트렌잭션 관리 기능
public class OrderConfig {
    @Bean
    public OrderRepository orderRepository(DataSource dataSource) {
        return new JdbcOrderRepository(dataSource);
    }
    @Bean
    public OrderService orderService(
            PlatformTransactionManager transactionManager,
            OrderRepository orderRepository
    ){
        return new OrderServiceImpl(orderRepository);
    }
}
