package com.github.binarySmile.todolistautotest.core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected static final String URL = "http://todolistme.net/";
    protected static Properties DATA;

    protected BaseTest() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    public void initialize() {
        DATA = new Properties();
        try (FileInputStream fn = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/DATA.properties")) {
            DATA.load(fn);
        } catch (Exception ex) {
            throw new RuntimeException("Exception during the IO operation: "
                    + ex.getLocalizedMessage());
        }
    }

    @BeforeTest
    public void beforeTest() {
        initialize();
    }

    @BeforeMethod
    public void init() {
        open(URL);
    }

    @AfterMethod
    public void dispose() {
        close();
    }
}


