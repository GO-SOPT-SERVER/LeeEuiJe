## 4.1 SOLID 원칙

- SRP, Single Responsibility Principle
    - 한 클래스는 하나의 책임만 가져야 한다.
    - 기준
        - 변경이 있을 때 파급 효과가 적으면 해당 원칙을 잘 따른 것.
- OCP, Open/Closed principle
    - 소프트웨어 요소는 확장에는 열어 있으나 변경에는 닫혀 있어야 한다.

    ``` java
    public class MemberService {
    //	private MemberRepository memberRepository = new MemoryMemberRepository();
    	  private MemberRepository memberRepository = new JdbcMemberRepository();
    }
    ```

    - !
        - MemberService가 구현 객체를 변경하려면 **코드를 변경해야한다**
        - 다형성을 사용하고 있지만 코드를 변경하고 있음.
    - 솔루션
        - 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요
- LSP, Liskov Subsititution Principle
    - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 함
    - 인터페이스를 구현한 구현체를 믿고 사용하려면 해당 원칙 필요
    - 컴파일 성공을 너머 기능에 대한 이야기
    - 예) 자동차의 엑셀은 + 값을 가지고 있어야함, - 값을 가지면 LSP 위반
- ISP, Interface Segregation Principle
    - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 나음
    - 예)
        - 자동차 → 운전 + 정비
        - 사용자 → 운전자 + 정비사
- DIP, Dependency Inversion Principle
    - 추상화에 의존해야지, 구체화에 의존하면 안됨.
    - 역할(Role)에 의존하게 해아함.
    - 운전자가 K3에 의존, 장동건이 김태희에 의존하면 안됨.
- **다형성만으로는 OCP, DIP를 지킬 수 없음.**