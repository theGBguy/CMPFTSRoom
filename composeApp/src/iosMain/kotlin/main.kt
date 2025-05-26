import androidx.compose.ui.window.ComposeUIViewController
import io.github.thegbguy.cmproom.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
