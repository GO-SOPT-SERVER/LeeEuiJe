1. POJO 프로그래밍 지향 (Plane Old Java Object)
    - 2000년 대 Java EE 등 거대하고, 무거운 엔터프라이즈 급 자바 프레임워크와 반대되는 개념
    - 자바 언어 사양 외에 어떠한 제한에도 묶이지 않은 자바 오브젝트
        1. 미리 정의된 클래스를 확장하면 안된다.

            ```java
            // ❌
            public class Foo extends javax.servlet.http.HttpServlet { ... 
            ```

        2. 미리 정의된 인터페이스를 구현하면 안된다.

            ```java
            // ❌
            public class Bar implements javax.ejb.EntityBean { ...
            ```

        3. 미리 정의된 애너테이션을 포함 하면 안된다.

            ```java
            // ❌
            @javax.persistence.Entity public class Baz { ...
            ```

2. IoC / DI (Inversion of Control & Dependency Injection)
    - IoC, Inversion of Control
        - 프로그램의 제어 흐름은 이제 AppConfig가 가져감.
        - 심지어 OrderServiceImpl도 AppConfig가 생성.
        - OrderServiceImpl는 묵묵히 자신의 로직을 실행할 뿐
        - Cf) Framework vs Library
            - 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 프레임워크 (JUnit)
            - 내가 작성한 코드가 직접 제어의 흐름을 담당하면 라이브러리
    - DI, Dependency Injection
        - 의존 관계는 ‘정적인 클래스 의존 관계’, ‘동적인 객체 의존 관계’를 분리해서 생각해야 함.
        - ‘정적인 클래스 의존 관계’
            - import 코드만 보고 의존 관계 파악

          ![스크린샷 2023-04-15 오후 5.11.13.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e12bbdb9-97e6-4c32-831a-315b68637f48/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-04-15_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5.11.13.png)

        - ‘동적인 객체 의존 관계’
            - 객체 다이어그램

          ![스크린샷 2023-04-15 오후 5.12.34.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5990ba7c-67cd-4c45-9cab-968f0d92cb95/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-04-15_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5.12.34.png)

        - **클라이언트와 서버의 실제 의존관계가 연결되는 것을 의존 관계 주입이라고 한다.**
            - 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
            - 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.
    - IoC 컨테이너, DI 컨테이너
        - 또는 어셈블러, 오브젝트 팩토리 등으로 불리기도 한다.

1. AOP (Aspect Oriented Programming)
    - 관점 지향 프로그래밍
    - 어떤 로직을 기준으로 **핵심적인 관점**, **부가적인 관점**으로 나눠보고 그 관점을 기준으로 각각 모듈화 하겠다는 의미.
        - **핵심적인 관점:** 개발자가 적용하고자 하는 핵심 비즈니스 로직.
        - **부가적인 관점:** 핵심 로직을 수행하기 위해 필요한 DB연결(JDBC), 로깅, 파일 입출력 등...
    - **프록시 패턴**(**스프링 AOP가 사용하는 방법**)

      ⇒ 공통 모듈을 프록시로 만들어서 DI 로 연결된 빈 사이에 적용해 Target의 메소드 호출 과정에 참여애 부가기능(공통 모듈)을 제공해준다.

        - JDK 와 Spring Container 외에 특별한 기술 및환경을 요구하지 않는다.
        - Advice 가 구현하는 MethodInterceptor 인터페이스는 다이내믹 프록시의 InvocationHandler와 마찬가지로 프록시부터 메소드 요청정보를 전달받아 타깃 오브젝트의 메소드를 호출하는데, 이렇게 메소드를 호출하는 전/후로 부가기능(공통 모듈)을 제공할 수 있다.
        - 이런식으로 독립적으로 개발한 부가기능 모듈을 다양한 타깃 오브젝트의 메소드에 다이내믹하게 적용해주기 위해 가장 중요한 역할을 맡고 있는게 프록시고, 스프링 AOP는 프록시 방식의 AOP라 할 수 있다.
2. PSA (Portable Service Abstraction)
    - 환경의 변화와 관계없이 일관된 방식의 기술로의 접근 환경을 제공하려는 추상화 구조
    - Spring은 **Spring Web MVC, Spring Transaction, Spring Cache 등의 다양한 PSA를 제공**