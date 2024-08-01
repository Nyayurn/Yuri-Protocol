package cn.nyayurn.yuri.protocol.componments

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cn.nyayurn.yuri.protocol.DocumentScreen
import cn.nyayurn.yuri.protocol.ScreenSize
import cn.nyayurn.yuri.protocol.YuroViewModel
import cn.nyayurn.yuri.protocol.stringLengthConverter

@Composable
fun Title(viewModel: YuroViewModel = viewModel(), modifier: Modifier = Modifier) {
    val (width, _) = viewModel.screen.size
    Text(
        text = animateValueAsState(
            targetValue = when (width) {
                ScreenSize.Compact -> "Yuri"
                else -> "Yuri Protocol"
            },
            typeConverter = remember { stringLengthConverter("Yuri Protocol") },
            animationSpec = remember { TweenSpec(durationMillis = 600) }
        ).value,
        style = MaterialTheme.typography.displayLarge,
        modifier = modifier
    )
}

@Composable
fun Description(viewModel: YuroViewModel = viewModel(), modifier: Modifier = Modifier) {
    val (width, _) = viewModel.screen.size
    AnimatedContent(width) {
        Text(
            text = "THE UNIVERSAL MESSENGER PROTOCOL",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
fun Start() {
    val navigator = LocalNavigator.currentOrThrow
    ElevatedButton(
        onClick = { navigator.push(DocumentScreen) },
        elevation = ButtonDefaults.elevatedButtonElevation(16.dp, 16.dp, 16.dp, 16.dp)
    ) {
        Text(
            text = "即刻起步",
            style = MaterialTheme.typography.displaySmall
        )
    }
}