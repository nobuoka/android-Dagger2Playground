package info.vividcode.android.daggertest;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    @Provides
    TestFactory<String> provideStringTestFactory(StringTestFactory factory) {
        return factory;
    }

    @Provides
    @Named("test")
    String provideTestString() {
        return "こんにちは、テストだよ！";
    }

}
