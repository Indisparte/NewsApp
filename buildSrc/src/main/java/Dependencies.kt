object Versions {
    const val core = "1.7.0"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"
    const val constraintLayout = "2.1.4"
    const val jUnit = "4.13.2"
    const val extJUnit = "1.1.5"
    const val espresso = "3.5.1"
    const val lottieAnimation = "4.2.0"
}

object Dependencies {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

}

object TestImplementation {
    const val jUnit = "junit:junit:${Versions.jUnit}"
}

object AndroidTestImplementation {
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Retrofit {
    const val retrofit = ""
    const val gsonConverter = ""
    const val okHttp = ""
    const val scalarsConverters = ""
}

object Coroutines {
    const val coroutineCore = ""
    const val coroutineAndroid = ""
}

object CoroutinesLifecycleScope {
    const val lifecycleViewModel = ""
    const val lifecycleRuntime = ""
}

object Glide {
    const val glide = ""
    const val annotationProcessor = ""
}

object ViewModelDelegate {
    const val viewModelDelegate = ""
}

object DaggerHilt {
    const val hilt = ""
    const val hiltAndroidCompiler = ""
    const val hiltCompiler = ""
}

object Room {
    const val roomCompiler = ""
    const val room = ""
}

object CircularProgressBar {
    const val swipeRefresh = ""
}

object LottieAnimations {
    const val lottieAnimationsKotlin = "com.airbnb.android:lottie-kotlin:${Versions.lottieAnimation}"
    const val lottieAnimation = "com.airbnb.android:lottie:${Versions.lottieAnimation}"
}
