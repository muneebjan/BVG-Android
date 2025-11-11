package com.example.bvgnativ

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bvgnativ.screens.AppNavGraph
import com.example.bvgnativ.ui.theme.BVGNativTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BVGNativTheme {
                AppNavGraph()
            }
        }
    }
}
