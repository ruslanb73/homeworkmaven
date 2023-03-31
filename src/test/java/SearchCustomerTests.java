import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManagerCustomerPage;



/**
 * Основной класс с тестами SearchCustomerTests
 */
@Epic("Поиск клиента")
public class SearchCustomerTests extends BaseTest {


    @Test(description = "Поиск клиента по имени" )
    public void searchCustomerByFirstNameTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести имя существующего клиента", () -> {
            managerCustomerPage.addSearch("Ron");
            Assert.assertEquals(
                    managerCustomerPage.textFirstName(),
                    "Ron",
                    "Клиент не найден ");
        });
    }

    @Test(description = "Поиск клиента по фамилии")
    public void searchCustomerByLastNameTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести фамилию существующего клиента", () -> {
            managerCustomerPage.addSearch("Potter");
            Assert.assertEquals(
                    managerCustomerPage.textLastName(),
                    "Potter",
                    "Клиент не найден ");
        });
    }

    @Test(description = "Поиск клиента по индексу")
    public void searchCustomerByProductCodeTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести индекс существующего клиента", () -> {
            managerCustomerPage.addSearch("E55555");
            Assert.assertEquals(
                    managerCustomerPage.textProductCode(),
                    "E55555",
                    "Клиент не найден ");
        });
    }



    @Test(description = "Поиск несуществующего клиента по имени")
    public void searchCustomerNoClientTest() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);

        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerCustomerPage::customerButton);
        Allure.step("Шаг 2. В поле Search Customers ввести имя несуществующего клиента", () -> {
            managerCustomerPage.addSearch("NoClient");
            Assert.assertEquals(0, driver.findElements(By.xpath("//div/table/tbody/tr[1]")).size());
        });
    }
}
