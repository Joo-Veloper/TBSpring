package spring.hellospring.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    // 주문번호
    private Long orderId;
    // 외국 통화 종류
    private String currency;
    // 오국 통화 기준 결제 금액
    // Double, float 사용 x 결제할때 소숫점 오류 있을수 있기에 BigDecimal 사용 !
    private BigDecimal foreignCurrencyAmount;
    // 젹용 환율
    private BigDecimal exRate;
    // 원화 환산금액
    private BigDecimal convertedAmount;
    // 원화 환산 금액 유효시간
    private LocalDateTime validUntil;


    // 생성자 생성 하는 것의 단점 파라미터로 쭉 나열을 해야 하는데, 이럴 경우에 같은 경우의 타입이 연속으로 나오면 실수할 수 있다.
    public Payment(Long orderId, String currency, BigDecimal foreignCurrencyAmount, BigDecimal exRate, BigDecimal convertedAmount, LocalDateTime validUntil) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exRate = exRate;
        this.convertedAmount = convertedAmount;
        this.validUntil = validUntil;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exRate +
                ", convertedAmount=" + convertedAmount +
                ", validUntil=" + validUntil +
                '}';
    }
}
