import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cn.nyayurn.yuri.protocol.App

fun main() = application {
    Window(
        title = "Yuro-Standardize",
        state = rememberWindowState(WindowPlacement.Maximized),
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}