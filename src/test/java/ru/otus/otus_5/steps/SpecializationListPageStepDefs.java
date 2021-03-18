package ru.otus.otus_5.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.otus_5.pages.SpecializationsListPage;

public class SpecializationListPageStepDefs {
    @Autowired
    SpecializationsListPage specializationsListPage;

    @Then("В блоке специализации {string} есть заголовок {string}")
    public void checkCoursePageTitle(String hrefValue, String expectedSpecTitle) {
        Assertions.assertEquals(expectedSpecTitle,
                specializationsListPage.getSpecializationBlockTitle(hrefValue),
                String.format("Заголовок страницы должен быть равен %s", expectedSpecTitle));
    }

    @When("Кликнуть на блоке специализации {string}")
    public void clickSpecializationBlock(String blockHrefValue) {
        specializationsListPage.clickSpecializationBlock(blockHrefValue);
    }
}
