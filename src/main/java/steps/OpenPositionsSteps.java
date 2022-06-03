package steps;

import basic.Logger;
import pages.OpenPositionsPage;

import static com.codeborne.selenide.Condition.visible;

public class OpenPositionsSteps {

    OpenPositionsPage openPositionsPage = new OpenPositionsPage();

    public void openFiler(){
        Logger.info("Opening filter block");
        openPositionsPage.filterBtn.shouldBe(visible).click();
    }

    public void selectFromDropdown(String dropdownName, String option){
        switch (dropdownName) {
            case "Location":
                Logger.info("Selecting " + option + " from Location dropdown");
                openPositionsPage.filterByLocationDropdown.shouldBe(visible).click();
                openPositionsPage.dropdownOption(option).shouldBe(visible).click();
                break;
            case "Department":
                Logger.info("Selecting " + option + " from Department dropdown");
                openPositionsPage.filterByDepartmentDropdown.shouldBe(visible).click();
                openPositionsPage.dropdownOption(option).shouldBe(visible).click();
                break;
        }
    }
}
