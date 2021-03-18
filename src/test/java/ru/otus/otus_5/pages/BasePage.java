package ru.otus.otus_5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasePage {
    @Autowired
    private WebDriver driver;

    public WebElement getWebElementByName(String locator, String elementName) {
        String updatedLocator = String.format(locator, elementName);
        WebElement element = driver.findElement(By.xpath(updatedLocator));
        return element;
    }
}
