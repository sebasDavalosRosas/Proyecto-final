package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.YourInformationPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YourInformationSteps {
    YourInformationPage yourInformationPage = new YourInformationPage(DriverManager.getDriver().driver);

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation) throws InterruptedException {
        List<String> data = checkoutInformation.transpose().asList(String.class);
        // data = ["Mauricio", "Viscarra", "00000"]
        yourInformationPage.setFirstNameTextBox(data.get(0));
        yourInformationPage.setLastNameTextBox(data.get(1));
        yourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on continue button")
    public void clickOnContinueButton() throws InterruptedException {
        yourInformationPage.clickOnContinueButton();
    }

    @And("An error message that says {string} should be displayed")
    public void checkErrorMessage(String error){
        Assertions.assertTrue(yourInformationPage.errorMessageIsDisplayed(error));
    }
}
