package com.example.teslamotors;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class TeslaTest extends MainTest {
    private static TeslaPage teslaPage;

    @BeforeEach
    @Override
    @Step("Тест сайта Теслы: ")
    public void setUp() {
        super.setUp();
        driver.get("https://www.tesla.com/");
        teslaPage = new TeslaPage(driver);
    }

    @Test
    @DisplayName("Переход в меню выбора Моделей Авто")
    public void clickMenuCar(){
    teslaPage.clickVehiclesModels();
    teslaPage.clickStar();
        assertEquals("https://www.tesla.com/choose",teslaPage.getCurrentUrl(),"Не перешли на страницу выбора моделей");
    }
    @Test
    @DisplayName("Выбор модели ")
    public void choseUrCar(){
        teslaPage.clickVehiclesModels();
        teslaPage.clickStar();
        teslaPage.clickUrCar();
        String Test = teslaPage.getText();
        assertTrue(Test.contains("What style of vehicle are you looking for?"),"Текст выбора модели не найден");
        teslaPage.clickSedan();
        String Model = teslaPage.getText();
        assertTrue(Model.contains("How far do you drive each day?"),"Текст дистанции езды не высветился");
        teslaPage.clickDistance();
        String UseMetodCar = teslaPage.getText();
        assertTrue(UseMetodCar.contains("How will you use your new vehicle?"),"Текст предпочтений применения авто не найден");
        teslaPage.clickPreference();
        String preference = teslaPage.getText();
        assertTrue(preference.contains("What do you want most from your next vehicle?"),"Текст ожиданий от авто не найден");
        teslaPage.clickUtility();
        String ModelS = teslaPage.getText();
        assertTrue(ModelS.contains("Model S"),"Модель авто не показана");
        String Prise = teslaPage.getText();
        assertTrue(Prise.contains("Starting Price"),"Цена не показана");
    }

}
