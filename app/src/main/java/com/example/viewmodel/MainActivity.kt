package com.example.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    private val counterViewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp(counterViewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(viewModel: CounterViewModel) {
    val count by viewModel.count.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Nama: Naufal Aldrin Danita",
            fontSize = 24.sp,
        )
        Text(
            text = "NIM: 2451504000111026",
            fontSize = 18.sp,
        )

        Button(
            onClick = { viewModel.increment() },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(bottom = 16.dp)
        ) {
            Text("Up", fontSize = 18.sp)
        }
        Text(
            text = "$count",
            fontSize = 80.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Button(
            onClick = { viewModel.decrement() },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(bottom = 16.dp)
        ) {
            Text("Down", fontSize = 18.sp)
        }

        Button(
            onClick = { viewModel.reset() },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("Reset", fontSize = 18.sp)
        }
    }
}