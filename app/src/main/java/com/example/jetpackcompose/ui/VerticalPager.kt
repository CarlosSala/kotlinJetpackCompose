package com.example.jetpackcompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.common.MoreScreens
import com.example.jetpackcompose.ui.common.Screens
import com.example.jetpackcompose.ui.morescreenexamples.BadgeJC
import com.example.jetpackcompose.ui.morescreenexamples.AssistChipM3
import com.example.jetpackcompose.ui.morescreenexamples.BottomAppBarM3
import com.example.jetpackcompose.ui.morescreenexamples.CheckboxM3
import com.example.jetpackcompose.ui.morescreenexamples.CircularProgressIndicatorM3
import com.example.material3components.DialogM3
import com.example.jetpackcompose.ui.morescreenexamples.FABM3
import com.example.jetpackcompose.ui.morescreenexamples.ListsM3
import com.example.jetpackcompose.ui.morescreenexamples.MenusM3
import com.example.jetpackcompose.ui.morescreenexamples.ModalBottomSheetM3
import com.example.jetpackcompose.ui.morescreenexamples.NavigationBarM3
import com.example.jetpackcompose.ui.morescreenexamples.NavigationDrawerM3
import com.example.jetpackcompose.ui.morescreenexamples.RadioButtonM3
import com.example.jetpackcompose.ui.morescreenexamples.SearchBarM3
import com.example.jetpackcompose.ui.morescreenexamples.SliderM3
import com.example.jetpackcompose.ui.morescreenexamples.SnackbarM3
import com.example.jetpackcompose.ui.morescreenexamples.SwitchM3
import com.example.jetpackcompose.ui.morescreenexamples.TextFieldsM3
import com.example.jetpackcompose.ui.morescreenexamples.TopAppBarM3
import com.example.jetpackcompose.ui.morescreenexamples.TopAppBarWithScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerticalPagerExample() {

    val pagerState = rememberPagerState(pageCount = { MoreScreens.entries.size })

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        /* Box(
     modifier = Modifier
         .fillMaxSize()
         .padding(16.dp),
     contentAlignment = Alignment.Center
 ) {  Text(text = "Página $page") }*/
        when (MoreScreens.entries[page]) {

            MoreScreens.BadgeJC -> BadgeJC()
            MoreScreens.BottomAppBarJC -> BottomAppBarM3()
            MoreScreens.BottomSheetJC -> ModalBottomSheetM3()
            MoreScreens.CheckBoxJC -> CheckboxM3()
            MoreScreens.ChipsJC -> AssistChipM3()
            MoreScreens.Dialog -> DialogM3()
            MoreScreens.FloatActionButtonJC -> FABM3()
            MoreScreens.ListsJC -> ListsM3()
            MoreScreens.MenuJC -> MenusM3()
            MoreScreens.NavigationBarJC -> NavigationBarM3()
            MoreScreens.NavigationDrawerJC -> NavigationDrawerM3()
            MoreScreens.ProgressIndicatorsJC -> CircularProgressIndicatorM3()
            MoreScreens.RadioButtonJC -> RadioButtonM3()
            MoreScreens.SearchBarJC -> SearchBarM3()
            MoreScreens.SliderJC -> SliderM3()
            MoreScreens.SnackBarJC -> SnackbarM3()
            MoreScreens.SwitchJC -> SwitchM3()
            MoreScreens.TextFieldsJC -> TextFieldsM3()
            MoreScreens.TopAppBarJC -> TopAppBarWithScaffold()
        }
    }
}
