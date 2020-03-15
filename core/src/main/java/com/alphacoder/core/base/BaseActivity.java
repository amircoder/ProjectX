package com.alphacoder.core.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alphacoder.view.ThemeProvider;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    public ThemeProvider themeProvider;
    @Inject
    public DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        applyTheme();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // TODO: Some global operation here
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // TODO: Some global operation here
    }

    @Override
    protected void onStop() {
        super.onStop();
        // TODO: Some global operation here
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO: Some global operation here
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void navigate(int layout, Fragment fragment, String tag){
        getSupportFragmentManager().beginTransaction().add(layout, fragment, tag).commit();
    }

    private void applyTheme() {
        if (themeProvider != null ){
            setTheme(themeProvider.getTheme());
        }
    }
}
