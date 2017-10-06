package me.didik.dailyquotes.app.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import me.didik.dailyquotes.app.MyApp;

/**
 * Created by didik on 05/10/17.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(MyApp application) {
        return application.getApplicationContext();
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
