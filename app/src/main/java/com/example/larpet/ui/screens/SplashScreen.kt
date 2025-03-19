package com.example.larpet.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.larpet.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var startMainActivity by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(2000)
        startMainActivity = true
    }

    if (startMainActivity) {
        LoginScreen(navController)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_larpet),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(200.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
} 