package ru.otus.otus_5.steps;

import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.otus_5.utils.Driver;

@CucumberContextConfiguration
@SpringBootTest
public class BasePageStepDefs {
    @After
    public void afterTest() {
        Driver.closeDriver();
    }
}
