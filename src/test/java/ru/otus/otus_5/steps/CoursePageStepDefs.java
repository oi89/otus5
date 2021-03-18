package ru.otus.otus_5.steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.otus_5.pages.CoursePage;

public class CoursePageStepDefs {
    @Autowired
    CoursePage coursePage;

    @Then("На странице курса есть заголовок {string}")
    public void checkCoursePageTitle(String expectedCourseName) {
        Assertions.assertEquals(expectedCourseName, coursePage.getTitleText(),
                String.format("Заголовок страницы должен быть равен %s", expectedCourseName));
    }

    @Then("На странице курса есть кнопка {string}")
    public void checkCoursePageButton(String expectedButtonName) {
        Assertions.assertEquals(expectedButtonName, coursePage.getButtonText(),
                String.format("На странице курса должна быть кнопка %s", expectedButtonName));
    }
}
