package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void init(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Block");
    }


    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test Block");
    }
}
