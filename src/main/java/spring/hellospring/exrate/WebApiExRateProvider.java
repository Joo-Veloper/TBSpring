package spring.hellospring.exrate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import spring.hellospring.api.*;
import spring.hellospring.payment.ExRateProvider;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class WebApiExRateProvider implements ExRateProvider {
    ApiTemplate apiTemplate = new ApiTemplate();

    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        return apiTemplate.getExRate(url, new HttpClientApiExecutor(), new ErApiExRateExtractor()); //new SimpleApiExecutor() -> 콜백이고 , 아래 내부에 기능을 받아서 사용하는 것을 템플릿 이라고 합니다.
    }

}
