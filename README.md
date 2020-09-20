# currency-layer
 currency-layer demo / Spring Boot, Thymeleaf

## 프로젝트 환경
- JDK 1.8
- Spring Boot 2.4.0.RELEASE
- JPA2
- Gradle 4.8+
- DB : h2

## 프로젝트 실행 방법
1. 프로젝트 Clone
2. Gradle Build 수행
3. Run Application
4. http://localhost:8080/ 접속

## 핵심 아이디어
1. 송금 가능 국가를 DTO로 초기화 하여 관리 // CurrencyDTO.java 
2. 금액 표기 시 toLocaleString() 사용 // ex : result.toLocaleString(undefined, {maximumFractionDigits: 2})
3. currencylayer.com API 이용 시 POC 소스코드 그대로 활용 // https://currencylayer.com/documentation

## 개선 아이디어
1. API KEY, ENDPOINT 를 Config 파일로 별도 생성하여 관리 필요
2. Test 코드 추가 작성 필요
3. 환율에 따른 수취금액 계산 시 API 호출 값을 javascript 에 들고 있다가 계산하는 식으로 처리하고 있음
   - 환율 정보가 실시간으로 변하는 정보인 경우 호출 시 마다 API 재 조회를 고려할 필요 있음
4. javascript array 처리 소스코드 개선 필요
   - (https://stackoverflow.com/questions/63969994/how-to-improve-quality-of-my-javascript-given-2-json-format-array)
  
## 기능 구현 내용
1. 송금국가는 미국으로 고정, 기준 통화는 미국달러(USD) 세팅.
2. 수취국가는 한국, 일본, 필리핀 세 군데 중 하나를 select box로 선택. 각각 통화는 KRW, JPY, PHP 이고 선택 시 환율 변경.
3. 송금액을 USD로 입력하고 "송금하기"를 누르면 아래 수취금액이 KRW, JPY, PHP 중 하나로 계산되어서 나와야 합니다.
   - (환율과 수취금액은 소숫점 2째자리까지, 3자리 이상 되면 콤마를 가운데 찍어 표기)
4. 환율정보는 https://currencylayer.com/ 의 무료 서비스를 이용해서 서버 시작 시 수신하여 사용.
5. 수취금액을 입력하지 않거나, 0보다 작은 금액이거나 10,000 USD보다 큰 금액, 혹은 바른 숫자가 아니라면 에러 메시지 표시
