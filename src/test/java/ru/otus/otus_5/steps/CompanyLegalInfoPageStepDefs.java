package ru.otus.otus_5.steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.otus_5.pages.CompanyLegalInfoPage;

public class CompanyLegalInfoPageStepDefs {
    @Autowired
    CompanyLegalInfoPage companyLegalInfoPage;

    @Then("На странице с правовыми документами есть заголовок {string}")
    public void checkCoursePageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, companyLegalInfoPage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedTitle));
    }
}
