
# 🛡 Spring Security 인증 아키텍처

Spring Security에서 로그인 요청이 들어오고 인증이 완료되기까지의 전체 흐름을 설명합니다.  
아래 다이어그램은 인증이 어떻게 처리되는지를 단계별로 보여줍니다.

---

## 🔍 인증 흐름 요약

```
1. 사용자가 로그인 요청 (/login 등)을 보냄
2. AuthenticationFilter가 요청을 가로채고 인증 토큰 생성
3. AuthenticationManager에게 인증 요청을 위임
4. AuthenticationProvider가 실제 인증 로직 수행
5. UserDetailsService에서 사용자 정보 조회
6. UserDetails로 사용자 정보 반환
7. 비밀번호 등 검증 후 인증 성공 여부 판단
8. 인증 성공 시 Authentication 객체 생성
9. SecurityContextHolder에 Authentication 저장
10. 인증 완료 → 다음 필터 또는 리소스로 이동
```

---

## 🗂 주요 컴포넌트 설명

| 컴포넌트 | 역할 |
|----------|------|
| **AuthenticationFilter** | 로그인 요청을 가로채고 인증 처리 시작 |
| **UsernamePasswordAuthenticationToken** | 사용자의 ID/PW를 담는 인증 요청 객체 |
| **AuthenticationManager** | 인증 처리 담당자 (위임자 역할) |
| **AuthenticationProvider** | 실제 인증 로직 수행 |
| **UserDetailsService** | 사용자 정보를 DB 등에서 조회 |
| **UserDetails** | 사용자 정보 객체 (User 등) |
| **SecurityContextHolder** | 인증 완료 후 인증 정보 저장소 |

---

## 🖼 아키텍처 다이어그램

> Spring Security Authentication Architecture

📌 이 이미지를 Notion에 업로드하거나 붙여넣기하세요:

![Spring Security 인증 흐름](첨부된_이미지_사용)

> 출처: [springbootdev.com](https://www.springbootdev.com)

---

## ✅ 예시 코드로 이해하는 인증 흐름

### 1. 사용자 로그인 요청
```http
POST /login
Content-Type: application/json

{
  "username": "kim",
  "password": "1234"
}
```

### 2. AuthenticationFilter: 인증 토큰 생성 및 위임
```java
UsernamePasswordAuthenticationToken token =
    new UsernamePasswordAuthenticationToken("kim", "1234");

// 인증 처리 위임
Authentication authResult = authenticationManager.authenticate(token);
```

### 3. UserDetailsService 구현 예시
```java
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
```

### 4. SecurityContextHolder에 인증 정보 저장
```java
SecurityContextHolder.getContext().setAuthentication(authResult);
```

---

## 🧠 정리

Spring Security는 복잡해 보이지만, 핵심은 다음과 같습니다:

- 요청 → 필터 → 토큰 생성 → 인증 로직 위임 → 사용자 정보 조회 → 인증 완료 후 저장  
- 각 단계는 확장(커스터마이징)이 가능하며, 직접 구현체를 등록할 수 있음

---
