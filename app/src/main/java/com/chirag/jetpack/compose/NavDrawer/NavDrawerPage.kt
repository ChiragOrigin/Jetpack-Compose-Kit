package com.chirag.jetpack.compose.NavDrawer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chirag.jetpack.compose.AppBarTitleText
import com.chirag.jetpack.compose.R
import com.chirag.jetpack.compose.selectedButton
import com.chirag.jetpack.compose.theme.Clr1
import com.chirag.jetpack.compose.theme.Clr2
import com.chirag.jetpack.compose.theme.Clr3
import com.chirag.jetpack.compose.theme.Clr4
import com.chirag.jetpack.compose.theme.Clr5
import com.chirag.jetpack.compose.theme.Clr6
import com.chirag.jetpack.compose.theme.L_Clr1
import com.chirag.jetpack.compose.theme.L_Clr2
import com.chirag.jetpack.compose.theme.L_Clr3
import com.chirag.jetpack.compose.theme.L_Clr4
import com.chirag.jetpack.compose.theme.L_Clr5
import com.chirag.jetpack.compose.theme.L_Clr6
import com.chirag.jetpack.compose.theme.ChiragAppTheme

class NavDrawerPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChiragAppTheme {
                Surface {
                    NavDrawerPageUI()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun NavDrawerPageUI() {
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
                        .height(55.dp)
                        .width(55.dp)
                        .padding(15.dp)
                        .clipToBounds()
                        .clickable(indication = rememberRipple(color = Color.Black),
                            interactionSource = remember { MutableInteractionSource() } // This is mandatory
                        ) {
                            finish()
                        },
                )

                val Mpadding = Modifier.align(Alignment.CenterStart)
                AppBarTitleText(Mpadding, text = "Navigation Drawer")
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                selectedButton(
                    R.drawable.ic_navdrawer, "Navigation Drawer", Clr1, L_Clr1,
                    tags = listOf(
                        "App Drawer",
                        "Drawer Header",
                        "Drawer Item",
                        "Top AppBar",
                        "Navigation Icon",
                        "SnackBar",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@NavDrawerPage, SideNavPage::class.java
                            )
                        )
                    }
                )

                selectedButton(
                    R.drawable.ic_navdrawer, "Model Navigation Drawer", Clr2, L_Clr2,
                    tags = listOf(
                        "Modal Drawer",
                        "Top AppBar",
                        "Composition Local Provider",
                        "Lazy Column",
                        "List Item",
                        "Custom SnackBar",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@NavDrawerPage, ModelNavDrawerPage::class.java
                            )
                        )
                    }
                )

                selectedButton(
                    R.drawable.ic_navdrawer, "Model Navigation Drawer 1", Clr3, L_Clr3,
                    tags = listOf(
                        "Modal Drawer",
                        "Top AppBar",
                        "Composition Local Provider",
                        "Lazy Column",
                        "List Item",
                        "Custom SnackBar",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@NavDrawerPage, ModelNavDrawerPage1::class.java
                            )
                        )
                    }
                )

                selectedButton(
                    R.drawable.ic_navdrawer, "Model Navigation Drawer 2", Clr4, L_Clr4,
                    tags = listOf(
                        "Modal Drawer",
                        "Scaffold",
                        "Drawer Elevation",
                        "Drawer Shape",
                        "Top AppBar",
                        "Composition Local Provider",
                        "Lazy Column",
                        "List Item",
                        "Custom SnackBar",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@NavDrawerPage, ModelNavDrawerPage2::class.java
                            )
                        )
                    }
                )

                selectedButton(
                    R.drawable.ic_navdrawer, "Bottom Sheet", Clr5, L_Clr5,
                    tags = listOf(
                        "Bottom Sheet",
                        "isExpanded",
                        "isCollapsed",
                        "Offset",
                        "Progress",
                        "Floating Action Button",
                        "Lazy Column",
                        "List Item",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@NavDrawerPage, BottomSheetPage::class.java
                            )
                        )
                    }
                )

                selectedButton(
                    R.drawable.ic_navdrawer, "Bottom Sheet", Clr6, L_Clr6,
                    tags = listOf(
                        "Bottom Sheet",
                        "isExpanded",
                        "isCollapsed",
                        "Offset",
                        "Progress",
                        "Floating Action Button",
                        "Lazy Column",
                        "List Item",
                    ),
                    onIntent = {
                        startActivity(
                            Intent(
                                this@NavDrawerPage, ModelBottomSheetPage::class.java
                            )
                        )
                    }
                )

            }
        }
    }
}