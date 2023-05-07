[빌더 패턴](https://refactoring.guru/ko/design-patterns/builder)

- **빌더**
    - 복잡한 객체들을 단계별로 생성할 수 있도록 하는 생성 디자인 패턴

- **문제**

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/49eac80e-a567-427b-b16d-be6d41edb2a4/Untitled.png)

    - 대부분의 매개변수가 사용되지 않아 **[생성자 호출들의 코드가 매우 못생겨질 것입니다](https://refactoring.guru/ko/smells/long-parameter-list)**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0197d028-541b-42b4-9c9e-fa94d4c79472/Untitled.png)

- **해결**

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9bda6d96-6802-4fb5-bd9a-a95f05d11a2a/Untitled.png)

    - 디렉터 클래스는 클라이언트 코드에서 제품 생성의 세부 정보를 완전히 숨깁니다.****
    - 클라이언트는 빌더를 디렉터와 연관시키고
      디렉터와 생성을 시행한 후
      빌더로부터 결과를 얻기만 하면 됩니다.
    - 예시)

      ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/67bf4d42-c790-47ee-b6de-6c7105358fbb/Untitled.png)

        - 클라이언트는 makeSUV() or makeSportsCar() 중 원하는 것을 호출하면 된다.
- 적용
    - **'점층적 생성자'를 제거하기 위하여 사용**

        ```java
        class Pizza {
            Pizza(int size) { ... }
            Pizza(int size,boolean cheese) { ... }
            Pizza(int size,boolean cheese,boolean pepperoni) { ... }
            // …
        }
        ```

    - **코드가 일부 제품의 다른 표현들(예: 석조 및 목조 주택들)을 생성할 수 있도록 하고 싶을 때 사용**
    - **[복합체](https://refactoring.guru/ko/design-patterns/composite) 트리들 또는 기타 복잡한 객체들을 생성할 때 사용**