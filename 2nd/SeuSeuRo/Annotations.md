### 2.4.1 @Getter, @Setter

- dependency
    - compileOnly 'org.projectlombok:lombok'
    - annotationProcessor 'org.projectlombok:lombok'
- 개념
    1. You can annotate any field with `@Getter` and/or `@Setter`, to let lombok generate the default getter/setter automatically.
        - field에 붙이면, 자동으로 기본 getter/setter를 생성해준다.
    2. The generated getter/setter method will be `public` unless you explicitly specify an `AccessLevel`,
       as shown in the example below. Legal access levels are `PUBLIC`, `PROTECTED`, `PACKAGE`, and `PRIVATE`
        - AccessLevel 파라미터로 getter/setter의 접근 제어를 할 수 있음. (기본값 public)
    3. You can also put a `@Getter` and/or `@Setter` annotation on a class.
       In that case, it's as if you annotate all the non-static fields in that class with the annotation.
        - class에 붙이면 모든 non-static 필드들에 getter/setter를 생성
    4. You can always manually disable getter/setter generation for any field by using the special `AccessLevel.NONE` access level.
       This lets you override the behaviour of a `@Getter`, `@Setter` or `@Data` annotation on a class.
        - `@Getter(AccessLevel.None)`을 붙이면 getter/setter 생성을 막는다. 이는 override하도록 해줌.

### 2.4.2 **@NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor**

- dependency
    - compileOnly 'org.projectlombok:lombok'
    - annotationProcessor 'org.projectlombok:lombok'
- `@NoArgsConstructor`
    - will generate a constructor with no parameters.
        - 파라미터가 없는 생성자를 만들어준다
    - If this is not possible (because of final fields), a compiler error will result instead,
      unless `@NoArgsConstructor(force = true)` is used, then all final fields are initialized with `0` / `false` / `null`.
        - final field가 있으면, 컴파일 에러를 발생시킨다.
        - `@NoArgsConstructor(force = true)` 를 사용하면, final field는 0 or false or null로 초기화 된다.
    - For fields with constraints, such as `@NonNull` fields, *no* check is generated,
      so be aware that these constraints will generally not be fulfilled until those fields are properly initialized later.
        - @NonNull같은 fields 제약 조건은 자동으로 체크해주지 않는다.
        - 조심히 써라
    - Certain java constructs, such as hibernate and the Service Provider Interface require a no-args constructor.
        - hibernate and the Service Provider이런 것들이 **@NoArgsConstructor를** 필요로하는 예시가 되겠다
    - This annotation is useful primarily in combination with either `@Data` or one of the other constructor generating annotations.
        - @Data나 **@RequiredArgsConstructor, @AllArgsConstructor이랑 같이 쓰면 좋다.**
- `@RequiredArgsConstructor`
    - generates a constructor with 1 parameter for each field that requires special handling.
        - 각 field가 특별하게 처리해줘야 하는 파라미터에 대해(final, …) 생성자를 만들어준다.
    - All non-initialized `final` fields get a parameter, as well as any fields that are marked as `@NonNull` that aren't initialized where they are declared.
        - 다음을 파라미터로 받는 생성자 생성
            - 초기화 되지 않은 @NonNull field
            - 초기화 되지 않은 final field
    - For those fields marked with `@NonNull`, an explicit null check is also generated.
      The constructor will throw a `NullPointerException` if any of the parameters intended for the fields marked with `@NonNull` contain `null`.
        - NullPointerException throw를 통해
          @NonNull field에 대한 명시적(explicit) null check를 제공한다.
    - The order of the parameters match the order in which the fields appear in your class.
        - 생성자의 파라미터 순서는 클래스의 필드 정의 순서와 같다.
- `@AllArgsConstructor`
    - generates a constructor with 1 parameter for each field in your class.
    - Fields marked with `@NonNull` result in null checks on those parameters.
- 공통 특징
    - @AllArgsConstructor(access = AccessLevel.PROTECTED) 와 같은 생성자의 접근제어자를 지정할 수 있다.
    - @RequiredArgsConstructor(staticName="of") 라고 하면
        - `new MapEntry<String, Integer>("foo", 5)` 가 아닌,
        - `MapEntry.of("foo", 5)` 으로 생성자를 호출 할 수 있다.
            - 이는 컴파일러의 type inference(타입 추론)을 통해 Template의 타입을 지정하지 않아도 되는 강점이 있다.

### 2.4.3 @RestController

- dependency
    - [org.springframework.web.bind.annotation](https://docs.spring.io/spring-framework/docs/5.0.2.RELEASE/kdoc-api/spring-framework/org.springframework.web.bind.annotation/index.html)
- 형식

  ![스크린샷 2023-04-19 오후 8.05.17.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f33f23f6-262a-4f6c-9fd6-425bbb7c1ab9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-04-19_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_8.05.17.png)

    - A convenience annotation that is itself annotated with Controller and ResponseBody.
        - @Controller + @ResponseBody
    - Types that carry this annotation are treated as controllers where RequestMapping methods assume ResponseBody semantics by default.
        - @Controller와 달리 @RestController는 반환 값이 View가 아닌 HTTP Response Body에 직접 작성됩니다.
    - 생성자
        - RestController(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))
        - The value may indicate a suggestion for a logical component name, to be turned into a Spring bean in case of an autodetected component.
            - Spring Bean에 `value` 의 이름으로 등록 된다.



### 2.4.4 @PostMapping, @GetMapping

- 형식

    ```java
    @Target(METHOD)
    @Retention(RUNTIME)
    @Documented
    @RequestMapping(method=GET)
    public @interface GetMapping
    ```

    - Annotation for mapping HTTP `GET`requests onto specific handler methods.
    - Specifically, `@GetMapping` is a *composed annotation* that acts as a shortcut for `@RequestMapping(method = RequestMethod.GET)`.

- @RequestMapping
    - parameters
        - `String name`
            - 이름임
        - `String[] value`
            - path와 같다
        - `String[] path`
            - ("/profile”)
            - ("/profile/**”)
            - ("/${profile_path}”)
        - [`RequestMethod](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMethod.html)[] method`
            - GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE.
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)[] params`
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)[] headers`
            - headers임
            - @RequestMapping(value = "/something", headers = "content-type=text/*") 이런식으로
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)[] consumes`
            - media
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)[] produces`
            - media

### 2.4.5 @RequestBody, @PathVariable, @RequestParam

- @RequestBody
    - Annotation indicating a method parameter should be bound to the body of the web request.
    - The body of the request is passed through an `[HttpMessageConverter](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/converter/HttpMessageConverter.html)` to resolve the method argument depending on the content type of the request.
    - Optionally, automatic validation can be applied by annotating the argument with `@Valid`
    1. Parameter에 붙이는 annotation이다.
    2. Http Request에 Body에 해당하는 정보가 들어간다.
        1. 해당 정보는 HttpMessageConverter라는 객체가 던져준다.
    3. @Valid annotation을 통해 자동 유효성 검사를 시킬 수도 있다.
    - parameters
        - `boolean required`
            - 기본값 : true
            - false 설정 시, body가 없으면 null이 된다.

- @PathVariable
    - Annotation which indicates that a method parameter should be bound to a URI template variable.
        - Supported for `[RequestMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)` annotated handler methods.
    - If the method parameter is `[Map<String, String>](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)` then the map is populated with all path variable names and values.
    1. Parameter에 붙이는 annotation이다
    2. 붙여진 parameter가 Map<String, String> 타입이라면, [names]: values가 자동으로 생성된다.
    - parameters
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) value`
            - name이랑 같음
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) name`
            - 이름임
        - `boolean required`
            - 기본값 : true
            - false 설정 시, path variable이 없으면 null이 됨.

- @RequestParam
    - Annotation which indicates that a method parameter should be bound to a web request parameter.
    - Supported for annotated handler methods in Spring MVC and Spring WebFlux as follows:
        - In Spring MVC, "request parameters" map to query parameters, form data, and parts in multipart requests. This is because the Servlet API combines query parameters and form data into a single map called "parameters", and that includes automatic parsing of the request body.
        - In Spring WebFlux, "request parameters" map to query parameters only. To work with all 3, query, form data, and multipart data, you can use data binding to a command object annotated with `[ModelAttribute](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ModelAttribute.html)`.
    - If the method parameter type is `[Map](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)` and a request parameter name is specified, then the request parameter value is converted to a `[Map](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)` assuming an appropriate conversion strategy is available.
    - If the method parameter is `[Map<String, String>](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)` or `[MultiValueMap<String, String>](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/MultiValueMap.html)` and a parameter name is not specified, then the map parameter is populated with all request parameter names and values.
    - parameters
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) value`
            - name이랑 같음
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) name`
            - 이름임
        - `boolean required`
            - 기본값 : true
            - false 설정 시, path variable이 없으면 null이 됨.
        - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) defaultValue`
            - required를 false로 만듦.
            - path variable이 없으면 설정할 값.

### 2.4.6 @Service

- Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003) as "an operation offered as an interface that stands alone in the model, with no encapsulated state."
- May also indicate that a class is a "Business Service Facade" (in the Core J2EE patterns sense), or something similar.
- This annotation is a general-purpose stereotype and individual teams may narrow their semantics and use as appropriate.
- This annotation serves as a specialization of `[@Component](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html)`, allowing for implementation classes to be autodetected through classpath scanning.

- DDD에 나오는 ‘Service’이다
- J2EE의 ‘Business Service Facade’이다
- 팀마다 알아서 맞게 쓰면 된다.

- parameter
    - [`String](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) value`
        - 이름임

### 2.4.7 @SpringBootApplication

```java
@Target(TYPE)
@Retention(RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters={@Filter(type=CUSTOM,classes=TypeExcludeFilter.class),})
public @interface **SpringBootApplication**
```

- Indicates a `[configuration](https://docs.spring.io/spring-framework/docs/6.0.7/javadoc-api/org/springframework/context/annotation/Configuration.html)` class that declares one or more `[@Bean](https://docs.spring.io/spring-framework/docs/6.0.7/javadoc-api/org/springframework/context/annotation/Bean.html)` methods and also triggers `[auto-configuration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/EnableAutoConfiguration.html)` and `[component scanning](https://docs.spring.io/spring-framework/docs/6.0.7/javadoc-api/org/springframework/context/annotation/ComponentScan.html)`