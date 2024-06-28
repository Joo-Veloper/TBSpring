package spring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService(); // abstract 클래스는 인스턴스를 직접 생성할 수 없지만, 이를 상속받은 구체적인 클래스를 통해 인스턴스를 생성할 수 있습니다
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
