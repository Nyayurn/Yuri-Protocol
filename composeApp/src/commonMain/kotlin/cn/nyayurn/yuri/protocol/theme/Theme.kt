package cn.nyayurn.yuri.protocol.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import androidx.lifecycle.viewmodel.compose.viewModel
import cn.nyayurn.yuri.protocol.YuriViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.getFontResourceBytes
import org.jetbrains.compose.resources.getSystemResourceEnvironment
import yuri_protocol.composeapp.generated.resources.MiSans_Regular
import yuri_protocol.composeapp.generated.resources.Res

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Theme(content: @Composable () -> Unit) {
    val viewModel = viewModel { YuriViewModel() }
    var inited by remember { mutableStateOf(false) }
    if (!inited) {
        inited = true
        viewModel.darkMode = isSystemInDarkTheme()
    }
    val color = remember(viewModel.darkMode) {
        when {
            viewModel.darkMode -> darkScheme
            else -> lightScheme
        }
    }
    var typography by remember { mutableStateOf<Typography?>(null) }
    val defaultTypography = MaterialTheme.typography
    LaunchedEffect(Unit) {
        val fontFamily = FontFamily(
            Font(
                identity = "MiSans-Regular",
                data = getFontResourceBytes(getSystemResourceEnvironment(), Res.font.MiSans_Regular)
            )
        )
        typography = Typography(
            defaultTypography.displayLarge.copy(fontFamily = fontFamily),
            defaultTypography.displayMedium.copy(fontFamily = fontFamily),
            defaultTypography.displaySmall.copy(fontFamily = fontFamily),
            defaultTypography.headlineLarge.copy(fontFamily = fontFamily),
            defaultTypography.headlineMedium.copy(fontFamily = fontFamily),
            defaultTypography.headlineSmall.copy(fontFamily = fontFamily),
            defaultTypography.titleLarge.copy(fontFamily = fontFamily),
            defaultTypography.titleMedium.copy(fontFamily = fontFamily),
            defaultTypography.titleSmall.copy(fontFamily = fontFamily),
            defaultTypography.bodyLarge.copy(fontFamily = fontFamily),
            defaultTypography.bodyMedium.copy(fontFamily = fontFamily),
            defaultTypography.bodySmall.copy(fontFamily = fontFamily),
            defaultTypography.labelLarge.copy(fontFamily = fontFamily),
            defaultTypography.labelMedium.copy(fontFamily = fontFamily),
            defaultTypography.labelSmall.copy(fontFamily = fontFamily)
        )
        viewModel.fontLoaded = true
    }
    val colorScheme = ColorScheme(
        primary = animateColorAsState(color.primary, TweenSpec(600)).value,
        onPrimary = animateColorAsState(color.onPrimary, TweenSpec(600)).value,
        primaryContainer = animateColorAsState(color.primaryContainer, TweenSpec(600)).value,
        onPrimaryContainer = animateColorAsState(color.onPrimaryContainer, TweenSpec(600)).value,
        secondary = animateColorAsState(color.secondary, TweenSpec(600)).value,
        onSecondary = animateColorAsState(color.onSecondary, TweenSpec(600)).value,
        secondaryContainer = animateColorAsState(color.secondaryContainer, TweenSpec(600)).value,
        onSecondaryContainer = animateColorAsState(
            color.onSecondaryContainer,
            TweenSpec(600)
        ).value,
        tertiary = animateColorAsState(color.tertiary, TweenSpec(600)).value,
        onTertiary = animateColorAsState(color.onTertiary, TweenSpec(600)).value,
        tertiaryContainer = animateColorAsState(color.tertiaryContainer, TweenSpec(600)).value,
        onTertiaryContainer = animateColorAsState(color.onTertiaryContainer, TweenSpec(600)).value,
        error = animateColorAsState(color.error, TweenSpec(600)).value,
        onError = animateColorAsState(color.onError, TweenSpec(600)).value,
        errorContainer = animateColorAsState(color.errorContainer, TweenSpec(600)).value,
        onErrorContainer = animateColorAsState(color.onErrorContainer, TweenSpec(600)).value,
        background = animateColorAsState(color.background, TweenSpec(600)).value,
        onBackground = animateColorAsState(color.onBackground, TweenSpec(600)).value,
        surface = animateColorAsState(color.surface, TweenSpec(600)).value,
        onSurface = animateColorAsState(color.onSurface, TweenSpec(600)).value,
        surfaceVariant = animateColorAsState(color.surfaceVariant, TweenSpec(600)).value,
        onSurfaceVariant = animateColorAsState(color.onSurfaceVariant, TweenSpec(600)).value,
        outline = animateColorAsState(color.outline, TweenSpec(600)).value,
        outlineVariant = animateColorAsState(color.outlineVariant, TweenSpec(600)).value,
        scrim = animateColorAsState(color.scrim, TweenSpec(600)).value,
        inverseSurface = animateColorAsState(color.inverseSurface, TweenSpec(600)).value,
        inverseOnSurface = animateColorAsState(color.inverseOnSurface, TweenSpec(600)).value,
        inversePrimary = animateColorAsState(color.inversePrimary, TweenSpec(600)).value,
        surfaceDim = animateColorAsState(color.surfaceDim, TweenSpec(600)).value,
        surfaceBright = animateColorAsState(color.surfaceBright, TweenSpec(600)).value,
        surfaceContainerLowest = animateColorAsState(
            color.surfaceContainerLowest,
            TweenSpec(600)
        ).value,
        surfaceContainerLow = animateColorAsState(color.surfaceContainerLow, TweenSpec(600)).value,
        surfaceContainer = animateColorAsState(color.surfaceContainer, TweenSpec(600)).value,
        surfaceContainerHigh = animateColorAsState(
            color.surfaceContainerHigh,
            TweenSpec(600)
        ).value,
        surfaceContainerHighest = animateColorAsState(
            color.surfaceContainerHighest,
            TweenSpec(600)
        ).value,
        surfaceTint = animateColorAsState(color.surfaceTint, TweenSpec(600)).value
    )
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography ?: defaultTypography,
        content = content
    )
}