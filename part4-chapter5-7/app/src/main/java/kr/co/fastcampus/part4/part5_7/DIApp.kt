package kr.co.fastcampus.part4.part5_7

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 단계 2: DIApp을 `@HiltAndroidApp`로 어노테이션합니다.
@HiltAndroidApp
class DIApp : Application()