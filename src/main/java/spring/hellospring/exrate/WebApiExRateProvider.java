package spring.hellospring.exrate;

import org.springframework.stereotype.Component;
import spring.hellospring.api.ApiTemplate;
import spring.hellospring.payment.ExRateProvider;

import java.math.BigDecimal;

@Component
public class WebApiExRateProvider implements ExRateProvider {

    private final ApiTemplate apiTemplate;

    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {

        String url = "https://open.er-api.com/v6/latest/" + currency;

        return apiTemplate.getForExRate(url); //new SimpleApiExecutor() -> 콜백이고 , 아래 내부에 기능을 받아서 사용하는 것을 템플릿 이라고 합니다.
    }

}
