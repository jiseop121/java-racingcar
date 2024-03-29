# JAVA - RACING CAR
## 🗂️Package 구조
### [Model]
#### Car
- 역할 : `Name`과 `Distance`를 담은 객체
#### Cars
- 역할 : 레이싱에 참여하는 `Car`들의 묶음
#### Name
- 역할 : Car의 이름 객체
#### Distance
- 역할 : Car의 진출거리 객체
#### RaceCount
- 역할 : RaceCount를 통해
#### WinningCars
- 역할 : 우승한 `Cars`를 담은 객체
#### RaceOnceOperator
- 역할 : 한 회 레이싱을 진행
#### NumberGenerator (interface)
- 역할 : 진출 여부를 판단하는 수 생성 및 진출 여부 반환
### [Controller]
#### RacingController
- 역할 : 게임 진행
### [View]
#### InputView
- 역할 : 사용자 입력 `InputParser`를 통해 반환
#### InputParser
- 역할 : 문자열을 원하는 객체로 변환
#### OutputView
- 역할 : 입력 문구 , 결과 문구 출력
### [Validation]
#### ErrorMessage (enum)
- 역할 : 에러 메세지 문구 모음
#### Validator
- 역할 : Model과 View의 검증
## 🗂️Test

### utils
#### TestNumberGenerator

## 🗂️추가 및 발전 항목
- Car에 들어가는 요소들도 더 세세하게 객체로 쪼갰다
- `validation`이라는 이름보단 행동의 의미가 들어가도록 `validator`로 변경하였다.
- 실제 view에서도 객체 단위로 데이터를 입력받아 서비스에 전달하는 것을 모방하여, Input을 받으면 객체로 서비스모델에 바로 들어갈 수 있도록 입력을 객체로 바꾸는 `InputParser`클래스 생성
- 도메인에 record 사용
## 🗂️고민사항
- validator 적용(InputView vs InputParser)
- record 사용의 정확한 목적과 이점
- validate 분리에서 오는 불필요한 복잠함과 비효율성(RaceOnceOperator)
- 의존성 주입과 메서드 인자로 넣는 것에 대한 고민