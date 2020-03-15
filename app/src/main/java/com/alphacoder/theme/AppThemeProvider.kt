package com.alphacoder.theme

import com.alphacoder.ui.R
import com.alphacoder.view.ThemeProvider


class AppThemeProvider: ThemeProvider {
    override val theme: Int
        get() = R.style.GlobalTheme
}