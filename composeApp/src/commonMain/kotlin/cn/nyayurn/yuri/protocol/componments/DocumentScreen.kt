package cn.nyayurn.yuri.protocol.componments

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.UrlAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cn.nyayurn.yuri.protocol.DocumentPage
import cn.nyayurn.yuri.protocol.ScreenSize
import cn.nyayurn.yuri.protocol.YuroViewModel
import cn.nyayurn.yuri.protocol.theme.darkTheme
import org.jetbrains.compose.resources.painterResource
import yuri_protocol.composeapp.generated.resources.Res
import yuri_protocol.composeapp.generated.resources.dark_mode_24px
import yuri_protocol.composeapp.generated.resources.github
import yuri_protocol.composeapp.generated.resources.light_mode_24px
import yuri_protocol.composeapp.generated.resources.translate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideNavigation(
    page: DocumentPage,
    onChange: (DocumentPage) -> Unit,
    viewModel: YuroViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val (_, height) = viewModel.screen.size
    Surface(
        shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier.fillMaxHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                animateDpAsState(
                    when (height) {
                        ScreenSize.Compact -> 16.dp
                        ScreenSize.Medium -> 32.dp
                        ScreenSize.Expanded -> 64.dp
                    },
                    TweenSpec(600)
                ).value
            ),
            modifier = Modifier.fillMaxHeight().padding(
                animateDpAsState(
                    when (height) {
                        ScreenSize.Compact -> 8.dp
                        ScreenSize.Medium -> 16.dp
                        ScreenSize.Expanded -> 32.dp
                    },
                    TweenSpec(600)
                ).value
            )
        ) {
            val navigator = LocalNavigator.currentOrThrow
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                tooltip = {
                    PlainTooltip {
                        Text(text = "返回主页")
                    }
                },
                state = rememberTooltipState()
            ) {
                TextButton(onClick = { navigator.popUntilRoot() }) {
                    Text(
                        text = "Yuri",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            PageList(page = page, onChange = onChange, modifier = Modifier.weight(0.9F))
            BottomBar(modifier = Modifier.weight(0.1F))
        }
    }
}

@Composable
fun PageList(page: DocumentPage, onChange: (DocumentPage) -> Unit, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        TextButton(onClick = { onChange(DocumentPage.Introduction) }) {
            Text(
                text = "介绍",
                color = when (page) {
                    DocumentPage.Introduction -> Color.Unspecified
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                style = MaterialTheme.typography.titleLarge
            )
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.onSurfaceVariant)
        TextButton(onClick = { onChange(DocumentPage.Overview) }) {
            Text(
                text = "总览",
                color = when (page) {
                    DocumentPage.Overview -> Color.Unspecified
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                style = MaterialTheme.typography.titleMedium
            )
        }
        TextButton(onClick = { onChange(DocumentPage.Action) }) {
            Text(
                text = "事件动作",
                color = when (page) {
                    DocumentPage.Action -> Color.Unspecified
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                style = MaterialTheme.typography.titleMedium
            )
        }
        TextButton(onClick = { onChange(DocumentPage.Event) }) {
            Text(
                text = "事件流",
                color = when (page) {
                    DocumentPage.Event -> Color.Unspecified
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                style = MaterialTheme.typography.titleMedium
            )
        }
        TextButton(onClick = { onChange(DocumentPage.Encoding) }) {
            Text(
                text = "消息编码",
                color = when (page) {
                    DocumentPage.Encoding -> Color.Unspecified
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                style = MaterialTheme.typography.titleMedium
            )
        }
        TextButton(onClick = { onChange(DocumentPage.Element) }) {
            Text(
                text = "标准元素",
                color = when (page) {
                    DocumentPage.Element -> Color.Unspecified
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                PlainTooltip {
                    Text(text = "语言")
                }
            },
            state = rememberTooltipState()
        ) {
            var expanded by remember { mutableStateOf(false) }
            IconButton(
                onClick = { expanded = true }
            ) {
                Icon(
                    painter = painterResource(Res.drawable.translate),
                    contentDescription = null
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = "简体中文")
                    },
                    onClick = {
                        expanded = false
                    }
                )
            }
        }
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                PlainTooltip {
                    Text(text = "深色主题")
                }
            },
            state = rememberTooltipState()
        ) {
            Switch(
                checked = darkTheme,
                onCheckedChange = { darkTheme = it },
                thumbContent = {
                    when {
                        darkTheme -> Icon(
                            painter = painterResource(Res.drawable.dark_mode_24px),
                            contentDescription = null
                        )

                        else -> Icon(
                            painter = painterResource(Res.drawable.light_mode_24px),
                            contentDescription = null
                        )
                    }
                }
            )
        }
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                PlainTooltip {
                    Text(text = "Github")
                }
            },
            state = rememberTooltipState()
        ) {
            IconButton(
                onClick = {
                    uriHandler.openUri("https://github.com/Nyayurn/Yuri-Protocol")
                }
            ) {
                Icon(
                    painter = painterResource(Res.drawable.github),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun Body(
    page: DocumentPage,
    viewModel: YuroViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val (width, _) = viewModel.screen.size
    AnimatedContent(
        targetState = page,
        modifier = modifier.padding(
            animateDpAsState(
                when (width) {
                    ScreenSize.Compact -> 16.dp
                    ScreenSize.Medium -> 32.dp
                    ScreenSize.Expanded -> 64.dp
                }
            ).value
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            when (it) {
                DocumentPage.Introduction -> Introduction()
                DocumentPage.Overview -> Overview()
                DocumentPage.Action -> Action()
                DocumentPage.Event -> Event()
                DocumentPage.Encoding -> Encoding()
                DocumentPage.Element -> Element()
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun Introduction() {
    Text(
        text = "介绍",
        style = MaterialTheme.typography.titleLarge
    )
    SelectionContainer {
        val text = buildAnnotatedString {
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                append("Yuri 是一个通用的聊天协议, 目的是抹除不同聊天协议在使用 ")
                withAnnotation(
                    UrlAnnotation("https://nyayurn.github.io/Yuro-Standardize/")
                ) {
                    withStyle(
                        SpanStyle(
                            color = Color(51, 102, 204),
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Yuro")
                    }
                }
                appendLine(" 开发时多余的学习成本, 以一套代码接入任何协议, 让开发者以更低的成本开发出跨平台, 可扩展的聊天应用")
                append("Yuri 的名称来源于游戏喵可莉的兔玩偶和咸鱼喵喵中的角色 ")
                withAnnotation(
                    UrlAnnotation("https://nyaruru-fishy-fight.fandom.com/zh/wiki/%E8%8E%89%E4%BC%8A")
                ) {
                    withStyle(
                        SpanStyle(
                            color = Color(51, 102, 204),
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("莉伊(Yuri)")
                    }
                }
                appendLine(", 下文中\"她\"指代 Yuri")
                append("Yuri 是 ")
                withAnnotation(
                    UrlAnnotation("https://satori.js.org/zh-CN/")
                ) {
                    withStyle(
                        SpanStyle(
                            color = Color(51, 102, 204),
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Satori")
                    }
                }
                appendLine(" 在 Yuro 上的特殊实现")
            }
        }
        val uriHandler = LocalUriHandler.current
        ClickableText(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        ) { offset ->
            text.getUrlAnnotations(offset, offset).firstOrNull { annotation ->
                uriHandler.openUri(annotation.item.url)
                true
            }
        }
    }
}

@Composable
fun Overview() {
    Text(
        text = "总览",
        style = MaterialTheme.typography.titleLarge
    )
    SelectionContainer {
        Text(
            text = buildString {
                appendLine("Yuri 的通信分为两块:")
                appendLine("事件动作(Event Action): 一套使用 HTTP 的 API 服务, 用于发送事件")
                append("事件流(Event Stream): 一个使用 ServerSendEvent/WebSocket/WebHook 的消息下发服务, 用于持续接收事件")
            },
            style = MaterialTheme.typography.bodyLarge
        )
    }
    HorizontalDivider()
    Text(
        text = "核心概念",
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun Action() {
    Text(
        text = "事件动作",
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun Event() {
    Text(
        text = "事件流",
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun Encoding() {
    Text(
        text = "消息编码",
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun Element() {
    Text(
        text = "消息元素",
        style = MaterialTheme.typography.titleLarge
    )
}