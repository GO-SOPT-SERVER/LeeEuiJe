![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/00451228-1adb-44f1-bcdc-5ce7537e94a5/Untitled.png)

1. .java
2. .class
    - token sequence를 Abstract Syntax Tree - Nodes를 그리며 Bytecode로 변환
3. ClassLoader

   ![스크린샷 2023-04-19 오전 9.41.42.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d957a436-8538-4f33-ba6a-8586fcd24975/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-04-19_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_9.41.42.png)

    - Loading
        - 클래스 파일을 JVM 메모리에 적재
    - Verifying
        - .class 파일이 유효한지 검사
    - Preparing
        - static 및 기본 값에 대한 공간 할당
    - Resolving
        - 심볼릭 메모리 레퍼런스를 힙 메모리의 메소드 영역에 있는 인스턴스의 레퍼런스로 교체
        - Constant Pool의 심볼릭 메모리 레퍼런스를 실제 메모리 주소로 교체
    - Initializing
        - Preparing 단계에 할당된 공간에 static 값 할당
4. Execution
    - 두 가지 방식 혼합
    - Interpreter
        - bytecode의 instruction 하나씩 실행
    - JIT(Just-In-Time)
        - 파일 하나를 bytecode로 바꾸고 실행