package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OpenPositionsPage {

    public final SelenideElement filterBtn = $x("//*[contains(@class, 'btn') and contains(text(), 'Filter')]");
    public final SelenideElement filterByLocationDropdown = $x("//*[contains(@class, 'selection') and contains(@id, 'filter-by-location')]");
    public final SelenideElement filterByDepartmentDropdown = $x("//*[contains(@class, 'selection') and contains(@id, 'filter-by-department')]");

    public SelenideElement dropdownOption(String title){
        return $x("//*[contains(@class, 'option') and contains(text(), '"+title+"')]");
    }

    public ElementsCollection positionTitle(String title){
        return $$x("//*[contains(@class, 'position-title') and contains(text(), '"+title+"')]");
    }

    public ElementsCollection positionsByDepartment(String title){
        return $$x("//*[contains(@class, 'position-department') and contains(text(), '"+title+"')]");
    }

    public ElementsCollection positionsByLocation(String title){
        return $$x("//*[contains(@class, 'position-location') and contains(text(), '"+title+"')]");
    }

    public ElementsCollection applyNowButtons(){
        return $$x("//*[contains(@class, 'btn') and contains(text(), 'Apply Now')]");
    }

}
