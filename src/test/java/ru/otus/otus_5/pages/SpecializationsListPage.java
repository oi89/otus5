package ru.otus.otus_5.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpecializationsListPage {
    @Autowired
    BasePage basePage;

    private Logger logger;

    private String specializationBlockTitleLocator = "//a[@href='%s']//div[contains(@class, 'lessons__new-item-title')]";
    private WebElement specializationBlockTitle;

    private String specializationBlockLocator = "//a[@href='%s']";
    private WebElement specializationBlock;

    @PostConstruct
    public void init() {
        logger = LogManager.getLogger(SpecializationsListPage.class);
    }

    public String getSpecializationBlockTitle(String blockHrefValue) {
        specializationBlockTitle = basePage.getWebElementByName(specializationBlockTitleLocator, blockHrefValue);

        return specializationBlockTitle.getText();
    }

    public SpecializationsListPage clickSpecializationBlock(String blockHrefValue) {
        specializationBlock = basePage.getWebElementByName(specializationBlockLocator, blockHrefValue);
        specializationBlock.click();
        logger.info(String.format("Клик на блоке специализации '%s'", blockHrefValue));

        return this;
    }
}
