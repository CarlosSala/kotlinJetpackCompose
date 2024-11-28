package com.example.jetpackcompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.common.MoreScreens
import com.example.jetpackcompose.ui.morescreenexamples.AlertDialogM3
import com.example.jetpackcompose.ui.morescreenexamples.BadgeJC
import com.example.jetpackcompose.ui.morescreenexamples.BottomAppBarWithScaffoldJC
import com.example.jetpackcompose.ui.morescreenexamples.CheckboxJC
import com.example.jetpackcompose.ui.morescreenexamples.ChipsJC
import com.example.jetpackcompose.ui.morescreenexamples.CircularProgressIndicator2JC
import com.example.jetpackcompose.ui.morescreenexamples.DockedSearchBarJC
import com.example.jetpackcompose.ui.morescreenexamples.FABWithScaffold
import com.example.jetpackcompose.ui.morescreenexamples.ListsJC
import com.example.jetpackcompose.ui.morescreenexamples.MenusJC
import com.example.jetpackcompose.ui.morescreenexamples.ModalBottomSheetJC
import com.example.jetpackcompose.ui.morescreenexamples.NavigationBarWithScaffoldJC
import com.example.jetpackcompose.ui.morescreenexamples.NavigationDrawerJC
import com.example.jetpackcompose.ui.morescreenexamples.RadioButtonJC
import com.example.jetpackcompose.ui.morescreenexamples.SearchBarJC
import com.example.jetpackcompose.ui.morescreenexamples.SliderJC
import com.example.jetpackcompose.ui.morescreenexamples.SwitchJC
import com.example.jetpackcompose.ui.morescreenexamples.TextFieldsJC
import com.example.jetpackcompose.ui.morescreenexamples.LargeTopAppBarWithScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerticalPagerExample() {

    val pagerState = rememberPagerState(pageCount = { MoreScreens.entries.size })

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        when (MoreScreens.entries[page]) {

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
