package com.footlocker.steps;



import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.*;



public class Hooks {

    private SelenideConfiguration selenideConfiguration;
    public static String key;
    // public static Scenario scenario;
    public static HashMap<String, List<String>> getSheetNameWithItsRowNumber = new HashMap<>();

    static int tempCounter = 0;

    private static HashMap<Integer, Scenario> scenarios;


  /*  public Hooks() {
        SelenideConfiguration selenideConfiguration = new SelenideConfiguration();
        this.selenideConfiguration = selenideConfiguration;
        if (scenarios == null)
            scenarios = new HashMap<Integer, Scenario>();
    }*/

    public Hooks(SelenideConfiguration selenideConfiguration) {

        this.selenideConfiguration = selenideConfiguration;
        if (scenarios == null)
            scenarios = new HashMap<Integer, Scenario>();
    }

    private void addScenario(Scenario scenario) {
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        scenarios.put(threadID, scenario);
    }

    public static synchronized Scenario getScenario() {
        Thread currentThread = Thread.currentThread();
        int threadID = currentThread.hashCode();
        return scenarios.get(threadID);
    }


    @Before
    public void BeforeScenario(Scenario scenario) {


        addScenario(scenario);

       // ExtentTestManager.startTest(getScenario().getName());

        selenideConfiguration.getBrowser(scenario.getName());

        key = scenario.getName().replaceAll("\\s", "_");

       /* scenario.write("===YOUR KEY IS ==== " + key);


        JenkinsParamsVariable.putSheetNameAndSheetRowNumber(key, scenario, tempCounter);

        scenario.write("YOUR HOOKS KEY IS ===" + JenkinsParamsVariable.getSheetNameWithItsRowNumber.get(key));*/


        //  scenario.write("********** VALUES FROM HASHMAP IS **********" +  Hooks.getSheetNameWithItsRowNumber.get(Hooks.key));


        // key = scenario.getSourceTagNames().iterator().next();

        //  System.out.println("KEYS ARE ====>>>>" + key);

      /*   System.out.println("KEYS ARE ====>>>>" + key);

        Configuration.baseUrl = GoogleSheetData.getCellValueBasedOnColumnName(
                    JenkinsParamsVariable.getSheetNameWithItsRowNumber.get(key).get(0),
                    Integer.parseInt(JenkinsParamsVariable.getSheetNameWithItsRowNumber.get(key).get(1)),
                    "Banner"
            );

        SelenideConfiguration.driver.get(Configuration.baseUrl);*/


       /* InputStream in =
                Hooks.class.getResourceAsStream("/extent-config.xml");

        String path = String.valueOf(new InputStreamReader(in));

        Reporter.loadXMLConfig(String.valueOf(new InputStreamReader(in))); */

    }

    @After
    public void AfterScenario() {

        if (getScenario().isFailed()) {
            getScenario().embed("<font size=\"5\" color=\"red\">Scenario failed so capturing a screenshot</font></b>".getBytes(), "text/html");

            TakesScreenshot screenshot = (TakesScreenshot) WebDriverRunner.getWebDriver();
            String base64Image = screenshot.getScreenshotAs(OutputType.BASE64);
            byte[] htmlImage = ("<img class=\"col-lg-12\" src=\"data:image/png;base64," + base64Image + "\">").getBytes();
            getScenario().embed(htmlImage, "text/html");

        }

    /* Option: 1
      //  selenideConfiguration.closeSession(); */

        /* Option: 2 */
        WebDriverRunner.getWebDriver().quit();


    }


}