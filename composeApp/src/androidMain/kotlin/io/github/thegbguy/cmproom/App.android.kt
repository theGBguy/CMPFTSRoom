package io.github.thegbguy.cmproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.github.thegbguy.cmproom.data.AndroidDatabaseBuilder
import io.github.thegbguy.cmproom.data.AppInitializer

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        AppInitializer.init(AndroidDatabaseBuilder(applicationContext))

        setContent { App() }
    }
}
