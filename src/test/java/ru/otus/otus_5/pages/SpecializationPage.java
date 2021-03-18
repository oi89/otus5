package ru.otus.otus_5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpecializationPage {
    @Autowired
    private WebDriver driver;

    @FindBy(css = "h1.promo-spec-header__title")
    private WebElement title;

    @FindBy(css = "button.promo-spec-header__button")
    private WebElement tellAboutStartButton;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        return title.getText();
    }

    public String getButtonText() {
        return tellAboutStartButton.getText();
    }
}
