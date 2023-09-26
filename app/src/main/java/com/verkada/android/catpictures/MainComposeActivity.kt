package com.verkada.android.catpictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.verkada.android.catpictures.theme.CatPicturesTheme
import com.verkada.android.catpictures.ui.composable.FavoritesScreen
import com.verkada.android.catpictures.ui.composable.HomeScreen
import com.verkada.android.catpictures.ui.composable.NavBar
import com.verkada.android.catpictures.ui.viewmodel.FavoritesViewModel
import com.verkada.android.catpictures.ui.viewmodel.HomeViewModel

class MainComposeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Draw behind system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()

            CatPicturesTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Picture App") }) },
                    content = { innerPadding ->
                        val homeViewModel: HomeViewModel = viewModel()
                        val favoritesViewModel: FavoritesViewModel = viewModel()

                        NavHost(
                            navController,
                            startDestination = "Home",
                            Modifier.padding(innerPadding)
                        ) {
                            composable("Home") { HomeScreen(homeViewModel) }
                            composable("Favorites") { FavoritesScreen(favoritesViewModel) }
                        }
                    },
                    bottomBar = {
                        NavBar(navController = navController)
                    },
                )
            }
        }
    }
}
