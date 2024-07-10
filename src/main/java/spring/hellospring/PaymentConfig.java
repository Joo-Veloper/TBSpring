package spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import spring.hellospring.api.ApiTemplate;
import spring.hellospring.api.ErApiExRateExtractor;
import spring.hellospring.api.SimpleApiExecutor;
import spring.hellospring.exrate.RestTemplateExRateProvider;
import spring.hellospring.payment.ExRateProvider;
import spring.hellospring.exrate.WebApiExRateProvider;
import spring.hellospring.payment.PaymentService;

import java.time.Clock;

@Configuration // 메소드 호출을 여러번 하더라도 특별히 다른 지시가 없다면 딱 하나의 오브젝트만 생성되도록 만듬
//@ComponentScan
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    /*@Bean
    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(exRateProvider());
    }

    @Bean
    public ExRateProvider cashedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }*/
}
/*
class OrderServiceImpl{
    ExRateProvider exRateProvider;

    public OrderServiceImpl(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }
}*/
