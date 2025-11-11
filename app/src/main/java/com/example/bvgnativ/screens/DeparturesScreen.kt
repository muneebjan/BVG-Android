package com.example.bvgnativ.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bvgnativ.data.model.Departure
import com.example.bvgnativ.utils.getMinutesUntil

@Composable
fun DeparturesScreen(
    departures: List<Departure>,
    onBackClick: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Button(onClick = onBackClick) {
                Text("Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (departures.isEmpty()) {
                Text("No departures available", style = MaterialTheme.typography.bodyMedium)
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(departures) { dep ->
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(
                                text = "Line: ${dep.line?.name ?: dep.line?.id ?: "Unknown"}",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "Direction: ${dep.direction ?: "N/A"}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            val minutes = getMinutesUntil(dep.plannedWhen)
                            Text(
                                text = if (minutes != null && minutes >= 0) "$minutes min" else "Now",
                                style = MaterialTheme.typography.bodySmall
                            )
                            dep.delay?.let { delay ->
                                if (delay > 0) {
                                    Text(
                                        text = "Delay: ${delay / 60} min",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                }
                            }
                        }
                        HorizontalDivider(
                            Modifier,
                            DividerDefaults.Thickness,
                            DividerDefaults.color
                        )
                    }
                }
            }
        }
    }
}

