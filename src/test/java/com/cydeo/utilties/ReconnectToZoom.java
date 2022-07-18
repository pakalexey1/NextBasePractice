package com.cydeo.utilties;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;

public class ReconnectToZoom {

    @Test
    public void ReconnectToZoom() throws InterruptedException, AWTException {
        Driver.getDriver().get("https://cybertekschool.zoom.us/j/9728392380#success");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement launchButton = Driver.getDriver().findElement(By.cssSelector("div[class='mbTuDeF1']"));
        wait.until(ExpectedConditions.elementToBeClickable(launchButton));
        launchButton.click();

        Robot robot = new Robot();
        robot.mouseMove(1100,230);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        Driver.getDriver().quit();

    }
}
