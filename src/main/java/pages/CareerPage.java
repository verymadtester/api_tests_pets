package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CareerPage {

    public SelenideElement seeAllBtn(String title){
        return $x("//*[contains(@class, 'btn') and contains(text(), '"+title+"')]");
    }

    public SelenideElement blocksTitle(String title){
        return $x("//h3[contains(text(), '"+title+"')]");
    }

}
