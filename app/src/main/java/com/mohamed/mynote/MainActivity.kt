package com.mohamed.mynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mohamed.mynote.feature_note.presentation.SharedViewModel
import com.mohamed.mynote.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.mohamed.mynote.feature_note.presentation.view_notes.NotesScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
//                val navController = rememberNavController()
//                NavHost(
//                    navController = navController,
//                    startDestination = Screen.NotesScreen.route
//                ) {
//                    composable(
//                        route = Screen.NotesScreen.route
//                    ) {
//                        NotesScreen(navController = navController)
//                    }
//                    composable(
//                        route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
//                        arguments = listOf(
//                            navArgument(
//                                name = "noteId"
//                            ) {
//                                type = NavType.Companion.IntType
//                                defaultValue = -1
//                            },
//                            navArgument(
//                                name = "noteColor"
//                            ) {
//                                type = NavType.Companion.IntType
//                                defaultValue = -1
//                            }
//                        )
//                    ) {
//                        val color = it.arguments?.getInt("noteColor") ?: -1
//                        AddEditNoteScreen(
//                            navController = navController,
//                            noteColor = color
//                        )
//                    }
//                }

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.ViewNotesScreen
                ){
                    composable <Route.ViewNotesScreen>{
                        NotesScreen(
                            goToAddEditNoteScreen = {
                                navController.navigate(Route.AddEditNoteScreen)
                            },
                            sharedViewModel = SharedViewModel()
                        )
                    }

                    composable<Route.AddEditNoteScreen>{
                        AddEditNoteScreen(
                            goToNoteScreen = {
                                navController.navigateUp()
                            },
                            noteColor = 0,
                            sharedViewModel = SharedViewModel()
                        )
                    }

                }
            }

        }
    }
}

private sealed interface Route{
    @Serializable
    data object ViewNotesScreen : Route

    @Serializable
    data object AddEditNoteScreen : Route
}