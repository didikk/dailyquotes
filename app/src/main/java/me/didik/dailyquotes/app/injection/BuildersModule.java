package me.didik.dailyquotes.app.injection;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.didik.dailyquotes.feature.main.MainActivity;

/**
 * Created by didik on 05/10/17.
 */
@Module
public abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
