package com.example.bvgnativ.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bvgnativ.data.model.Stop
import com.example.bvgnativ.viewmodel.MainViewModel

@Composable
fun StopSearchScreen(
    mainViewModel: MainViewModel = viewModel(),
    onStopClick: (Stop) -> Unit
) {
    var query by remember { mutableStateOf("") }
    val stops by mainViewModel.stops.collectAsState()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp) // optional extra padding
        ) {
            TextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search Stop") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { mainViewModel.searchStops(query) }) {
                Text("Search")
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(stops) { stop ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { onStopClick(stop) }
                    ) {
                        Text(text = stop.name ?: "Unknown Stop", style = MaterialTheme.typography.titleMedium)
                        stop.location?.let { loc ->
                            Text(text = "Lat: ${loc.latitude}, Lng: ${loc.longitude}", style = MaterialTheme.typography.bodySmall)
                        }
                        Text(text = "Type: ${stop.type ?: "N/A"}", style = MaterialTheme.typography.bodySmall)
                    }
                    Divider()
                }
            }
        }
    }
}
