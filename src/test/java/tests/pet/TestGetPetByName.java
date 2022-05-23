package tests.pet;

import basic.Logger;
import com.codeborne.selenide.testng.annotations.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

import static apiMethods.PetsRequests.getPetByName;

@Report
public class TestGetPetByName {

    @Test(description = "Get all Lions")
    public void testGetAllLionsPets(){
        Logger.info(getPetByName("available", "Lion"));
        Assert.assertTrue(getPetByName("available", "Lion").size()>0, "Response contains Lions pets");
        Assert.assertFalse(getPetByName("pending", "Lion").size()>0, "Response don't contains Lions pets");
        Assert.assertFalse(getPetByName("sold", "Lion").size()>0, "Response don't contains Lions pets");
    }
}
