package spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.hellospring.exrate.WebApiExRateProvider;
import spring.hellospring.payment.ExRateProvider;
import spring.hellospring.payment.ExRateProviderStub;
import spring.hellospring.payment.PaymentService;

import java.math.BigDecimal;

@Configuration // 메소드 호출을 여러번 하더라도 특별히 다른 지시가 없다면 딱 하나의 오브젝트만 생성되도록 만듬
//@ComponentScan
public class TestObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }
}

