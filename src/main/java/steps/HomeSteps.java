package steps;

import basic.Logger;
import pages.HomePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class HomeSteps {

    HomePage homePage = new HomePage();

    public boolean isHomePageOpened(){
        Logger.info("Checking that Home page is opened");
        return homePage.siteLogo.shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void selectFromMenu(String title, String menuOption){
        Logger.info("Selecting " + menuOption + " from " + title + " menu");
        homePage.menuItem(title).shouldBe(visible).click();
        homePage.menuOption(menuOption).shouldBe(visible).click();
    }

    public void acceptAllCookies(){
        Logger.info("Accepting all cookies");
        homePage.acceptAllCookiesBtn.shouldBe(visible).click();
    }
}
