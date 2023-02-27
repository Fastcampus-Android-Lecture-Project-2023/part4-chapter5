# Part4 Chapter5

Part4 Chapter5의 예제와 실습을 모두 담고 있습니다.

[최종본](../../tree/final)과 비교해보세요.

## Compose ViewModel 실습코드 (part4-chapter5-2)

[part4-chapter5-2](part4-chapter5-2) 디렉토리를 Android Studio에서 오픈하세요.

![ViewModel 예](./screenshots/viewmodel.png)

 * 단계 1: "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1" 의존성을 추가합니다.

 * 단계 2: `ViewModel`을 상속받은 `ToDoViewModel`을 만듭니다. 첫 단계에서는 내용을 비워두고 시작합시다.

 * 단계 3: `TopLevel`의 파라미터로 `ToDoViewModel` 타입의 `viewModel`을
  전달합니다. 기본 값은 `viewModel()`로 설정합시다.
  에러가 발생하면 아래의 `import` 문을 추가합니다.

  ```kotlin
  import androidx.lifecycle.viewmodel.compose.viewModel
  ```

 * 단계 4: text, setText를 뷰 모델로 옮겨봅시다.
  뷰 모델의 프로퍼티로 변경할 경우에는 destrunction (비구조화,구조 분해)는 사용할
  수 없으니 `by`를 써봅시다. `remember`는 제거해야 합니다.

 * 단계 5: `toDoList`, `onSubmit`, `onEdit`, `onToggle`,
  `onDelete`를 모두 뷰 모델로 옮겨봅시다.
