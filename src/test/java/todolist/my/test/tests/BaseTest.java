package todolist.my.test.tests;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected static Properties DATA;

    public void initialize() throws Throwable {
        DATA = new Properties();
        FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/DATA.properties");
        DATA.load(fn);
    }

    protected BaseTest() {
            Configuration.browser = "chrome";
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        }

        @BeforeMethod
        public void init () {
            open("http://todolistme.net/");
        }

        @AfterMethod
        public void dispose () {
            close();
        }
    }


