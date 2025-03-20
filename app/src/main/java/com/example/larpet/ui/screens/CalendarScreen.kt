package com.example.larpet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen() {
    var currentDate by remember { mutableStateOf(YearMonth.now()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header com logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "larpet",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        // Navegação do mês
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { 
                currentDate = currentDate.minusMonths(1)
            }) {
                Icon(Icons.Default.KeyboardArrowLeft, "Mês anterior")
            }
            
            Text(
                text = "${currentDate.month.getDisplayName(TextStyle.FULL, Locale("pt", "BR"))} ${currentDate.year}",
                style = MaterialTheme.typography.titleLarge
            )
            
            IconButton(onClick = { 
                currentDate = currentDate.plusMonths(1)
            }) {
                Icon(Icons.Default.KeyboardArrowRight, "Próximo mês")
            }
        }

        // Dias da semana
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb").forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (day == "Dom") Color.Red else MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Grid do calendário
        val firstDayOfMonth = currentDate.atDay(1)
        val daysInMonth = currentDate.lengthOfMonth()
        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Espaços vazios antes do primeiro dia
            items(firstDayOfWeek) {
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(2.dp)
                )
            }

            // Dias do mês
            items(daysInMonth) { day ->
                val isToday = LocalDate.now().let { 
                    it.dayOfMonth == day + 1 && 
                    it.month == currentDate.month && 
                    it.year == currentDate.year 
                }
                
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        modifier = Modifier.size(36.dp),
                        shape = MaterialTheme.shapes.small,
                        color = if (isToday) MaterialTheme.colorScheme.primary else Color.Transparent
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${day + 1}",
                                color = if (isToday) Color.White else MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
} 