package tests.pet;

import apiMethods.PetsRequests;
import com.codeborne.selenide.testng.annotations.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

@Report
public class TestGetPetByName {

    @Test
    public void testGetAllLionsPets(){
        Assert.assertTrue(PetsRequests.getPetByName("available", "Lion").size()>0, "Response contains Lions pets");
        Assert.assertFalse(PetsRequests.getPetByName("pending", "Lion").size()>0, "Response don't contains Lions pets");
        Assert.assertFalse(PetsRequests.getPetByName("sold", "Lion").size()>0, "Response don't contains Lions pets");
    }
}
