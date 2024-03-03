package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import androidx.navigation.testing.TestNavHostController
import com.example.cupcake.CupcakeApp
import org.junit.Before

private lateinit var navController: TestNavHostController

@get:Rule
val composeTestRule = createAndroidComposeRule<ComponentActivity>()

@Before
fun setupCupcakeNavHost() {
    composeTestRule.setContent {
        navController = TestNavHostController(LocalContext.current).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
        }
        CupcakeApp(navController = navController)
    }
}