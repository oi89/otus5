package ru.otus.otus_5.steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.otus_5.pages.AboutCompanyPage;

public class AboutCompanyPageStepDefs {
    @Autowired
    AboutCompanyPage aboutCompanyPage;

    @Then("На странице 'О компании' есть заголовок {string}")
    public void checkCoursePageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, aboutCompanyPage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedTitle));
    }

    @Then("На странице 'О компании' есть кнопка {string}")
    public void checkCoursePageButton(String expectedButtonName) {
        Assertions.assertEquals(expectedButtonName, aboutCompanyPage.getButtonText(),
                String.format("На странице 'О компании' должна быть кнопка %s", expectedButtonName));
    }
}
