package com.alphacoder.config

import com.alphacoder.core.AppConfig
import com.alphacoder.ui.BuildConfig

class GlobalAppConfig: AppConfig {
    override val location = BuildConfig.LOCATION
}