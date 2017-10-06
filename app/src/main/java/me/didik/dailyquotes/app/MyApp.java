package me.didik.dailyquotes.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import me.didik.dailyquotes.app.injection.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by didik on 05/10/17.
 */

public class MyApp extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> androidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        Timber.plant(new Timber.DebugTree());
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }

    public boolean hasNetwork() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
