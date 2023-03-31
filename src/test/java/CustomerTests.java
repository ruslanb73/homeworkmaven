import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManagerAddCustomerPage;

/**
 * Основной класс с тестами CustomerTests
 */
@Epic("Создание клиента (AddCustomer)")
public class CustomerTests extends BaseTest {


    @Test(description = "Успешное создание клиента на странице manager")
    public void successAddClientsTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести имя клиента в поле First Name", managerAddCustomerPage::addFirstName);
        Allure.step("Шаг 3. Ввести фамилию клиента в поле Last Name", managerAddCustomerPage::addLastName);
        Allure.step("Шаг 4. Ввести почтовый индекс в поле Post Code", managerAddCustomerPage::addProductCode);
        Allure.step("Шаг 5. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);

        Alert alerts = driver.switchTo().alert();
        String textAlert = alerts.getText().replaceAll("[\\d]", "");
        System.out.println(textAlert);
        alerts.accept();
        Assert.assertEquals(
                textAlert,
                "Customer added successfully with customer id :",
                "Alert не соответствует");

    }

    @Test(description = "Всплывающее уведомление при создании клиента на странице manager при отсутствии заполненного поля Last Name")
    public void PopUpFailedAddedClientsAbsenceLastNameTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addFirstName);
        Allure.step("Шаг 3. Ввести почтовый индекс в поле Post Code", managerAddCustomerPage::addProductCode);
        Allure.step("Шаг 4. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);
        Assert.assertEquals(managerAddCustomerPage.lastNameEnterField(),
                "Заполните это поле.");
    }

    @Test(description = "Всплывающее уведомление при создании клиента на странице manager при отсутствии заполненного поля First Name")
    public void PopUpFailedAddedClientsAbsenceFirstNameTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addLastName);
        Allure.step("Шаг 3. Ввести почтовый индекс в поле Post Code", managerAddCustomerPage::addProductCode);
        Allure.step("Шаг 4. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);
        Assert.assertEquals(managerAddCustomerPage.firstNameEnterField(),
                "Заполните это поле.");
    }

    @Test(description = "Всплывающее уведомление при создании клиента на странице manager при отсутствии заполненного поля Product Code" )
    public void PopUpFailedAddedClientsAbsenceProductCodeTest() {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Allure.step("Шаг 1. Нажать главную кнопку AddCustomer", managerAddCustomerPage::addCustomerButton);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addFirstName);
        Allure.step("Шаг 2. Ввести фамилию клиента в поле First Name", managerAddCustomerPage::addLastName);
        Allure.step("Шаг 4. Нажать прозрачную кнопку AddCustomer", managerAddCustomerPage::addCustomer);
        Assert.assertEquals(managerAddCustomerPage.productCodeEnterField(),
                "Заполните это поле.");
    }
}


