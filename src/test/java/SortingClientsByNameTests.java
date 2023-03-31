import io.qameta.allure.Allure;
import io.qameta.allure.Epic;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManagerCustomerPage;


/**
 * Основной класс с тестами SortingClientsByNameTests
 */
@Epic("Сортировка клиентов по имени (First Name)")
public class SortingClientsByNameTests extends BaseTest {


    @Test(description = "Сортировка клиентов на странице manager в порядке возрастания")
    public void test() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);
        Allure.step("Шаг 1. Нажать кнопку Customers", managerCustomerPage::customerButton);

        Allure.step("Шаг 2:  Нажать на кнопку сортировки First Name два раза", () -> {
            managerCustomerPage.firstNameButton();
            managerCustomerPage.firstNameButton();
            managerCustomerPage.textFirstName();
            Assert.assertEquals(
                    managerCustomerPage.textFirstName(),
                    "Albus",
                    "Ошибка при сортировке данных ");

        });
    }


    @Test(description = "Сортировка клиентов на странице manager в порядке убывания")
    public void test2() {
        ManagerCustomerPage managerCustomerPage = new ManagerCustomerPage(driver);
        Allure.step("Шаг 1. Нажать кнопку Customers", managerCustomerPage::customerButton);
        Allure.step("Шаг 2:  Нажать на кнопку сортировки First Name два раза", managerCustomerPage::firstNameButton);
        managerCustomerPage.textFirstName();
        Assert.assertEquals(
                managerCustomerPage.textFirstName(),
                "Ron",
                "Ошибка при сортировке данных ");

    }
}
