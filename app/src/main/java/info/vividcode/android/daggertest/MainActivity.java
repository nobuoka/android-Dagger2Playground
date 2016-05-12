package info.vividcode.android.daggertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

@Module
public class MainActivity extends AppCompatActivity {

    @ActivityScoped
    @Subcomponent(modules = {MainActivity.class, ActivityTestModule.class})
    public interface Component {
        MainActivity mainActivity();
        @Named("ddd-test")
        String activityString();
    }

    @Provides
    @ActivityScoped
    public MainActivity provideActivity() {
        return this;
    }

    @Provides
    @ActivityScoped
    @Named("activity")
    public String provideActivityString(@Named("test") String testString) {
        Log.d("xxx", "test string : " + testString);
        return testString + " on Activity";
    }

    @Inject
    TestFactory<String> mTestFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestComponent component = DaggerTestComponent.create();
        Component c = component.activityComponent(this);
        if (c.mainActivity() == this) {
            Log.d("xxx", "一緒");
        } else {
            Log.d("xxx", "別物");
        }
        Log.d("xxx", "activityString ; " + c.activityString());
        component.inject(this);

        Log.d("xxx", mTestFactory.create());
    }

}
