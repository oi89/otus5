package ru.otus.otus_5.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MainPage {
    @Autowired
    private WebDriver driver;

    @Autowired
    private BasePage basePage;

    private Logger logger;
    private Actions actions;

    private final String BASE_URL = "https://otus.ru/";

    private  String coursesMenuLocator = "//div[contains(@class, 'header2-menu_main')]//p[contains(text(), '%s')]";
    private WebElement coursesMenu;

    private String firstLevelMenuLocator = "//div[contains(@class, 'header2-menu_main')]//a[@title='%s']";
    private WebElement firstLevelMenu;

    private String firstLevelMenuTriggerLocator = "//div[contains(@class, 'header2-menu_main')]//a[@title='%s']//div[contains(@class, 'js-menu-subdropdown-trigger')]";
    private WebElement firstLevelMenuTrigger;

    private String secondLevelMenuLocator = "//div[contains(@class, 'header2-menu__subdropdown')]//a[@title='%s']";
    private WebElement secondLevelMenu;

    private String cookiesAcceptButtonLocator = "div.cookies__margin-block button";
    private WebElement cookiesAcceptButton;

    @PostConstruct
    public void init() {
        logger = LogManager.getLogger(MainPage.class);
        actions = new Actions(driver);
    }

    public MainPage open() {
        driver.get(BASE_URL);
        logger.info("Открыта главная страница otus.ru");

        tryToCloseCookiePanel();

        return this;
    }

    public MainPage clickMainMenuByName(String menuName) {
        coursesMenu = basePage.getWebElementByName(coursesMenuLocator, menuName);
        coursesMenu.click();
        logger.info(String.format("Клик в меню '%s'", menuName));

        return this;
    }

    public MainPage clickFirstLevelMenuByName(String subMenuName) {
        firstLevelMenu = basePage.getWebElementByName(firstLevelMenuLocator, subMenuName);

        firstLevelMenu.click();
        logger.info(String.format("Клик на подпункт '%s'", subMenuName));

        return this;
    }

    public MainPage openSecondLevelMenuByName(String subMenuName) {
        firstLevelMenuTrigger = basePage.getWebElementByName(firstLevelMenuTriggerLocator, subMenuName);

        actions.moveToElement(firstLevelMenuTrigger).build().perform();
        logger.info(String.format("Курсор наведен на пункт '%s'", subMenuName));

        return this;
    }

    public MainPage clickSecondLevelMenuByName(String subMenuName) {
        secondLevelMenu = basePage.getWebElementByName(secondLevelMenuLocator, subMenuName);

        secondLevelMenu.click();
        logger.info(String.format("Клик на подпункт '%s'", subMenuName));

        return this;
    }

    void tryToCloseCookiePanel() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cookiesAcceptButtonLocator)));
            cookiesAcceptButton = driver.findElement(By.cssSelector(cookiesAcceptButtonLocator));
            cookiesAcceptButton.click();
            logger.info("Нажата кнопка OK с подтверждением куки");
        } catch (Exception ex) {
            logger.info("Окно с согласием на обработку куки не было показано");
        }
    }
}
