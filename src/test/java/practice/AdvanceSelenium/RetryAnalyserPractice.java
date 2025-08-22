package practice.AdvanceSelenium;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = ninjaCRM.genericUtilities.RetryAnalyserImplementation.class)
	
	public void sample() {
		System.out.println("sample");
		Assert.fail();
	}
}
