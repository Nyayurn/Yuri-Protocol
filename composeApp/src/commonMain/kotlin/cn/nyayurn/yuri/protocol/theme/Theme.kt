package cn.nyayurn.yuri.protocol.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import yuri_protocol.composeapp.generated.resources.MapleMono_NF_CN_Regular
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

var darkTheme by mutableStateOf(false)
private var inited = false

@Composable
fun Theme(content: @Composable () -> Unit) {
    if (!inited) {
        inited = true
        darkTheme = isSystemInDarkTheme()
    }
    val color = remember(darkTheme) {
        when {
            darkTheme -> darkScheme
            else -> lightScheme
        }
    }
    val maple = FontFamily(
        /*Font(
            resource = Res.font.MapleMono_NF_CN_Bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_BoldItalic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_ExtraBold,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_ExtraBoldItalic,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_ExtraLight,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_ExtraLightItalic,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_Italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_Light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_LightItalic,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_Medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_MediumItalic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic
        ),*/
        Font(
            resource = Res.font.MapleMono_NF_CN_Regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        /*Font(
            resource = Res.font.MapleMono_NF_CN_SemiBold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_SemiBoldItalic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_Thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.MapleMono_NF_CN_ThinItalic,
            weight = FontWeight.Thin,
            style = FontStyle.Italic
        )*/
    )
    val typography = Typography(
        MaterialTheme.typography.displayLarge.copy(fontFamily = maple),
        MaterialTheme.typography.displayMedium.copy(fontFamily = maple),
        MaterialTheme.typography.displaySmall.copy(fontFamily = maple),
        MaterialTheme.typography.headlineLarge.copy(fontFamily = maple),
        MaterialTheme.typography.headlineMedium.copy(fontFamily = maple),
        MaterialTheme.typography.headlineSmall.copy(fontFamily = maple),
        MaterialTheme.typography.titleLarge.copy(fontFamily = maple),
        MaterialTheme.typography.titleMedium.copy(fontFamily = maple),
        MaterialTheme.typography.titleSmall.copy(fontFamily = maple),
        MaterialTheme.typography.bodyLarge.copy(fontFamily = maple),
        MaterialTheme.typography.bodyMedium.copy(fontFamily = maple),
        MaterialTheme.typography.bodySmall.copy(fontFamily = maple),
        MaterialTheme.typography.labelLarge.copy(fontFamily = maple),
        MaterialTheme.typography.labelMedium.copy(fontFamily = maple),
        MaterialTheme.typography.labelSmall.copy(fontFamily = maple)
    )
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
    MaterialTheme(colorScheme = colorScheme, typography = typography, content = content)
}