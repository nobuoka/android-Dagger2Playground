package info.vividcode.android.daggertest;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {TestModule.class})
@Singleton
public interface TestComponent {

    void inject(MainActivity activity);

    MainActivity.Component activityComponent(MainActivity activity);

}
