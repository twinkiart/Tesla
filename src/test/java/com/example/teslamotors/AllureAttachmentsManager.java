package com.example.teslamotors;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachmentsManager {
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot(){
        return((TakesScreenshot) TeslaTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
