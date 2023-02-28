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

## Compose ViewModel 실습코드 (part4-chapter5-3)

[part4-chapter5-3](part4-chapter5-3) 디렉토리를 Android Studio에서 오픈하세요.

 * 단계 1: "androidx.compose.runtime:runtime-livedata:$compose_ui_version" 의존성을 추가합니다.

 * 단계 2: text 상태를 라이브 데이터로 변경합니다.
  사용하는 측에서는 `text.observeAsState()`로 구독하세요.

 * 단계 3: toDoList 상태를 라이브 데이터로 변경합니다.
  모든 연산에서 List를 새로 만들어 라이브 데이터로 전달해야 합니다!!!
  (초 비추!!)

## Compose CompositionLocal 실습코드 (part4-chapter5-4)

[part4-chapter5-4](part4-chapter5-4) 디렉토리를 Android Studio에서 오픈하세요.

  * 단계 1: `CompositionLocalProvider`을 이용하면 특정 블록에 암시적인 값을 설정할 있습니다.
  `CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.abled)`
  등을 설정해봅시다.
  `LocalContentAlpha`를 `ContentAlpha.disabled`로 설정하겠다는 뜻입니다.
  `ContentAlpha.medium`, `ContentAlpha.high`, `ContentAlpha.abled`등을
  제공할 수 있습니다.
  `LocalContentColor`도 설정해봅시다. `Color.XXX`을 설정하면 됩니다.

 * 단계 2: 중간 중간에 `LocalContentColor.current` 등의 값을 출력해봅시다.
  가장 가까운 곳에서 설정한 값을 `current`로 얻을 수 있습니다.

 * 단계 3: `LocalContext.current`의 `resources`를 출력해보세요.

 * 단계 4: `compositionLocalOf`에 `8.dp`를 넣어 `LocalElevation`을 할당합니다.

 * 단계 5: Card의 elevation에 `LocalElevation`을 적용해봅시다.
 * 단계 6: LocalElevation의 값을 `CompositionLocalProvider`로
  바꾸어 봅시다.