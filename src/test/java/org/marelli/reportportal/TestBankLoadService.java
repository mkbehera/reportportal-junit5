package org.marelli.reportportal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;

//@TestMethodOrder(value=OrderAnnotation.class)
//@TestMethodOrder(value=MethodName.class)
//@TestMethodOrder(value=MethodOrderer.DisplayName.class)
//@TestMethodOrder(value=MethodOrderer.Random.class)
public class TestBankLoadService {

	private static BankLoanService service;
	private static float actual = 0.0f;
	
	/*
	 * @BeforeEach public void setUp() {
	 * System.out.println("TestBankLoadService.setUp()"); service = new
	 * BankLoanService(); actual = service.calcSimpleInterstAmount(100000, 2, 12); }
	 */
	
	@BeforeAll
	public static void setUpOnce() {
		System.out.println("TestBankLoadService.setUpOnce()"); 
		service = new BankLoanService(); 
		actual = service.calcSimpleInterstAmount(100000, 2, 12); 
	}

	@Test
	@DisplayName("Testing with Small Numbers")
	//@Order(10)
	@Tag("dev")
	public void testcalcSimpleInterstAmount1WithSmallNumber() {
		System.out.println("TestBankLoadService.testcalcSimpleInterstAmountWithSmallNumber()");
		float expected = 24000.0f;//through manual calculation
		assertEquals(expected, actual, "may be results are not matching");
	}
	
	@Test
	@DisplayName("Testing with Big Numbers")
	//@Order(2)
	@Tag("uat")
	public void testcalcSimpleInterstAmount2WithBigNumber() {
		System.out.println("TestBankLoadService.testcalcSimpleInterstAmountWithBigNumber()");
		float actual = service.calcSimpleInterstAmount(10000000, 2, 12);
		float expected = 2400000.12f;//through manual calculation
		assertEquals(expected, actual);
		//assertEquals(expected, actual, "may be results are not matching");
		//assertEquals(expected, actual, 0.5, "may be results are not matching");
	}
	
	@Test
	@DisplayName("Testing with Invalid Inputs")
	//@Order(5)
	@Tag("uat")
	public void testcalcSimpleInterstAmount3WithInvalidInputs() {
		System.out.println("TestBankLoadService.testcalcSimpleInterstAmountWithInvalidInputs()");		/*
		 * float actual = service.calcSimpleInterstAmount(0, 2, 12); float expected =
		 * 2400000.12f;//through manual calculation assertEquals(expected, actual);
		 */
		assertThrows(IllegalArgumentException.class, ()->service.calcSimpleInterstAmount(0, 0, 0), "may be exception raised is not matching");
	}
	
	
	  @Test 
	  @Disabled
	  @DisplayName("Testing with time out period")
	 //@Order(0)
	  @Tag("dev")
	  public void testcalcSimpleInterstAmount4WithTimer() { 
		  BankLoanService service = new BankLoanService(); 
		  assertTimeout(Duration.ofMillis(20000),()->service.calcSimpleInterstAmount(100000, 2, 12));
	  }
	 
	
	@Test
	@DisplayName("Testing for No Exceptions")
	//@Order(-10)
	@Tag("uat")
	public void testcalcSimpleInterstAmount5WithForNoExceptions() {
		System.out.println("TestBankLoadService.testcalcSimpleInterstAmountWithForNoExceptions()");
		assertDoesNotThrow(()->service.calcSimpleInterstAmount(100000, 2, 12));
		
	}
	
	/*
	 * @AfterEach public void clear() {
	 * System.out.println("TestBankLoadService.clear()"); service = null; actual =
	 * 0.0f; }
	 */
	
	@AfterAll
	public static void clearOnce() {
		System.out.println("TestBankLoadService.clear()"); 
		service = null; 
		actual = 0.0f;
	}
		
}
	