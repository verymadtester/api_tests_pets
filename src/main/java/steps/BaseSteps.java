package steps;

import basic.DriverConfig;
import basic.Logger;
import com.codeborne.selenide.Selenide;

import static basic.Service.SITE_URL;

public class BaseSteps {

    public static void openSite() {
        Logger.info("Opening browser");
        DriverConfig.setUp();
        Selenide.open(SITE_URL);
    }

    public static String getUrlOfNewTab(){
        Logger.info("Getting URL from new tab");
        return Selenide.switchTo().window(1).getCurrentUrl();
    }
}
