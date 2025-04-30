package com.chirag.jetpack.compose.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.calculatePan
import androidx.compose.foundation.gestures.calculateZoom
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chirag.jetpack.compose.AppBarTitleText
import com.chirag.jetpack.compose.R
import com.chirag.jetpack.compose.theme.ChiragAppTheme

class ImageZoomPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChiragAppTheme {
                Surface {
                    ImageZoomPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ImageZoomPageUI() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .clickable(
                            indication = rememberRipple(color = Color.Black),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            finish()
                        }
                        .fillMaxHeight()
                        .width(50.dp)
                        .clipToBounds()
                        .padding(horizontal = 13.dp),
                )

                val Mpadding = Modifier.align(Alignment.CenterStart)
                AppBarTitleText(Mpadding, text = "Image Zoom Page")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                ZoomableComposable()
            }
        }
    }
}

@Composable
fun ZoomableComposable() {
    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    val maxScale = 5f
    val minScale = 1f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clipToBounds()
            .background(Color.LightGray)
            .pointerInput(Unit) {
                forEachGesture {
                    awaitPointerEventScope {
                        awaitFirstDown()
                        do {
                            val event = awaitPointerEvent()
                            scale = (scale * event.calculateZoom()).coerceIn(minScale, maxScale)
                            val offset = event.calculatePan()
                            offsetX += offset.x
                            offsetY += offset.y
                        } while (event.changes.any { it.pressed })
                    }
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        val imagepainter = painterResource(id = R.drawable.logo)
        Image(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offsetX,
                    translationY = offsetY
                ),
            painter = imagepainter,
            contentDescription = "Zoomable image",
        )
    }
}