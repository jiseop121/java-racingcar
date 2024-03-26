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
- 역할 : 문자열을 원하는 형식으로 변환
#### OutputView
- 역할 : 입력 문구 , 결과 문구 출력
### [Error]
#### ErrorMessage (enum)
- 역할 : 에러 메세지 문구 모음
#### Validation
- 역할 : Model과 View의 검증
## 🗂️Test