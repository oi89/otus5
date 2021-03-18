package ru.otus.otus_5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CompanyLegalInfoPage {
    @Autowired
    private WebDriver driver;

    @FindBy(css = "div.title-new__text h1")
    private WebElement title;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        return title.getText();
    }
}
