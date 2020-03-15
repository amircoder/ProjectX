object App {
    object Versions {
        const val compileSdkVersion = 28
        const val buildToolsVersion = "28.0.3"
        const val targetSdkVersion = 28
        const val minSdkVersion = 21
        const val applicationId = "project.x.test"
        const val applicationVersionName = "1.0-showcase"
        const val applicationVersionCode = 1
    }
}

object AutoValue {
    object Versions {
        const val auto_value = "1.7"
    }

    const val autoValue = "com.google.auto.value:auto-value:${Versions.auto_value}"

}

object Kotlin {
    object Versions {
        const val kotlin_version = "1.3.50"
    }
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
}

object Gradle {
    object Version {
        const val gradle_plugin_version = "3.5.1"
    }
}

object Dagger {
    object Versions {
        const val daggerVersion = "2.20"
    }

    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val daggerAndroidSupport =
        "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
}

object Arch {
    object Versions {
        const val archCompomentVersion = "2.0.0"
    }
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.archCompomentVersion}"
    const val coreTest = "androidx.arch.core:core-testing:${Versions.archCompomentVersion}"
}

object Room {
    object Versions {
        const val roomVersion = "2.2.2"
    }
}

object Navigation {
    object Versions{
        const val navigation_version = "1.0.0-rc02"
    }
}

object jUnitVersion {
    object Versions {
        const val powermockVersion = "2.0.0-beta.5"
    }
}

//def jUnitVersion = '4.12'
//def mockitoVersion = '2.13.0'

object PowerMockito {
    object Versions {
        const val powermockVersion = "2.0.0-beta.5"
    }
    const val powermockApiMockito2 = "org.powermock:powermock-api-mockito2:${Versions.powermockVersion}"
    const val powermockJunit4 = "org.powermock:powermock-module-junit4:${Versions.powermockVersion}"
}



//
//def assertjVersion = '3.14.0'
//ext.assertj = [
//'asserjCore' :  "org.assertj:assertj-core:$assertjVersion"
//]
//
//def assertjAndroidVersion = '1.1.1'
//ext.assertjAndroid = [
//'assertjAndroid' : "com.squareup.assertj:assertj-android:$assertjAndroidVersion"
//]
//
//def robolectricVersion = '4.3'
//ext.robolectricVersion = [
//'robolectric': "org.robolectric:robolectric:$robolectricVersion"
//]
//
//def robolectricShadowsVersion = '3.3.2'
//ext.roboelctricShadowVersion = [
//'shadowsPlayServices' : "org.robolectric:shadows-play-services:$robolectricShadowsVersion"
//]
//
//def mockKVersion = '1.8.5'
//ext.mockk = [
//'mockk' : "io.mockk:mockk:$mockKVersion"
//]
//
//def navigational_component = '2.2.0-rc02'
//ext.navigation = [
//'fragment' : "androidx.navigation:navigation-fragment:$navigational_component",
//'ui' : "androidx.navigation:navigation-ui:$navigational_component",
//'fragmentKtx' : "androidx.navigation:navigation-fragment-ktx:$navigational_component",
//'uiKtx' : "androidx.navigation:navigation-ui-ktx:$navigational_component"
//]
//
//def chuck = '1.1.0'
//ext.chuck = [
//'chuck' : "com.readystatesoftware.chuck:library:$chuck",
//'chuckNoOp' : "com.readystatesoftware.chuck:library-no-op:$chuck"
//]
//
//def appComponent = '1.1.0'
//ext.appComponent = [
//'appComponent' : "androidx.appcompat:appcompat:$appComponent"
//]
//
//def rxJava = '2.2.1'
//ext.room = [
//roomRuntime : "androidx.room:room-runtime:$rxJava",
//compiler : "androidx.room:room-compiler:$rxJava",
//rx2 : "androidx.room:room-rxjava2:$rxJava",
//common : "androidx.room:room-common:$rxJava"
//]
//
//def androidX = '1.0.0'
//
//ext.androidx = [
//'recyclerview' : "androidx.recyclerview:recyclerview:$androidX",
//'cardView' : "androidx.cardview:cardview:$androidX"
//]
