package ru.otus.otus_5.config;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.otus_5.utils.Driver;

@Configuration
@ComponentScan("ru.otus.otus_5.pages")
public class Config {
    @Bean
    public WebDriver getDriver() {
        return Driver.getChromeDriver();
    }
}
