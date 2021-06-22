package tests;

import demo.D_Assertions;
import demo.F_WorkingWithUIElements;
import org.testng.annotations.Test;

public class SeleniumCases {

    @Test
    public void testCase1() throws InterruptedException {
        System.out.println("Browser value:"+ System.getProperty("browser"));
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
