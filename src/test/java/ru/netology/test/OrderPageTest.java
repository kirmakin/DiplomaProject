package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.CardGenerator;
import ru.netology.data.SutData;
import ru.netology.pages.OrderPage;
import ru.netology.pages.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderPageTest {
    private StartPage startPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openStartPage() {
        startPage = open(SutData.startPageUrl, StartPage.class);
    }

    @Test
    public void shouldOpenOrderPage() {
        assertNotNull(startPage);
    }

    @Test
    public void shouldApprovedCreditByCard() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithApprovedCardNumber());
        orderPage.sendData();
        orderPage.shouldBeApproved();
    }

    @Test
    public void shouldApprovedOrderByCard() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithApprovedCardNumber());
        orderPage.sendData();
        orderPage.shouldBeApproved();
    }

    @Test
    public void shouldDeclinedCreditByDeclinedCard() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithDeclinedCardNumber());
        orderPage.sendData();
        orderPage.shouldBeDeclined();
    }
    @Test
    public void shouldDeclinedOrderByDeclinedCard() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithDeclinedCardNumber());
        orderPage.sendData();
        orderPage.shouldBeDeclined();
    }

    @Test
    public void shouldDeclinedCreditByUnknownCard() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithUnknownCardNumber());
        orderPage.sendData();
        orderPage.shouldBeDeclined();
    }

    @Test
    public void shouldDeclinedOrderByUnknownCard() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithUnknownCardNumber());
        orderPage.sendData();
        orderPage.shouldBeDeclined();
    }

    @Test
    public void shouldNotSendOrderByCardWithExpiredDate() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithExpiredDate());
        orderPage.sendData();
        orderPage.shouldBeExpiredDateError();
    }
    @Test
    public void shouldNotSendCreditByCardWithExpiredDate() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithExpiredDate());
        orderPage.sendData();
        orderPage.shouldBeExpiredDateError();
    }
    @Test
    public void shouldNotSendOrderByCardWithTooBigMonth() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectMonth());
        orderPage.sendData();
        orderPage.shouldBeIncorrectMonthYearError();
    }
    @Test
    public void shouldNotSendCreditByCardWithIncorrectMonth() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectMonth());
        orderPage.sendData();
        orderPage.shouldBeIncorrectMonthYearError();

    }
    @Test
    public void shouldNotSendCreditByCardWithEmptyFields() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.sendData();
        orderPage.shouldBeEmptyAllFieldsErrors();
    }

    @Test
    public void shouldNotSendOrderByCardWithEmptyFields() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.sendData();
        orderPage.shouldBeEmptyAllFieldsErrors();
    }

    @Test
    public void shouldNotSendCreditByCardWithIncorrectNumberAndCvc() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectCardNumberAndCvc());
        orderPage.sendData();
        orderPage.shouldBeIncorrectNumberAndCvcErrors();
    }

    @Test
    public void shouldNotSendOrderByCardWithIncorrectNumberAndCvc() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectCardNumberAndCvc());
        orderPage.sendData();
        orderPage.shouldBeIncorrectNumberAndCvcErrors();
    }

    @Test
    public void shouldNotSendCreditByCardWithIncorrectCvc() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectCvvCvc());
        orderPage.sendData();
        orderPage.shouldBeIncorrectCvcErrors();
    }

    @Test
    public void shouldNotSendOrderByCardWithIncorrectCvc() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectCvvCvc());
        orderPage.sendData();
        orderPage.shouldBeIncorrectCvcErrors();
    }

    @Test
    public void shouldNotSendCreditByCardWithIncorrectOwner() {
        OrderPage orderPage = startPage.selectOrderByCredit();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectOwnerByCyrillic());
        orderPage.sendData();
        orderPage.shouldBeIncorrectFormat();
    }

    @Test
    public void shouldNotSendOrderByCardWithIncorrectOwner() {
        OrderPage orderPage = startPage.selectOrderByCard();
        orderPage.setCardFields(CardGenerator.CardInfo.getCardInfoWithIncorrectOwnerByCyrillic());
        orderPage.sendData();
        orderPage.shouldBeIncorrectFormat();
    }

}


