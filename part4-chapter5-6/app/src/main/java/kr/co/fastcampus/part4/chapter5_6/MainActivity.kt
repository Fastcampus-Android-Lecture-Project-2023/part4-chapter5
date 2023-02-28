package kr.co.fastcampus.part4.chapter5_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.fastcampus.part4.chapter5_6.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyNav()
                }
            }
        }
    }
}

// 단계 2: `navController` 파라미터를 만듭니다.
// `NavHostController` 타입에 기본 값은 `rememberNavController()`
@Composable
fun MyNav(
    modifier: Modifier = Modifier,
) {
    // 단계 3: `NavHost`를 만듭니다.
    // `navController`, `"Home"`, `modifier`를 전달합시다.

    // 단계 4: `composable("Home")`를 만들고 안에 "Office로 이동" 버튼을
    // 만듭니다.

    // 단계 5: `composable("Office")`를 만들고 텍스트를 넣어봅시다.
    // "Office로 이동" 버튼에 `navController.navigate("Office")`를
    // 넣어줍니다.

    // 단계 6: `Playground`를 만들고 `Home`, `Office`, `Playgorund`를
    // 서로 연결합니다.

    // 단계 7: Home, Office, Playgorund, Home, Office, Playgorund
    // 순으로 이동한 후 백버튼을 계속 눌러서 이동을 확인해봅시다.

    // 단계 8: navigate에 후행 람다로 `popUpTo("Home")`을 넣고 스택 이동을
    // 확인해봅니다.

    // 단계 9: `popUpTo`의 후행 람다에 `inclusive = true`를 넣어보고
    // 스택 이동을 확인해봅시다.

    // 단계 10: `Home`에서 `Home`으로 가는 버튼을 만들고
    // `launchSingleTop = true`을 설정해보세요.

    // 단계 11: "Argument/{userId}"를 라우트로 받는
    // composable을 만드세요.
    // `arguments?.get("userId")`을 받아 출력하세요.
    // "Argument/fastcampus"로 이동하는 버튼을 만들어보세요.
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationTheme {
        MyNav()
    }
}