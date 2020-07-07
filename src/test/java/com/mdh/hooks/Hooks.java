package com.mdh.hooks;

import com.mdh.sites.MdhSite;
import com.mdh.utils.Properties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver driver;
    public MdhSite mdhSite;

    public WebDriver getDriver() {
        return driver;
    }

    public MdhSite getMdhSite() {
        return mdhSite;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Properties.LONG_WAIT, TimeUnit.SECONDS);
        mdhSite = new MdhSite(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}