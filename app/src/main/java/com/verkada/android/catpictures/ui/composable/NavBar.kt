package com.verkada.android.catpictures.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavBar(
    navController: NavController,
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") },
            selected = navBackStackEntry?.destination?.route == "Home",
            onClick = { navController.navigate("Home") }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorites"
                )
            },
            label = { Text("Favorites") },
            selected = navBackStackEntry?.destination?.route == "Favorites",
            onClick = { navController.navigate("Favorites") }
        )

    }
}
