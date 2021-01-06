졸업 프로젝트 컨벤션

### 모든 문서, 파일의 인코딩은 UTF-8로 통일한다.

### .java
* 들여쓰기는 탭(tab)키를 사용.
	- 클래스, 메서드, 제어문 등 코드 블록은 사용마다 한 단계 씩 들여 쓴다.
	
* 그 외 이클립스 기본 컨벤션 지키기.
* 카멜표기법 적용
* 테스트 클래스 혹은 테스트 메서드는 Test 붙이기.
* 클래스 이름은 최대한 명사 사용.
* 인터페이스 이름은 명사/형용사 사용.

### Commit
#### 양식
**prefix: {변경 내용} (#{이슈번호})**

**ex)** feat: 부트스트랩 연동 (#10)

* prefix
	- 기능 추가 : feat:
	- 오류 수정 : fix:
	- 잡다한 일 : chore
	- 문서화 : doc:
	- 리팩토링 : refactor: