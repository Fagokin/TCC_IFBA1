package com.example.larpet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@Composable
fun CalendarScreen(navController: NavController) {
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

        // Grid do calendário
        val firstDayOfMonth = currentDate.atDay(1)
        val daysInMonth = currentDate.lengthOfMonth()
        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Espaços vazios antes do primeiro dia
            items(firstDayOfWeek) {
                Box(modifier = Modifier.aspectRatio(1f))
            }

            // Dias do mês
            items(daysInMonth) { day ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val isToday = LocalDate.now().let { 
                        it.dayOfMonth == day + 1 && 
                        it.month == currentDate.month && 
                        it.year == currentDate.year 
                    }
                    
                    Surface(
                        modifier = Modifier.size(36.dp),
                        shape = CircleShape,
                        color = if (isToday) MaterialTheme.colorScheme.primary else Color.Transparent
                    ) {
                        Text(
                            text = "${day + 1}",
                            modifier = Modifier.padding(8.dp),
                            color = if (isToday) Color.White else MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
} 