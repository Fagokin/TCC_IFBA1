package com.example.larpet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
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

        // Perfil do usuário
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Foto de perfil",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Maria de Jesus",
                style = MaterialTheme.typography.titleLarge
            )
        }

        // Opções do perfil
        ListItem(
            headlineContent = { Text("Editar perfil") },
            modifier = Modifier.clickable { /* Implementar ação */ }
        )
        
        ListItem(
            headlineContent = { Text("Segurança e uso de dados") },
            modifier = Modifier.clickable { /* Implementar ação */ }
        )
        
        ListItem(
            headlineContent = { Text("Política de privacidade") },
            modifier = Modifier.clickable { /* Implementar ação */ }
        )
        
        ListItem(
            headlineContent = { Text("Ajuda/FAQ") },
            modifier = Modifier.clickable { /* Implementar ação */ }
        )
    }
} 