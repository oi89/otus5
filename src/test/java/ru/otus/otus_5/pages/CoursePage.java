package ru.otus.otus_5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CoursePage {
    @Autowired
    private WebDriver driver;

    @FindBy(css = ".course-header2__title")
    private WebElement title;

    @FindBy(css = "div.course-header2__new .course-header2__button__text")
    private WebElement signUpButton;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        return title.getText();
    }

    public String getButtonText() {
        return signUpButton.getText();
    }
}
