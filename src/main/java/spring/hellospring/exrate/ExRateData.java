package spring.hellospring.exrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;
// record = 한번 값을 넣은 다음 수정 불가 -> 한번 값을 저장해 두고 저장한 값을 계속 이용하는 것에 사용!

@JsonIgnoreProperties(ignoreUnknown = true) //JsonIgnoreProperties를 사용하면 여기에 없는 거 Json에 들어와도 무시
public record ExRateData(String result, Map<String, BigDecimal> rates) {

}
