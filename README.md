# PRAGMATIC PROJECT




## Spring Security

---

#### Spring Security Crypto

PasswordEncoder

`passwordEncoder.encode(암호화할 비밀번호)`

`passwordEncoder.matches(비교할 암호화 안 된 비밀번호, 암호화된 비밀번호)`

https://kedric-me.tistory.com/entry/Spring-Password-Encoder-%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8-%EC%95%94%ED%98%B8%ED%99%94

---

## Model Mapper
ModelMapper는 Java 객체 간의 매핑을 쉽게 할 수 있게 도와주는 라이브러리
DTO(Data Transfer Object)와 도메인 객체 간의 데이터 변환에 사용

- 자동 매핑: 필드 이름과 타입이 같은 경우, ModelMapper는 자동으로 두 객체 간의 매핑을 수행합니다.
- 명시적 매핑: 필드 이름이나 타입이 다른 경우에는, 개발자가 직접 매핑 규칙을 정의할 수 있습니다.
- 타입 변환: ModelMapper는 타입 변환을 자동으로 처리합니다. 예를 들어, String을 Integer로, Integer를 String으로 변환할 수 있습니다.
- 중첩된 속성 매핑: ModelMapper는 중첩된 속성을 자동으로 매핑할 수 있습니다.

https://squirmm.tistory.com/entry/Spring-modelMapper

---

## Swagger

http://localhost:8080/swagger-ui.html


## +

+ REDIS