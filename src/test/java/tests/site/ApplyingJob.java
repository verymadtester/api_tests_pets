package tests.site;

import basic.TestFrame;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.annotations.Report;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CareerPage;
import pages.OpenPositionsPage;
import steps.BaseSteps;
import steps.CareerSteps;
import steps.HomeSteps;
import steps.OpenPositionsSteps;

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({ ScreenShooter.class})
@Report
public class ApplyingJob extends TestFrame {

    @Test(description = "Apply to QA")
    public void testApplyToQA(){
        logger = extent.startTest("Apply to QA");
        BaseSteps.openSite();
        HomeSteps homeSteps = new HomeSteps();
        assertTrue(homeSteps.isHomePageOpened(), "Home page doesn't open");
        homeSteps.acceptAllCookies();

        homeSteps.selectFromMenu("More", "Careers");
        CareerSteps careerSteps = new CareerSteps();
        assertTrue(careerSteps.isBlockPresent("Find your calling"), "Careers page doesn't open");
        assertTrue(careerSteps.isBlockPresent("Our Locations"), "Careers page doesn't open");

        CareerPage careerPage = new CareerPage();
        careerPage.seeAllBtn("See all teams").click();
        assertTrue(careerSteps.isBlockPresent("Quality Assurance"), "Quality Assurance block doesn't open");
        careerSteps.clickOnBlockTitle("Quality Assurance");

//        careerPage.seeAllBtn("See all QA jobs").click();
        OpenPositionsSteps openPositionsSteps = new OpenPositionsSteps();
        openPositionsSteps.selectFromDropdown("Location", "Istanbul, Turkey");
        openPositionsSteps.selectFromDropdown("Department", "Quality Assurance");
        sleep(500); //need for rendering
        OpenPositionsPage openPositionsPage = new OpenPositionsPage();
        assertTrue(openPositionsPage.positionTitle("Quality Assurance").size() > 0);
        assertTrue(openPositionsPage.positionTitle("QA").size() > 0);
        assertEquals(openPositionsPage.positionTitle("Quality Assurance").size()
                + openPositionsPage.positionTitle("QA").size(), openPositionsPage.positionsByDepartment("Quality Assurance").size());
        assertEquals(openPositionsPage.positionTitle("Quality Assurance").size()
                + openPositionsPage.positionTitle("QA").size(), openPositionsPage.positionsByLocation("Istanbul, Turkey").size());
        assertEquals(openPositionsPage.positionTitle("Quality Assurance").size()
                + openPositionsPage.positionTitle("QA").size(), openPositionsPage.applyNowButtons().size());

        openPositionsPage.applyNowButtons().first().click();
        sleep(500); //need for rendering
        assertTrue(BaseSteps.getUrlOfNewTab().contains("jobs.lever.co"), "Wrong page opened");

        logger.log(LogStatus.PASS, "Test Apply to QA Passed");
    }
}
