package com.example.larpet.ui.screens

import androidx.compose.foundation.clickable
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
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
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Implementar ação */ }
                .padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Text(
                text = "Editar perfil",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
        
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Implementar ação */ }
                .padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Text(
                text = "Segurança e uso de dados",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
        
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Implementar ação */ }
                .padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Text(
                text = "Política de privacidade",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
        
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Implementar ação */ }
                .padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Text(
                text = "Ajuda/FAQ",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
} 