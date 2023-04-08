package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseDriverSetup;

public class Hooks {
    private static String browserName = System.getProperty("browser", "chrome");
    @Before
    public void lunchBrowser(){
        BaseDriverSetup.setBrowser(browserName);
    }

    @After
    public void quitBrowser(Scenario scenario){
        BaseDriverSetup.quitBrowser(scenario);
    }
}
