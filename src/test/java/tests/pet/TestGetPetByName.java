package tests.pet;

import basic.Logger;
import basic.TestFrame;
import com.codeborne.selenide.testng.annotations.Report;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static apiMethods.PetsRequests.getPetByName;

@Report
public class TestGetPetByName extends TestFrame {

    @Test(description = "Get all Lions")
    public void testGetAllLionsPets(){
        logger = extent.startTest("Get all Lions");
        Logger.info(getPetByName("available", "Lion"));
        Assert.assertTrue(getPetByName("available", "Lion").size()>0, "Response contains Lions pets");
        Assert.assertFalse(getPetByName("pending", "Lion").size()>0, "Response don't contains Lions pets");
        Assert.assertFalse(getPetByName("sold", "Lion").size()>0, "Response don't contains Lions pets");
        logger.log(LogStatus.PASS, "Test Get all Lions Passed");
    }

}
