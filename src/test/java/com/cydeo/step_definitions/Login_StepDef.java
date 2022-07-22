package com.cydeo.step_definitions;

import com.cydeo.pages.CrmPage;
import com.cydeo.utilties.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Login_StepDef {
    CrmPage crmPage = new CrmPage();
    BrowserUtils browserUtils = new BrowserUtils();

    @Given("user if on the Crm login page and user enters {string} and {string}")
    public void userIfOnTheCrmLoginPageAndUserEntersAnd(String username, String password) throws InterruptedException {
        BrowserUtils.login(username, password);
    }

    @Then("user should see CRM page")
    public void userShouldSeeCRMPage() {
        BrowserUtils.waitFor(10);
        Assert.assertEquals("CRM", crmPage.header.getText());
        Assert.assertTrue(BrowserUtils.verifyTitle("(54) Portal"));

        browserUtils.logout();
    }
}
