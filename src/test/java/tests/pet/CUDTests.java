package tests.pet;

import apiModels.pets.Pet;
import basic.TestFrame;
import com.codeborne.selenide.testng.annotations.Report;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static apiMethods.PetsRequests.deletePet;
import static apiMethods.PetsRequests.getPetByName;
import static apiMethods.PetsRequests.getPetId;
import static apiMethods.PetsRequests.postPet;
import static apiMethods.PetsRequests.updatePet;

@Report
public class CUDTests extends TestFrame {

    @Test(description = "Create new Pet", priority = 1)
    public void testCreateNewPet(){
        logger = extent.startTest("Create new Pet");
        Pet pet = new Pet("Shpits", "Dog", "pending");
        postPet(pet);
        Assert.assertTrue(getPetByName("pending", "Shpits").size()>0, "Response don't contains Shpits pets");
        logger.log(LogStatus.PASS, "Test Create new Pet Passed");
    }

    @Test(description = "Update Pet", priority = 2)
    public void testUpdateNewPet(){
        logger = extent.startTest("Update Pet");
        Pet pet = new Pet("Shpits", "Dog", "available");
        updatePet(pet);
        Assert.assertTrue(getPetByName("available", "Shpits").size()>0, "Response don't contains Shpits pets");
        logger.log(LogStatus.PASS, "Test Update Pet Passed");
    }

    @Test(description = "Delete Pet", priority = 3)
    public void testDeletePet(){
        logger = extent.startTest("Delete Pet");
        String id = String.valueOf(getPetId("available", "Shpits"));
        deletePet(id);
        Assert.assertFalse(getPetByName("available", "Shpits").size()>0, "Response contains Shpits pets");
        logger.log(LogStatus.PASS, "Test Delete Pet Passed");
    }
}
