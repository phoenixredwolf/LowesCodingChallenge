package com.example.lowescodingchallenge.ui.view

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.*
import com.example.lowescodingchallenge.ui.viewmodel.MainViewModel
import com.example.lowescodingchallenge.ui.viewmodel.MainViewModel_Factory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

}