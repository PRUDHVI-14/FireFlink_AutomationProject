package ninjaCRM.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int cnt =0;
	int retryCnt = 3;
	public boolean retry(ITestResult result) {
		
		while(cnt<retryCnt) {
			cnt++;
			return true;//retry
		}
		return false;//stop retry
	}
}
