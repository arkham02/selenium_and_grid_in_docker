package tests;

import demo.C_InvokeChrome;
import demo.D_Assertions;
import demo.F_WorkingWithUIElements;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SeleniumCases {

    @Test
    public void testCase1() throws InterruptedException {
        D_Assertions assertions = new D_Assertions();
        assertions.waitsAndAssertions();
        Thread.sleep(20000);
    }

    @Test
    public void testCase2() throws InterruptedException {
        F_WorkingWithUIElements workingWithUIElements = new F_WorkingWithUIElements();
        workingWithUIElements.elementsInteraction();
        Thread.sleep(20000);
    }
}
