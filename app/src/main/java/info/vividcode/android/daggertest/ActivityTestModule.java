package info.vividcode.android.daggertest;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityTestModule {

    @Provides
    @Named("ddd-test")
    String provideTestString() {
        return "ええやんええやん";
    }

}
