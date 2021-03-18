package ru.otus.otus_5.steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.otus_5.pages.SpecializationPage;

public class SpecializationPageStepDefs {
    @Autowired
    SpecializationPage specializationPage;

    @Then("На странице специализации есть заголовок {string}")
    public void checkCoursePageTitle(String expectedSpecName) {
        Assertions.assertEquals(expectedSpecName, specializationPage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedSpecName));
    }

    @Then("На странице специализации есть кнопка {string}")
    public void checkCoursePageButton(String expectedButtonName) {
        Assertions.assertEquals(expectedButtonName, specializationPage.getButtonText(),
                String.format("На странице специализации должна быть кнопка %s", expectedButtonName));
    }
}
