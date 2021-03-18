package ru.otus.otus_5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.otus_5.pages.MainPage;

public class MainPageStepDefs {
    @Autowired
    MainPage mainPage;

    @Given("Открыть главную страницу otus")
    public void openMainPage() {
        mainPage.open();
    }

    @When("Нажать на пункт главного меню {string}")
    public void clickCoursesMenu(String menuName) {
        mainPage.clickMainMenuByName(menuName);
    }

    @When("Навести курсор на пункт {string} первого уровня")
    public void openSecondLevelMenu(String menuName) {
        mainPage.openSecondLevelMenuByName(menuName);
    }

    @When("Нажать на пункт меню {string} первого уровня")
    public void clickFirstLevelMenu(String menuName) {
        mainPage.clickFirstLevelMenuByName(menuName);
    }

    @When("Нажать на пункт меню {string} второго уровня")
    public void clickSecondLevelMenu(String menuName) {
        mainPage.clickSecondLevelMenuByName(menuName);
    }
}
