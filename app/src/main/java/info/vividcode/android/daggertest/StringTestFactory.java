package info.vividcode.android.daggertest;

import javax.inject.Inject;

public class StringTestFactory implements TestFactory<String> {

    @Inject
    public StringTestFactory() {}

    @Override
    public String create() {
        return "いぇえええええい";
    }

}
