package cn.nyayurn.yuri.protocol

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import cn.nyayurn.yuri.protocol.theme.Theme

@Composable
internal fun App() {
    Theme {
        BoxWithConstraints {
            val viewModel = viewModel<YuriViewModel>()
            remember(maxWidth, maxHeight) { viewModel.screen = Screen(maxWidth, maxHeight) }
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {
                Navigator(LoadingScreen) { navigator ->
                    FadeTransition(navigator)
                }
            }
        }
    }
}

class YuriViewModel : ViewModel() {
    var screen: Screen by mutableStateOf(Screen(0.dp, 0.dp))
    var darkMode by mutableStateOf(false)
    var fontLoaded by mutableStateOf(false)
}

data class Screen(val width: Dp, val height: Dp) {
    val size: Pair<ScreenSize, ScreenSize> = when {
        width < 600.dp -> ScreenSize.Compact
        width < 840.dp -> ScreenSize.Medium
        else -> ScreenSize.Expanded
    } to when {
        height < 480.dp -> ScreenSize.Compact
        height < 900.dp -> ScreenSize.Medium
        else -> ScreenSize.Expanded
    }
}