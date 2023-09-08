## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

### 기능 목록
1. 사용자의 응답과 비교할 정답 난수를 생성한다
   * 각 자리수가 1이상 9이하여야 함
   * 세개의 자리수가 각각 중복되지 않아야 함
2. 사용자의 3자리수를 입력받아 정답과 비교 및 응답한다.
   1. 사용자의 입력값은 다음과 같은 기준이 존재
      * 3자리의 정수
      * 각 자리수가 1이상 9이하
      * 각 숫자가 중복되지 않음
   2. 사용자의 입력값을 정답 난수와 비교 
      * 자리수가 숫자가 모두 동일하면 스트라이크
      * 자리수는 다르지만 동일한 숫자가 존재할 경우 볼
      * 스트라이크 및 볼이 없을 경우 낫띵