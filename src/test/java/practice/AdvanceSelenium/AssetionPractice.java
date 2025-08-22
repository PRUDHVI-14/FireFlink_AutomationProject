package practice.AdvanceSelenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class AssetionPractice {

	@Test
	public void sampleTest() {
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		Assert.assertEquals(1, 1);
		System.out.println("step-4");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(0, 1);
		System.out.println("step-5");

	}
}
