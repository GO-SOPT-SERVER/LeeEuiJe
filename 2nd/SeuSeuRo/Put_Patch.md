[멱등성이 뭔가요?](https://velog.io/@tosspayments/멱등성이-뭔가요)

- 멱등하다 (Idempotent)
    - 수학
        - 단항연산

          $$
          f(f(x)) = f(x)
          $$

            - 예) 절대값 함수, 상수함수, 항등함수
        - 이항연산

          $$
          x∘x = x
          $$

            - 예) max(x, x) = x
    - HTTP
        - A request method is considered "idempotent"
          if the **intended** **effect on the server** of multiple identical requests with that method is the same as the effect for a single such request.
        - Of the request methods defined by this specification, PUT, DELETE, and safe request methods are idempotent.
        - Like the definition of safe, the idempotent property only applies to what has been requested by the user;
          **a server is free to log each request separately, retain a revision control history, or implement other non-idempotent side effects for each idempotent request.**
        - Idempotent methods are distinguished because **the request can be repeated automatically if a communication failure occurs**
          before the client is able to read the server's response.
            - For example, if a client sends a PUT request and the underlying connection is closed before any response is received,
              then the client can establish a new connection and retry the idempotent request.
            - It knows that repeating the request will have the same intended effect, even if the original request succeeded, *though the response might differ.*
        - 결론
            - 동일한(identical) 여러번 요청이 들어와도, 서버에 미치는 영향(effect)이 같다
                - 서버의 State가 같다 라고 할 수 있겠음.

        ---

- Http Method

    ```
    The "Hypertext Transfer Protocol (HTTP) Method Registry" has been
       populated with the registrations below:
    
       +---------+------+------------+---------------+
       | Method  | Safe | Idempotent | Reference     |
       +---------+------+------------+---------------+
       | CONNECT | no   | no         |Section 4.3.6 |
       | DELETE  | no   | yes        |Section 4.3.5 |
       | GET     | yes  | yes        |Section 4.3.1 |
       | HEAD    | yes  | yes        |Section 4.3.2 |
       | OPTIONS | yes  | yes        |Section 4.3.7 |
       | POST    | no   | no         |Section 4.3.3 |
       | PUT     | no   | yes        |Section 4.3.4 |
       | TRACE   | yes  | yes        |Section 4.3.8 |
       +---------+------+------------+---------------+
    ```

- PUT - 멱등성 ✅
- **9.6 PUT**
    - **정의**
        - The PUT method requests that the enclosed entity be stored under the supplied Request-URI.
    - **설명**
        - If the Request-URI refers to an already existing resource, the enclosed entity SHOULD be considered as a modified version of the one residing on the origin server.
        - If the Request-URI does not point to an existing resource, and that URI is capable of being defined as a new resource by the requesting user agent, the origin server can create the resource with that URI.
    - **반환**
        - If a new resource is created, the origin server MUST inform the user agent via the 201 (Created) response.
        - If an existing resource is modified, either the 200 (OK) or 204 (No Content) response codes SHOULD be sent to indicate successful completion of the request.
        - If the resource could not be created or modified with the Request-URI, an appropriate error response SHOULD be given that reflects the nature of the problem.
            - The recipient of the entity MUST NOT ignore any Content-*(e.g. Content-Range) headers that it does not understand or implement and MUST return a 501 (Not Implemented) response in such cases.
        - If the request passes through a cache and the Request-URI identifies one or more currently cached entities, those entries should be treated as stale. Responses to this method are not cachable.
    - **POST와의 차이점**
        - The fundamental difference between the POST and PUT requests is reflected in the different meaning of the Request-URI.
        - The URI in a POST request identifies the resource that will handle the enclosed entity.
            - That resource may be a data-accepting process, a gateway to some other protocol, or a separate entity that accepts annotations.
        - In contrast, the URI in a PUT request identifies the entity enclosed with the request
          -- the user agent knows what URI is intended and the server MUST NOT attempt to apply the request to some other resource.
            - If the server desires that the request be applied to a different URI, it MUST send a 301 (Moved Permanently) response;
              the user agent MAY then make its own decision regarding whether or not to redirect the request.
            - A single resource MAY be identified by many different URIs.
                - For example, an article may have a URI for identifying "the current version" which is separate from the URI identifying each particular version.
                - In this case, a PUT request on a general URI may result in several other URIs being defined by the origin server
    - HTTP/1.1 does not define how a PUT method affects the state of an origin server.

- PATCH - 멱등성 ❌ 가나다
- **[19.6.1.1](https://www.rfc-editor.org/rfc/rfc2068#section-19.6.1.1) PATCH**
    - The PATCH method is similar to PUT
      except that **the entity contains a list of differences**
      between the original version of the resource identified by the Request-URI
      and **the desired content of the resource after the PATCH action has been applied.**
    - The list of differences is in a format defined by the media type of the entity (e.g.,"application/diff") and MUST include sufficient information to allow the server to recreate the changes necessary to convert the original version of the resource to the desired version.
    - If the request passes through a cache and the Request-URI identifies a currently cached entity, that entity MUST be removed from the cache.
      Responses to this method are not cachable.
    - The actual method for determining how the patched resource is placed, and what happens to its predecessor, is defined entirely by the origin server.
        - If the original version of the resource being patched included a Content-Version header field,
          the request entity MUST include a Derived-From header field
          corresponding to the value of the original Content-Version header field.
        - Applications are encouraged to use these fields for constructing versioning relationships and resolving version conflicts.

- 결론
    - 유연한 API설계가 중요하다
    - 서버의 DB 자원을 기준으로 Method를 설계 해야한다.
    - PATCH는 자원의 변화를 저장하는(version) 수정
    - PUT은 멱등성을 보존하는 수정 or 생성
        - ex) PUT notion.so/post/1
    - POST는 멱등성을 보존하지 않는 수정 or 생성
        - ex) POST notion.so/post