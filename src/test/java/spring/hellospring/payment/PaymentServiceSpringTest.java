package spring.hellospring.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.hellospring.ObjectFactory;
import spring.hellospring.TestObjectFactory;

import java.io.IOException;
import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestObjectFactory.class) // 컨테이너 테스트
class PaymentServiceSpringTest {
    @Autowired
    PaymentService paymentService; // wired 의존관계 주입하는걸 스프링에서 wired라고 하며 자동으로 해달라고 할때 autowired 사용!

    @Autowired
    ExRateProviderStub exRateProviderStub;

    @Test
    void convertedAmount() throws IOException {
        // exRate:1000
        Payment payment = paymentService.prepare(1L, "USD", TEN);
        assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));


        // exRate:500
        exRateProviderStub.setExRate(valueOf(500));
        Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment2.getExRate()).isEqualByComparingTo(valueOf(500)); //equal사용은 위험할 수 있다. BigDecimal에서 권장하는건 comparing tofmf r
        // 원화 환산 금액 계산
        assertThat(payment2.getConvertedAmount()).isEqualByComparingTo(valueOf(5_000));

        // 원화 환산 금액 유효시간 계산
       /* assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));*/
    }
}