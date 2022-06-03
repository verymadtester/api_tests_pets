package pages;

import com.codeborne.selenide.SelenideElement;


import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public final SelenideElement siteLogo = $x("//*[contains(@class, 'navbar-brand')]");
    public final SelenideElement acceptAllCookiesBtn = $x("//*[contains(@id, 'accept-all-btn')]");

    public SelenideElement menuItem(String title){
        return $x("//*[contains(@class, 'menu-item')]//*[contains(text(), '"+title+"')]");
    }

    public SelenideElement menuOption(String title){
        return $x("//*[contains(@class, 'dropdown-menu')]//*[contains(text(), '"+title+"')]");
    }

}
