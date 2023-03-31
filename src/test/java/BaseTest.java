import config.BaseConfig;
import io.qameta.allure.Allure;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Общий класс с настройками для всех тестов
 */
abstract public class BaseTest {

    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    protected BaseTest() {
    }

    /**
     * Общие настройки для всех тестов, перед выполнением каждого
     */
    @BeforeMethod
    public void setUp() {


        System.setProperty(config.driverProperty(), config.driverPath());
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        // создание экземпляра драйвера
        driver = new ChromeDriver();

        driver.get(config.url());
        // Разворот страницы на полное окно
        driver.manage().window().maximize();
        //Ожидание по умолчанию 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    /**
     * Общие настройки для всех тестов, после выполнения каждого
     */
    @AfterMethod
    public void tearDown() {
        Allure.getLifecycle().addAttachment("screenshot", "image/png", "png", ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        driver.quit();

    }
}
