package spring.hellospring.payment;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PaymentServiceTest {
    @Test
    void convertedAmount() throws IOException {
        testAmount(valueOf(500), valueOf(5000));
        testAmount(valueOf(1000), valueOf(10000));
        testAmount(valueOf(3000), valueOf(30000));

        // 원화 환산 금액 유효시간 계산
       /* assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));*/
    }

    private void testAmount(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate));

        Payment payment = paymentService.prepare(1L, "USD", TEN);
        // 환율정보 가져온다.
        assertThat(payment.getExRate()).isEqualTo(exRate); //equal사용은 위험할 수 있다. BigDecimal에서 권장하는건 comparing tofmf r
        // 원화 환산 금액 계산
        assertThat(payment.getConvertedAmount()).isEqualTo(convertedAmount);
    }
}