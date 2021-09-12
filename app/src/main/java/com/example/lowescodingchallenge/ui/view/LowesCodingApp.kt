package com.example.lowescodingchallenge.ui.view

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lowescodingchallenge.ui.routing.LowesRouter
import com.example.lowescodingchallenge.ui.routing.Screen
import com.example.lowescodingchallenge.ui.theme.LowesCodingChallengeTheme
import com.example.lowescodingchallenge.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun LowesCodingApp(viewModel: MainViewModel) {
    LowesCodingChallengeTheme {
        AppContent(viewModel)
    }
}

@ExperimentalAnimationApi
@Composable
private fun AppContent(viewModel: MainViewModel) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Crossfade(targetState = LowesRouter.currentScreen) { screenState: MutableState<Screen> ->

        Scaffold (
            topBar = getTopBar(screenState.value, scaffoldState, coroutineScope),
            scaffoldState = scaffoldState,
            bottomBar = {
                BottomNavigationComponent(screenState = screenState)
            },
            content = {
                MainScreenContainer(
                    modifier = Modifier.padding(bottom = 56.dp),
                    screenState = screenState,
                    viewModel = viewModel
                )
            }
        )

    }
}

fun getTopBar(
    screenState: Screen,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
): @Composable (() -> Unit) {
    return { TopAppBar(scaffoldState = scaffoldState, coroutineScope = coroutineScope) }
}

@Composable
fun TopAppBar(scaffoldState: ScaffoldState, coroutineScope: CoroutineScope) {

    val context = LocalContext.current
    val colors = MaterialTheme.colors

    TopAppBar(
        title = {
            Text(
                text = stringResource(LowesRouter.currentScreen.value.titleResId),
                color = colors.primaryVariant
            )
        },
        backgroundColor = colors.surface,
        navigationIcon = {
            IconButton( onClick = {
            }

            )
        }
    )
}