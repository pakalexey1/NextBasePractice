package com.cydeo.utilties;

import com.cydeo.pages.CrmPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.step_definitions.Login_StepDef;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils extends CrmPage {
    private WebDriverWait wait;
    public static void login(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Assert.assertTrue(verifyTitle("Authorization"));

        loginPage.username.sendKeys(ConfigurationReader.getProperty(username));
        loginPage.password.sendKeys(ConfigurationReader.getProperty(password));
        loginPage.logInBtn.click();
    }

    public static boolean verifyTitle(String expectedTitle) {
        return expectedTitle.equals(Driver.getDriver().getTitle());
    }

    protected WebDriverWait getWait10() {
        if (wait == null) {
            wait = new WebDriverWait(Driver.getDriver(), 10);
        }
        return wait;
    }
    public void logout() {

        getWait10().until(ExpectedConditions.visibilityOf(logout_dropdown));
        getWait10().until(ExpectedConditions.elementToBeClickable(logout_dropdown));
        logout_dropdown.click();

        getWait10().until(ExpectedConditions.visibilityOf(logout_button));
        logout_button.click();
    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    /**
     * Verifies whether the element matching the provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);

        }
    }

    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * @param by
     * @throws AssertionError the element matching the provided locator is displayed
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();

        }
    }

}
