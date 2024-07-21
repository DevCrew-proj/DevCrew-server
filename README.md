## DevCrew-server conventions


| 타입           | 설명            |
| -------------- | --------------- |
| **[Feat]**  | 새로운 기능 추가 |
| **[Enhancement]** | 기존 기능 개선 |
| **[Doc]** | 문서화 관련 |
| **[Task]** | 특정 작업 또는 할 일 |
| **[Refactor]** | 코드 리팩토링 |
| **[Fix]** | 버그 수정 |
| **[!HOTFIX]** | 급한 치명적인 버그 수정 |
| **[Chore]** | 빌드 업무 수정, 패키지 매니저 수정 |
| **[Style]** | 코드 포맷팅, 코드 오타, 함수명 수정 등 |
| **[Design]** | 디자인 관련 |
| **[Test]** | 테스트 관련 |
| **[Bug]** | 버그 관련 이슈 |

-----

### 1. issue convention

**📌 형식**: 

[타입] 이슈 내용


**📌 예시**: 

[Feat] User 도메인 구현<br>
[Refactor] User 관련 DTO 수정

⭐️ assigner와 해당하는 라벨도 체크해주세요!

  -------------

### 2. branch convention

**📌 형식**: 

타입/#이슈번호-간단한 설명

⭐️ 이때 타입은 해당 Branch의 이슈 타입과 동일하게 가져가시면 됩니다!

  
**📌 예시**: 

feat/#1-User-도메인-설계<br>
refactor/#32-쿼리-최적화

----------------

### 3. commit convention

**📌 형식**: 

커밋 타입(#이슈번호) : 커밋 내용<br>

**📌 예시**: 

feat(#32) : User 도메인 구현<br>
feat(#32) : User 필드값 annotation 추가<br>

