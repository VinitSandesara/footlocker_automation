package ExtentReport;



public class ExtentTestManager {
 /*  // static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    static Map<String, ExtentTest> extentTestMap = new HashMap<String, ExtentTest>();
    static ExtentReports extent = ExtentManager.getInstance();

    public static synchronized ExtentTest getTest(String key) {
        // return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
        return (ExtentTest) extentTestMap.get(key);

    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);

        // extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        extentTestMap.put(testName, test);


        return test;
    }

    public static synchronized ExtentTest startTestUsingNode(String testName) {
        ExtentTest test = extent.createTest(testName);
        test.createNode(testName);
        return test;
    }

*/


}