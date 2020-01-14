package com.alphacoder.view

/**
 * ThemeProvider is using interface so that it could be different for each module.
 */
interface ThemeProvider {
    val theme: Int
}