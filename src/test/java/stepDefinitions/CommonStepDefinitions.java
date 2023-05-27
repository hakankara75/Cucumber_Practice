package stepDefinitions;

import io.cucumber.java.en.And;
import utilities.ReusableMethods;

public class CommonStepDefinitions {

    @And("{int} saniye bekle")
    public void saniyeBekle(int arg0) {
        ReusableMethods.bekle(arg0);
    }
}
