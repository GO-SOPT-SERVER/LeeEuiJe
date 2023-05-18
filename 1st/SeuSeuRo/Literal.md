- Literal
    - Any constant value which can be assigned to the variable is called literal/constant
    - 변수에 할당될 수 있는 모든 상수값을 리터럴/상수라고 부른다.
- 특징
    - Java에서의 리터럴은 boolean, numeric, character, string의 조합이다.
- numeric

    ```java
    // 10진수
    101;
    // 8진수 (prefix with 0)
    0100;
    // 16진수
    0X123Face;
    // 2진수
    0b1111;
    // 10진수 소수
    // 소수는 10진수로 밖에 표현 못함.
    123.456;
    ```

- Char data

    ```java
    // single quote
    'a';
    // as integral literal
    // 0에서 65535 범위
    // 어느 진수 표현이든 가능
    062;
    // unicode
    '\u0061'; // (a)
    // escape sequence
    '\n';
    ```

- String

    ```java
    // double quotes
    "Hello";
    // concat
    // 컴파일 타임에 연산
    // 왼쪽부터 오른쪽으로
    "This is a String literal\n"
    + "which spans not one and not two\n"
    + "but three lines of text.\n";
    ```

- Boolean

    ```java
    true;
    false;
    0;
    1;
    ```