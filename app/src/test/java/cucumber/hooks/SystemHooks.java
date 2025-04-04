package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SystemHooks {
    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }
}
