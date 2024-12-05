package com.example.jetpackcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.jetpackcompose.ui.common.MainTopAppBar
import com.example.jetpackcompose.ui.common.MoreScreens
import com.example.jetpackcompose.ui.morescreenexamples.AlertDialogM3
import com.example.jetpackcompose.ui.morescreenexamples.BadgeJC
import com.example.jetpackcompose.ui.morescreenexamples.BottomAppBarWithScaffoldJC
import com.example.jetpackcompose.ui.morescreenexamples.CheckboxJC
import com.example.jetpackcompose.ui.morescreenexamples.ChipsJC
import com.example.jetpackcompose.ui.morescreenexamples.CircularProgressCanvasJC
import com.example.jetpackcompose.ui.morescreenexamples.CircularProgressIndicator2JC
import com.example.jetpackcompose.ui.morescreenexamples.DockedSearchBarJC
import com.example.jetpackcompose.ui.morescreenexamples.FABWithScaffold
import com.example.jetpackcompose.ui.morescreenexamples.LargeTopAppBarWithScaffold
import com.example.jetpackcompose.ui.morescreenexamples.ListsJC
import com.example.jetpackcompose.ui.morescreenexamples.MenusJC
import com.example.jetpackcompose.ui.morescreenexamples.ModalBottomSheetJC
import com.example.jetpackcompose.ui.morescreenexamples.NavigationBarWithScaffoldJC
import com.example.jetpackcompose.ui.morescreenexamples.NavigationDrawerJC
import com.example.jetpackcompose.ui.morescreenexamples.RadioButtonJC
import com.example.jetpackcompose.ui.morescreenexamples.SliderJC
import com.example.jetpackcompose.ui.morescreenexamples.SwitchJC
import com.example.jetpackcompose.ui.morescreenexamples.TextFieldsJC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerticalPagerExample(windowInsets: (WindowInsets) -> Unit) {

    windowInsets(WindowInsets.statusBars)
    val pagerState = rememberPagerState(pageCount = { MoreScreens.entries.size })
    var title by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            MainTopAppBar(
                //modifier = Modifier.windowInsetsTopHeight(insets = WindowInsets(top = 70.dp)),
                // color = Color.DarkGray,
                onTitleChange = title,
                selectedTheme = {},
                onBack = {}
            )
        },
        bottomBar = {},
        floatingActionButton = {},
        snackbarHost = {},
        modifier = Modifier
            .windowInsetsPadding(insets = WindowInsets.statusBars)
            .background(Color.Cyan),
        // contentWindowInsets =
        // containerColor = Color.Yellow
    ) { paddingValues ->

        VerticalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            key = { page -> MoreScreens.entries[page].displayName }
        ) { page ->

            title = MoreScreens.entries[pagerState.currentPage].displayName

            when (MoreScreens.entries[page]) {

                MoreScreens.CustomCanvas -> CircularProgressCanvasJC()
                MoreScreens.BadgeJC -> BadgeJC()
                MoreScreens.BottomAppBarJC -> BottomAppBarWithScaffoldJC()
                MoreScreens.BottomSheetJC -> ModalBottomSheetJC()
                MoreScreens.CheckBoxJC -> CheckboxJC()
                MoreScreens.ChipsJC -> ChipsJC()
                MoreScreens.Dialog -> AlertDialogM3()
                MoreScreens.FloatActionButtonJC -> FABWithScaffold()
                MoreScreens.ListsJC -> ListsJC()
                MoreScreens.MenuJC -> MenusJC()
                MoreScreens.NavigationBarJC -> NavigationBarWithScaffoldJC()
                MoreScreens.NavigationDrawerJC -> NavigationDrawerJC()
                MoreScreens.ProgressIndicatorsJC -> CircularProgressIndicator2JC()
                MoreScreens.RadioButtonJC -> RadioButtonJC()
                MoreScreens.SearchBarJC -> DockedSearchBarJC()
                MoreScreens.SliderJC -> SliderJC()
                MoreScreens.SwitchJC -> SwitchJC()
                MoreScreens.TextFieldsJC -> TextFieldsJC()
                MoreScreens.TopAppBarJC -> LargeTopAppBarWithScaffold()
            }
        }
    }
}
