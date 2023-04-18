- final은 무언가 제한한다는 의미이다.
    - 변수, 메소드, 클래스에 사용 가능하다
- final variable
    - 값을 변경할 수 없다.
    - 초기화와 함께 선언 해야한다.
- final class
    - If a class that was not declared `final` is changed to be declared `final`, then a `VerifyError` is thrown if a binary of a pre-existing subclass of this class is loaded, because `final` classes can have no subclasses; such a change is not recommended for widely distributed classes.
        - final class는 자식 클래스를 가질 수 없다. 따라서 자식클래스를 가지고 있던 어떤 클래스가 final class로 바뀌면 VerifyError를 throw한다.
    - Changing a class that is declared `final` to no longer be declared `final` does not break compatibility with pre-existing binaries.
- final method
    - final method는 override할 수 없다.

      ![스크린샷 2023-04-18 오전 3.59.45.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bd17a534-333d-4617-ae08-8b112ff5d7e8/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-04-18_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_3.59.45.png)

- static
    - static 키워드의 멤버들은 Heap이 아닌 Static 영역에 할당
    - 모든 객체가 공유하여 어디서든지 참조
    - GC가 관리하지 않음
- static variable
- static method
- static class

    ```java
    public class TestClass {
    
      /* ↓ */
      static class NestedClass {
      }
    }
    ```

    - `static`이 아닌 멤버 클래스의 인스턴스는 바깥 클래스의 인스턴스와 암묵적으로 연결된다.
    - 왜냐하면 `static`이 아닌 멤버 클래스는 바깥 인스턴스 없이는 생성할 수 없기 때문이다.
    - 두 클래스의 관계는 멤버 클래스의 인스턴스 안에 만들어지며, 메모리를 차지한다. 생성도 느리다.
    - 바깥 클래스 인스턴스의 참조를 멤버 클래스가 갖고 있으므로, 바깥 클래스 인스턴스가 쓰레기 수거 대상에서 빠지게 된다.