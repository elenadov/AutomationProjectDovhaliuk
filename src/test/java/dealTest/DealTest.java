package dealTest;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DealTest extends AbstractParentTest {

    String date = "10";
    String month = "09";
    String year = "2020";
    String hours = "18";
    String minutes = "00";
    String dealType = "BIG SALE";
    String customer = "ФОП Марченко В.Г.";
    String provider = "Лукашин Олег Степанович";

    @Before
    public void deleteDealFirstly() {
        dealsPage.deleteDealTillNotPresent(date, month, year, hours, minutes);
    }

    @Test
    public void positiveSmokeCaseCreateDeal() {

        loginPage.fillingLoginFormWithSubmit("Student", "909090");

        homePage.checkCurrentURL();
        homePage.leftMenu.clickOnSubmenuDeal();

        dealsPage.checkCurrentURL();
        dealsPage.clickOnAddButton();

        dealsEditPage.checkCurrentURL();
        dealsEditPage.selectDateFromDropDown(date);
        dealsEditPage.selectionOfMonthInDropDown(month);
        dealsEditPage.selectYearFromDropDown(year);
        dealsEditPage.selectHoursFromDropDown(hours);
        dealsEditPage.selectMinutesFromDropDown(minutes);
        dealsEditPage.selectDealTypeFromDropDown(dealType);
        dealsEditPage.selectCustomerFromDropDown(customer);
        dealsEditPage.selectProviderFromDropDown(provider);
        dealsEditPage.clickOnSubmitButton();

        dealsPage.checkCurrentURL();

        checkExpectedResult("Deal wasn't found", dealsPage.isDealInList(date, month, year, hours, minutes));
    }

    @After
    public void deleteDeal() {
        dealsPage.deleteDealTillNotPresent(date, month, year, hours, minutes);
    }
}
