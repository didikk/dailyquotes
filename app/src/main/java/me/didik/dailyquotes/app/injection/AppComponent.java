package me.didik.dailyquotes.app.injection;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import me.didik.dailyquotes.app.MyApp;

/**
 * Created by didik on 05/10/17.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, BuildersModule.class,
        NetModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApp application);

        AppComponent build();
    }

    void inject(MyApp app);

}
