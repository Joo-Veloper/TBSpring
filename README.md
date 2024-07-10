### 오브젝트와 클래스의 관계

**오브젝트**(객체)는 객체지향 프로그래밍(OOP, Object-Oriented Programming)의 핵심 개념입니다. 우리가 코딩할 때 만드는 것은 보통 클래스인데, 클래스는 오브젝트를 만들어내기 위한 설계도입니다. 클래스는 코드를 작성할 때 정의되지만, 오브젝트는 프로그램이 실행될 때 동적으로 생성되고 동작합니다.

### 클래스와 오브젝트의 차이점

- **클래스**: 오브젝트를 만들기 위한 청사진. 예를 들어, 건물을 짓기 위한 설계도입니다. 클래스를 정의하면 그 안에 어떤 속성과 메서드가 포함될지를 명시합니다.
- **오브젝트**: 클래스의 인스턴스로, 프로그램이 실행될 때 생성되어 실제로 동작하는 존재. 건물의 설계도에 따라 실제로 지어진 건물입니다.

클래스를 작성하는 코드는 프로그램이 실행될 때 오브젝트로 변환되며, 이 오브젝트가 실제로 우리가 원하는 기능을 수행합니다.

### 클래스의 인스턴스

클래스의 인스턴스는 오브젝트입니다. 인스턴스는 추상적인 클래스를 기반으로 실제로 만들어진 구체적인 실체를 의미합니다. 예를 들어, `House`라는 클래스가 있다면, 이 클래스로부터 만들어진 각각의 집들이 인스턴스입니다.

자바에서의 오브젝트는 클래스의 인스턴스 또는 배열입니다. 배열은 클래스 인스턴스는 아니지만 자바에서는 오브젝트로 취급됩니다.

**요약**:
- 클래스: 오브젝트를 정의하는 설계도
- 오브젝트: 클래스의 인스턴스, 실제로 프로그램이 실행될 때 동작하는 실체

### 의존 관계 (Dependency)

의존 관계는 하나의 오브젝트나 클래스가 다른 오브젝트나 클래스를 필요로 하는 관계를 말합니다. 의존 관계를 다이어그램으로 표현할 때, `A ---> B`는 A가 B에 의존하고 있다는 의미입니다.

### 클래스 간의 의존 관계

클래스 간의 의존 관계는 코드 레벨에서 발생합니다. 클라이언트 클래스가 서플라이어 클래스를 사용하면, 클라이언트 클래스는 서플라이어 클래스에 의존한다고 말할 수 있습니다. 클라이언트 클래스 코드가 제대로 동작하려면 서플라이어 클래스 코드가 존재해야 합니다.

### 오브젝트 간의 의존 관계

오브젝트 간의 의존 관계는 런타임에서 발생합니다. 프로그램 실행 중에 오브젝트가 다른 오브젝트에게 기능을 요청하거나 작업을 맡기는 경우, 이들 사이에 의존 관계가 형성됩니다. 이는 실제 프로그램이 실행되는 동안의 동적인 관계입니다.

### 의존 관계의 영향

클라이언트 클래스가 서플라이어 클래스에 의존하면, 서플라이어 클래스가 변경될 때 클라이언트 클래스도 영향을 받을 수 있습니다. 이는 코드의 유지보수와 확장에 중요한 영향을 미칩니다.

**정리**:
- 클래스 간의 의존 관계: 코드 레벨에서 발생, 클라이언트 클래스가 서플라이어 클래스를 필요로 함
- 오브젝트 간의 의존 관계: 런타임에서 발생, 오브젝트가 다른 오브젝트의 기능을 필요로 함

스프링 프레임워크는 이러한 의존 관계를 관리하고 조절하는 데 중요한 역할을 합니다. 클래스와 오브젝트의 의존 관계를 효율적으로 관리하여 코드의 유연성과 재사용성을 높이는 것이 스프링의 핵심 원리 중 하나입니다.

---
### 관심사 불리  SOC
1. 관심사(Concern)란 무엇인가?
   관심사란 소프트웨어 시스템에서 특정한 기능이나 역할을 의미합니다. 예를 들어, 데이터베이스 접근, 사용자 인터페이스, 비즈니스 로직 등은 각각의 관심사로 볼 수 있습니다.

2. 관심사 분리의 필요성
   - 이해와 유지보수 용이성: 각각의 관심사가 독립적으로 분리되어 있으면, 코드를 이해하고 수정하는 것이 쉬워집니다.
   - 모듈성: 각 관심사를 모듈로 나누면, 특정 기능을 수정하거나 교체할 때 다른 부분에 영향을 주지 않고 작업할 수 있습니다.
   - 재사용성: 분리된 모듈은 다른 프로젝트에서도 쉽게 재사용할 수 있습니다.
   - 테스트 용이성: 개별 모듈을 독립적으로 테스트할 수 있어 테스트가 더 쉽고 철저하게 수행될 수 있습니다.
3. 관심사 분리 구현 방법
   - 레이어드 아키텍처(Layered Architecture): 시스템을 여러 계층으로 나누어 각 계층이 서로 다른 관심사를 처리합니다. 예를 들어, 프레젠테이션 계층, 비즈니스 로직 계층, 데이터 접근 계층 등이 있습니다.
   - 모듈화(Modularity): 관련 기능을 묶어 모듈을 만들고, 각 모듈이 독립적으로 동작하게 합니다.
   - MVC 패턴(Model-View-Controller): 애플리케이션을 모델, 뷰, 컨트롤러로 나누어 관심사를 분리합니다. 모델은 데이터와 비즈니스 로직을, 뷰는 사용자 인터페이스를, 컨트롤러는 사용자 입력을 처리합니다.
   - 서비스 지향 아키텍처(SOA) 및 마이크로서비스: 시스템을 독립적인 서비스로 분리하여 각 서비스가 독립적으로 개발, 배포, 유지보수될 수 있게 합니다.
4. 관심사 분리의 사례
   - 웹 애플리케이션: 프론트엔드와 백엔드를 분리하여 프론트엔드는 사용자 인터페이스를 담당하고, 백엔드는 데이터 처리 및 비즈니스 로직을 담당합니다.
   - 데이터베이스 접근: 데이터베이스 접근 코드를 별도의 레이어나 모듈로 분리하여 비즈니스 로직과 데이터 접근 로직이 섞이지 않도록 합니다.
   - 로그 관리: 애플리케이션 로깅을 별도의 모듈이나 서비스로 분리하여 주요 비즈니스 로직과 로그 관리 로직이 독립적으로 동작하도록 합니다.
5. 관심사 분리의 이점
   - 코드의 가독성 향상: 분리된 각 모듈이나 계층은 명확한 역할을 가지므로 코드가 더 읽기 쉬워집니다.
   - 변경 용이성: 한 부분의 변경이 다른 부분에 영향을 미치지 않으므로, 변경 작업이 더 쉬워집니다.
   - 협업 효율성 향상: 팀원들이 서로 다른 모듈이나 계층을 독립적으로 작업할 수 있어 개발 효율성이 높아집니다.
   - 버그 감소: 모듈화된 시스템에서는 버그가 발생할 수 있는 범위가 제한적이므로 버그의 발견과 수정이 더 쉽습니다.
---
# 원칙과 패턴

### 개방 폐쇄 원칙 (Open-Closed Principle, OCP)
- **정의**: 클래스나 모듈은 확장에는 열려 있어야 하고 변경에는 닫혀 있어야 한다.
- **설명**: 소프트웨어 시스템은 새로운 기능을 추가할 때 기존 코드를 변경하지 않고도 기능을 확장할 수 있어야 한다. 즉, 코드를 재작성하지 않고도 기능을 추가할 수 있도록 설계해야 한다.
- **예시**: 새로운 기능을 추가하기 위해 기존 클래스를 수정하는 대신, 해당 클래스를 상속하거나 인터페이스를 구현하는 방식으로 새로운 클래스를 작성하여 기능을 확장한다.

### 높은 응집도와 낮은 결합도
- **응집도**: 모듈 내의 구성 요소들이 얼마나 밀접하게 관련되어 있는지를 나타낸다.
   - **높은 응집도**: 모듈이 하나의 책임 또는 관심사에 집중되어 있어 변화가 일어날 때 모듈 내의 변경 범위가 작다. 코드 이해와 유지보수가 용이하며, 변화에 대한 비용이 적다.
- **결합도**: 모듈 간의 상호 의존성을 나타낸다.
   - **낮은 결합도**: 모듈 간의 의존성을 최소화하여 변화가 한 모듈에서 발생해도 다른 모듈에 미치는 영향을 줄인다. 코드 수정 시 영향을 받는 부분이 적어 유지보수가 용이하다.
- **설명**: 높은 응집도와 낮은 결합도를 유지함으로써 시스템의 모듈들이 독립적이고 변화에 강하며 유지보수하기 쉽게 만든다.

### 전략 패턴 (Strategy Pattern)
- **정의**: 필요에 따라 변경이 필요한 알고리즘을 인터페이스를 통해 외부로 분리하고, 이를 구현한 구체적인 알고리즘 클래스를 필요에 따라 바꿔 사용할 수 있게 하는 디자인 패턴.
- **설명**: 동일한 작업을 수행하는 여러 알고리즘을 정의하고, 클라이언트 코드에서 알고리즘을 선택하여 사용할 수 있도록 한다. 알고리즘을 정의하는 인터페이스와 이를 구현하는 구체적인 클래스로 구성된다.
- **예시**: 정렬 알고리즘을 사용하는 경우, 다양한 정렬 알고리즘(버블 정렬, 퀵 정렬 등)을 각각의 클래스에서 구현하고, 필요에 따라 클라이언트 코드에서 적절한 정렬 알고리즘을 선택하여 사용한다.

### 제어의 역전 (Inversion of Control, IoC)
- **정의**: 제어권을 클라이언트에서 프레임워크나 컨테이너로 이전하여 제어 관계를 역전시키는 원리.
- **설명**: 클라이언트 코드가 흐름을 제어하는 대신, 프레임워크나 컨테이너가 흐름을 제어하여 클라이언트 코드의 의존성을 줄이고, 시스템의 유연성과 확장성을 높인다.
- **예시**: 스프링 프레임워크에서의 의존성 주입(Dependency Injection)은 IoC의 대표적인 예로, 객체 생성과 의존성 관리를 프레임워크가 담당한다.

---

### 싱글톤 레지스트리

싱글톤 레지스트리는 스프링 프레임워크에서 사용되는 개념으로, 스프링이 관리하는 객체들을 싱글톤으로 관리하고, 필요할 때마다 이들 객체를 제공하는 메커니즘을 말합니다. 이를 통해 애플리케이션에서 필요한 객체들을 중앙 집중적으로 관리하고, 재사용할 수 있습니다.</br>

싱글톤 레지스트리의 주요 특징과 이점은 다음과 같습니다:</br>

중앙 집중적인 객체 관리: 스프링 컨테이너가 모든 빈(bean) 객체를 싱글톤으로 관리합니다. 이는 스프링이 애플리케이션에서 하나의 인스턴스만 생성하여 사용하며, 이를 필요로 하는 다른 객체들에게 공유합니다.</br>
의존성 관리: 스프링은 빈 객체들 간의 의존성을 주입(Dependency Injection)을 통해 관리합니다. 이로 인해 개발자는 객체 생성과 초기화에 집중하지 않고도 의존성을 손쉽게 처리할 수 있습니다.</br>

성능 향상: 반복적인 객체 생성을 피하고, 필요할 때마다 동일한 인스턴스를 재사용함으로써 성능을 향상시킵니다.</br>

코드 간결성: 스프링의 IoC (Inversion of Control) 컨셉에 따라 개발자는 객체의 생성 및 관리를 위한 코드를 작성하지 않아도 됩니다. 대신, 스프링 설정 파일에서 빈 객체들을 선언하고 필요한 곳에서 주입받아 사용할 수 있습니다.</br>

유연성과 확장성: 스프링의 빈 객체는 설정 파일에서 쉽게 변경하고 확장할 수 있습니다. 이는 애플리케이션의 요구 사항이나 환경 변화에 따라 빠르게 대응할 수 있게 해줍니다.</br>

싱글톤 레지스트리는 스프링의 핵심 기능 중 하나로, 객체 지향적 설계와 코드의 재사용성, 유지보수성을 높이는 데 중요한 역할을 합니다.</br>

### DI 와 디자인 패턴
디자인 패턴은 목적에 따라 분류할 수 있고, 스코프에 따라 클래스 패턴과 오브젝트 패턴으로 나눌 수 있습니다.</br>

1. **클래스 패턴**:
   - 상속을 이용하여 구조를 정의합니다.
   - 예시: 템플릿 메서드 패턴
   - 컴파일 타임에 관계를 정의합니다.

2. **오브젝트 패턴**:
   - 합성을 이용하여 구조를 정의합니다.
   - 예시: 전략 패턴, 데코레이터 패턴
   - 런타임에 관계를 설정합니다.
   - 대부분의 디자인 패턴은 여기에 속합니다.

오브젝트 패턴을 효과적으로 사용하려면 **의존관계 주입 (Dependency Injection, DI)**이 필요합니다. DI는 런타임에 오브젝트 간의 관계를 설정하고 관리합니다.</br>

특히 스프링(SPRING) 프레임워크를 사용하면 DI를 쉽게 적용할 수 있습니다. 스프링 컨테이너는 객체 생성과 의존관계 설정을 자동으로 처리합니다.</br>

따라서, 오브젝트 합성을 이용한 디자인 패턴을 적용하려면 스프링의 DI를 사용하면 됩니다. DI는 디자인 패턴을 효과적으로 활용할 수 있게 도와줍니다.</br>

### 데코레이터 디자인 패턴
데코레이터 패턴은 기존 코드의 수정을 피하면서 오브젝트에 부가적인 기능을 동적으로 추가하는 방법입니다. 즉, 기능을 업데이트하려면 코드를 수정해야 한다는 고정 관념을 벗어나, 데코레이터 패턴을 통해 유연하게 기능을 확장할 수 있습니다.</br>

### 의존성 역전 원칙 (DIP)
의존성 역전 원칙은 소프트웨어 설계에서 중요한 원칙으로, 모듈 간의 의존성을 효과적으로 관리하는 방법을 제시합니다.</br>

1. **상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안 된다. 둘 다 추상화에 의존해야 한다.**
   - 상위 수준 모듈과 하위 수준 모듈 모두 추상화(인터페이스나 추상 클래스)에 의존해야 하며, 구체적인 구현에 의존하지 않아야 합니다.</br>

2. **추상화는 구체적인 사항에 의존해서는 안 된다. 구체적인 사항은 추상화에 의존해야 한다.**
   - 구체적인 구현 클래스는 추상화된 인터페이스나 추상 클래스를 구현하거나 상속해야 합니다. 이를 통해 시스템의 유연성과 재사용성을 높일 수 있습니다.</br>

### 모듈
모듈은 전체 소프트웨어 시스템을 작은 단위로 나눈 것으로, 응집도가 높고 결합도가 낮은 단위로 설계합니다. 모듈 간에는 느슨한 결합을 유지하면서 내부적으로는 강한 응집력을 갖습니다.</br>

- **예시**: 자바 프로젝트의 JAR 파일, 패키지 등은 모듈의 한 예입니다. 패키지를 사용하여 관련 있는 클래스와 인터페이스를 그룹화함으로써 모듈을 구분할 수 있습니다.</br>


### 수동 테스트의 한계

1. **프린트된 메시지를 수동으로 확인하는 방법의 불편함**:
   - 개발자는 로그나 출력된 메시지를 일일이 확인해야 합니다.
   - 시간이 많이 걸리고 실수가 발생할 가능성이 높습니다.

2. **사용자 웹 UI까지 개발한 뒤에 확인하는 방법의 문제점**:
   - 테스트가 실패했을 때 문제의 원인을 파악하기 어렵습니다.
   - 코드의 많은 부분을 검사해야 하므로, 디버깅 시간이 길어질 수 있습니다.

3. **테스트할 대상이 많아질수록 검증에 걸리는 시간과 부정확성**:
   - 여러 컴포넌트를 테스트할 경우 시간이 많이 소요됩니다.
   - 사람의 손으로 검증하기 때문에 정확성이 떨어질 수 있습니다.

### 자동 수행되는 테스트 (개발자가 만드는 테스트)

자동화된 테스트는 개발자가 작성한 테스트 스크립트에 따라 자동으로 실행되며, 다음과 같은 장점이 있습니다:
- **일관된 결과**: 테스트 스크립트가 동일하게 실행되므로 일관된 결과를 보장합니다.
- **빠른 피드백**: 코드 변경 후 빠르게 테스트를 실행하여 문제를 즉시 발견할 수 있습니다.
- **반복 가능성**: 동일한 테스트를 여러 번 실행할 수 있어 안정성을 검증할 수 있습니다.
- **디버깅 용이성**: 자동화된 테스트는 코드의 특정 부분을 테스트하므로 문제를 더 쉽게 찾을 수 있습니다.

### JUnit5

JUnit5는 자바 애플리케이션을 테스트하는 데 사용되는 프레임워크로, 다음과 같은 특징이 있습니다:

#### @Test
- 테스트 메소드를 지정합니다.
- 이 어노테이션이 붙은 메소드는 테스트가 실행될 때 호출됩니다.

```java
@Test
void testMethod() {
    // 테스트 로직
}
```

#### @BeforeEach
- 각 테스트 메소드가 실행되기 전에 수행할 작업을 지정합니다.
- 테스트 클래스 내의 각 테스트 메소드가 실행되기 전에 매번 호출됩니다.

```java
@BeforeEach
void setUp() {
    // 초기화 작업
}
```

#### 테스트마다 새로운 인스턴스 생성
- JUnit5에서는 테스트 메소드마다 새로운 테스트 클래스 인스턴스가 생성됩니다.
- 이를 통해 테스트 간의 상호작용을 방지하고 독립성을 보장합니다.

```java
class ExampleTest {
    
    @BeforeEach
    void setUp() {
        // 각 테스트 전에 실행
    }

    @Test
    void test1() {
        // 테스트 메소드 1
    }

    @Test
    void test2() {
        // 테스트 메소드 2
    }
}
```

이러한 특징들은 테스트의 독립성과 일관성을 높여 줍니다. 자동화된 테스트는 개발자의 수동 검증 부담을 줄여주고, 코드 품질을 높이는데 기여합니다.

--- 
학습 테스트는 직접 작성하지 않은 코드, 라이브러리, 또는 레거시 시스템을 대상으로 테스트를 진행하여 사용 방법을 익히고 동작 방식을 확인하는데 유용합니다. 이를 통해 외부 기술이나 서비스가 버전 업데이트 이후에도 이전과 동일하게 동작하는지 확인할 수 있습니다. 학습 테스트의 주요 내용은 다음과 같습니다:

1. **사용 방법 습득**:
   - 새로운 코드나 라이브러리, 시스템의 사용법을 빠르게 익힐 수 있습니다.
   - 문서나 예제 코드만으로는 이해하기 어려운 부분을 직접 테스트하면서 학습할 수 있습니다.

2. **동작 방식 확인**:
   - 시스템이나 라이브러리가 예상대로 동작하는지 확인할 수 있습니다.
   - 특정 기능이나 메서드의 동작 원리 및 결과를 직접 확인할 수 있습니다.

3. **버전 호환성 검사**:
   - 외부 기술이나 서비스의 새로운 버전이 출시되었을 때, 이전 버전과 동일하게 동작하는지 테스트할 수 있습니다.
   - 버전 업그레이드에 따른 호환성 문제를 사전에 발견하여 해결할 수 있습니다.

4. **리그레션 테스트 지원**:
   - 기존 시스템의 기능이 변경되지 않았는지 확인하기 위해 학습 테스트를 사용할 수 있습니다.
   - 기존 코드의 안정성을 확보할 수 있습니다.

---
### 템플릿
템플릿은 특정 목적을 위해 미리 만들어진 형태나 구조를 가진 틀입니다. 템플릿은 고정된 부분과 바꿀 수 있는 부분을 포함하여, 재사용 가능하고 유연한 오브젝트를 제공합니다. 템플릿을 사용하면 일관성 있는 구조를 유지하면서, 특정 부분을 필요에 따라 변경할 수 있습니다.

### 템플릿 메소드 패턴
템플릿 메소드 패턴(Template Method Pattern)은 객체 지향 설계 패턴 중 하나로, 고정된 틀을 가진 로직을 슈퍼클래스에 정의하고, 변화가 필요한 부분을 서브클래스에서 구현하는 방식입니다. 이 패턴은 알고리즘의 구조를 정의하고, 일부 단계를 서브클래스에서 구현할 수 있게 하여, 코드의 재사용성과 유연성을 높여줍니다.

#### 구조
1. **슈퍼클래스 (Super Class)**
   - 고정된 로직을 정의한 템플릿 메소드를 가집니다.
   - 템플릿 메소드 내에서 호출되는 추상 메소드나 구체 메소드를 정의합니다.

2. **서브클래스 (Sub Class)**
   - 슈퍼클래스에서 정의된 추상 메소드를 구체적으로 구현합니다.
   - 고정된 로직의 특정 단계만을 재정의하여 사용할 수 있습니다.

### 콜백

콜백(callback)은 다른 객체의 메소드에 전달되는 객체로, 값을 참조하기 위한 것이 아니라 특정 로직을 실행시키는 것이 목적입니다. </br>
콜백은 주로 하나의 메소드를 가진 인터페이스 타입의 객체나 람다 표현식으로 전달됩니다.</br>
콜백은 이벤트 기반 프로그래밍, 비동기 작업 처리, 그리고 특정 작업이 완료된 후 실행해야 하는 로직을 정의할 때 자주 사용됩니다.</br>

#### 구조
1. **인터페이스 정의**
   - 하나의 메소드를 가진 인터페이스를 정의합니다. 이 메소드는 콜백이 호출될 때 실행될 로직을 포함합니다.

2. **콜백 객체 전달**
   - 콜백 객체는 인터페이스를 구현한 객체 또는 람다 표현식으로 전달됩니다.

3. **메소드 실행**
   - 메소드 내에서 콜백 객체의 메소드를 호출하여 특정 로직을 실행합니다.

### 템플릿/콜백과 전략 패턴

템플릿/콜백은 전략 패턴의 특별한 케이스로, 템플릿과 콜백은 항상 쌍으로 등장합니다. 이는 전략 패턴의 한 형태로, 템플릿은 전략 패턴의 컨텍스트에 해당하며, 콜백은 전략에 해당합니다.

#### 전략 패턴
전략 패턴에서는 두 가지 요소가 등장합니다:
1. **컨텍스트 (Context)**: 변경되지 않는 로직을 포함하고, 전략 객체를 사용하여 특정 알고리즘을 실행합니다.
2. **전략 (Strategy)**: 변경 가능한 알고리즘을 정의하는 인터페이스 또는 클래스입니다.

템플릿/콜백 구조에서는 템플릿이 컨텍스트 역할을 하고, 콜백이 전략 역할을 합니다.

#### 템플릿/콜백의 특별함
전략 패턴의 일반적인 전략 객체는 여러 메소드를 가질 수 있지만, 템플릿/콜백에서는 콜백 객체가 단 하나의 메소드를 가지는 것이 특징입니다. 즉, 템플릿/콜백은 하나의 메소드를 가진 전략 인터페이스를 사용하는 전략 패턴입니다.

### 메소드 주입
메소드 주입은 의존 객체가 메소드 호출 시점에 파라미터로 전달되는 방식입니다. 이는 앞서 설명한 의존관계 주입(DI)과 매우 유사하며, 비슷한 목적을 위해 사용됩니다.

### 메소드 주입의 특징
1. **의존 객체 전달**: 메소드를 호출할 때마다 필요한 의존 객체를 파라미터로 전달합니다.
2. **동적 의존성**: 오브젝트의 생명주기 동안 고정된 의존성을 갖는 일반적인 DI와 달리, 메소드 주입은 메소드 호출 시마다 의존 객체를 동적으로 주입할 수 있습니다.
3. **유연한 의존성 관리**: 메소드 주입은 의존 객체를 유연하게 연결해 주며, 이를 통해 다양한 의존 관계를 쉽게 관리할 수 있습니다.

### 메소드 주입과 DI
일부 사람들은 메소드 주입을 DI로 보지 않을 수 있지만, 메소드 주입도 두 개의 객체 간의 의존성을 유연하게 연결해주는 방식입니다. 주입을 통해 의존 관계가 맺어지기 때문에, 메소드 주입도 DI의 한 형태로 볼 수 있습니다.


### Rest Template
#### Rest Template 주요기능
HTTP 요청/응답 처리: GET, POST, PUT, DELETE 등 다양한 HTTP 메소드를 지원하여 서버와의 통신을 간편하게 처리.
메시지 변환: 요청 및 응답 본문을 다양한 형식으로 변환하기 위한 전략을 제공.
예외 처리: HTTP 오류 상태에 대한 예외 처리를 제공.
확장성: HTTP 클라이언트 라이브러리와 메시지 변환 전략을 커스터마이징할 수 있음.

#### HTTP API 요청을 처리하는 템플릿
- HTTP Client 라이브러리 확장 : ClientHttpRequestFactory
  -  ClientHttpRequestFactory는 RestTemplate 이 사용하는 HTTP 클라이언트를 설정하는 데 사용됩니다. 기본적으로 SimpleClientHttpRequestFactory를 사용하지만, 더 고급 기능을 위해 HttpComponentsClientHttpRequestFactory또는 OkHttp3ClientHttpRequestFactory등을 사용할 수 있습니다.
- Message Body를 변환하는 전략 : HTTPMessageConverter
  - HTTPMessageConverter는 HTTP 요청과 응답의 본문을 변환하는 전략을 정의합니다. RestTemplate은 기본적으로 여러 가지 메시지 변환기를 제공하여 JSON, XML 등 다양한 형식을 지원합니다.
Rest 템플릿은 우리가 되게 단순하게 만들었던 API 템플릿의 고급버전
HTTP의 모든 기능을 다 사용해서 API를 호출하는 굉장히 다양한 포맷을 다 지원하는 그런 기술을 가진 템플릿


### ClientHttpRequestFactory
HTTP Client 기술을 사용해서 ClientHttpRequest를 생성하는 전략
- ClientHttpRequestFactory는 HTTP 클라이언트 기술을 사용하여 ClientHttpRequest 객체를 생성하는 전략을 정의하는 인터페이스입니다. 이 인터페이스는 다양한 HTTP 클라이언트 구현체들이 실제로 HTTP 요청을 만들어내는 방식을 추상화하여 제공합니다

### doExecute()
HTTP API 호출 workflow를 가지고 있는 템플릿 메소드로 두 개의 콜백을 받음

### 데코레이터 패턴
- 데코레이터 패턴은 객체의 코드를 변경하지 않고 새로운 기능을 런타임에 부여하는 디자인 패턴
  - 객체에서 동적 행동을 추가할때 사용

### 프록시 패턴
- 다른 객체에 대한 접근을 제어하기 위한 대리 객체를 제공 주로 원래 객체에 대한 접근을 제한하거나 접근 전에 추가적인 작업을 수행할 때 사용

### 트랜잭션 프록시
- 서비스 계층에서 트랜잭션 관리 기능을 추가하기 위해 사용

### 스프링 프록시 AOP
#### AOP (Aspect-Oriented Programming)의 개요
- **AOP**는 프로그램의 핵심 기능과 부가 기능(관심사)을 분리하는 프로그래밍 기법입니다.
- 이를 통해 코드의 모듈화를 극대화하고, 코드의 중복을 줄이며, 가독성과 유지보수성을 높일 수 있습니다.

#### 스프링에서의 AOP
- **스프링 프레임워크**는 AOP를 지원하며, 주로 프록시를 이용해 구현됩니다.
- **프록시 패턴**을 활용하여 메소드 호출을 가로채고, 추가적인 기능을 삽입합니다.

#### AOP의 제한점
- **활용 용도 제한적**: 특정 상황에서만 유용하며, 모든 경우에 적용하기는 어렵습니다.
- **사용 난이도 높음**: AOP를 제대로 활용하려면 많은 학습이 필요합니다.
   - 복잡한 설정과 개념을 이해해야 하며, 잘못 사용할 경우 디버깅이 어려워질 수 있습니다.

#### AOP의 유용한 활용 사례
- **트랜잭션 관리**: 데이터베이스 트랜잭션의 시작과 종료를 투명하게 처리할 수 있습니다.
- **보안**: 메소드 호출 전에 권한을 확인하는 등의 보안 로직을 추가할 수 있습니다.
- 이러한 기능들은 스프링이 제공하는 AOP 기반의 기본 기능을 통해 쉽게 구현할 수 있습니다.

#### 직접 활용의 어려움
- AOP를 직접 활용하기 위해서는 다음과 같은 많은 개념과 기술을 이해해야 합니다:
   - **Aspect**: 횡단 관심사를 모듈화한 것.
   - **Join Point**: AOP가 적용될 수 있는 지점(메소드 호출 등).
   - **Advice**: 실제로 실행되는 부가 기능.
   - **Pointcut**: Advice가 적용될 Join Point를 정의하는 표현식.
   - **Weaving**: Advice를 실제 코드에 적용하는 과정.
- 이러한 개념들을 이해하고, 적용할 수 있는 기술적 숙련도를 갖추는 것이 필요합니다.

#### 대안: 데코레이터/프록시 패턴의 이해 및 활용
- AOP를 사용하지 않더라도, **데코레이터 패턴**과 **프록시 패턴**의 동작 원리를 이해하고 활용할 수 있습니다.
   - **데코레이터 패턴**: 객체에 추가적인 기능을 동적으로 부여할 수 있는 패턴.
   - **프록시 패턴**: 실제 객체에 접근하기 전에, 그 접근을 제어하는 객체를 제공하는 패턴.
- 이러한 패턴들을 이해하면, 코드의 특정 부분에만 부가 기능을 적용하는 등의 유사한 효과를 얻을 수 있습니다.
   - 예를 들어, 특정 메소드 호출 전후로 로깅을 추가하거나, 캐싱을 적용하는 등의 작업을 할 수 있습니다.