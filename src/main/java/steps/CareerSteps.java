package steps;

import basic.Logger;
import pages.CareerPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class CareerSteps {

    CareerPage careerPage = new CareerPage();

    public boolean isBlockPresent(String title){
        Logger.info("Checking presents of " + title + " block");
        return careerPage.blocksTitle(title).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void clickOnBlockTitle(String title){
        Logger.info("Opening "+ title +" block");
        careerPage.blocksTitle(title).click();
    }
}
