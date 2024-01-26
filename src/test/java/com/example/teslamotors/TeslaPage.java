package com.example.teslamotors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;


public class TeslaPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(TeslaPage.class));
    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Vehicles')]")
    private WebElement vehiclesButton;
    @FindBy(xpath = "//*[contains(text(),'Get Started')]")
    private WebElement getStart;
    @FindBy(xpath = "/html/body/div[3]/main/div[1]/button")
    private WebElement choseModels;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[3]/label[1]")
    private WebElement choseSedan;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[5]/button")
    private WebElement next;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[4]/button")
    private WebElement secondNext;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[3]/label[2]")
    private WebElement Distance;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[3]/div/label[1]")
    private WebElement RoadTrip;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[3]/div/label[5]")
    private WebElement PerfomanceDriving;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[3]/div/label[6]")
    private WebElement Technology;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[3]/label[4]")
    private WebElement Utility;
    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[4]/button")
    private WebElement Submit;



    public TeslaPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }

    public void clickVehiclesModels(){
        vehiclesButton.click();
        LOG.infoWithScreenshot("Кликнули в меню выбора моделей");
    }
    public void clickStar(){
        getStart.click();
        LOG.infoWithScreenshot("Кликнули на стар выбора моделей");
    }
    public void clickUrCar(){
        choseModels.click();
        LOG.infoWithScreenshot("Открылось меню выбора моделей");
    }
    public void clickSedan(){
        choseSedan.click();
        next.click();
        LOG.infoWithScreenshot("Выбрали модель авто Седан");
    }
    public  void clickDistance(){
        Distance.click();
        next.click();
        LOG.infoWithScreenshot("Выбрали дистанцию 40-100 Миль");
    }
    public void clickPreference(){
        RoadTrip.click();
        PerfomanceDriving.click();
        Technology.click();
        secondNext.click();
        LOG.infoWithScreenshot("Выбрали 3 пердпочтения в авто");


    }
    public void clickUtility(){
        Utility.click();
        Submit.click();
        LOG.infoWithScreenshot("Выбрали Utility");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public String getText(){
        return driver.findElement(By.tagName("body")).getText();
    }
}
