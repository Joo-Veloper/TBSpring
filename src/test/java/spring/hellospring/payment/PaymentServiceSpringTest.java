package spring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.hellospring.TestPaymentConfig;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class) // 컨테이너 테스트
class PaymentServiceSpringTest {
    @Autowired
    PaymentService paymentService; // wired 의존관계 주입하는걸 스프링에서 wired라고 하며 자동으로 해달라고 할때 autowired 사용!
    @Autowired
    Clock clock;
    @Autowired
    ExRateProviderStub exRateProviderStub;

    @Test
    void convertedAmount() {
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
    @Test
    void validUntil() {
        Payment payment = paymentService.prepare(1L, "USD", TEN);

        //valid until이 prepare() 30분 뒤로 설정 되었는가?
        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);


        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }

}