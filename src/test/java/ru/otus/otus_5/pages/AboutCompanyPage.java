package ru.otus.otus_5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AboutCompanyPage {
    @Autowired
    private WebDriver driver;

    @FindBy(css = "div[class*='styles__Background'] div[class*='styles__Title']")
    private WebElement title;

    @FindBy(css = "div[class*='styles__Background'] a[href='/lessons'] button")
    private WebElement chooseCourseButton;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        return title.getText().replaceAll("\n", " ");
    }

    public String getButtonText() {
        return chooseCourseButton.getText();
    }
}
