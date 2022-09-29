package com.magdy.notescleanarch.feature_notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import  androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.magdy.notescleanarch.feature_notes.presentation.add_edit_note.components.AddEditNoteScreen
import com.magdy.notescleanarch.feature_notes.presentation.notes.components.NotesScreen
import com.magdy.notescleanarch.feature_notes.presentation.utils.NoteScreens
import com.magdy.notescleanarch.ui.theme.NotesCleanArchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesCleanArchTheme {
                Surface(color = MaterialTheme.colors.primary) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NoteScreens.NotesScreen.route
                    ) {
                        composable(route = NoteScreens.NotesScreen.route) {
                            NotesScreen(navController = navController)
                        }

                        composable(
                            route = NoteScreens.AddEditNoteScreen.route
                                    + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },


                                )
                        )


                        {

                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }
                    }

                }
            }
        }
    }
}