package com.footlocker.customrunner;

/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.deps.difflib.DiffRow.Tag;
import gherkin.pickles.PickleTag;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner; */


public class CustomAbstractTestNGCucumberTestsWithTag {
  /*  private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }


    @DataProvider
    public Iterator<Object[]> scenarios() {
        ArrayList<Object[]> modifiedList = new ArrayList<>();
        if (testNGCucumberRunner == null) {
            //return new Object[0][0];
            return modifiedList.iterator();
        }
        //Object[][] data = testNGCucumberRunner.provideScenarios();
        //PickleEventWrapper pickleEventWrapper = (PickleEventWrapper)data[0][0];
        //CucumberFeatureWrapper cucumberFeatureWrapper = (CucumberFeatureWrapper)data[0][1];
        modifiedList = filterTheFeature(testNGCucumberRunner.provideScenarios());
        //return testNGCucumberRunner.provideScenarios();
        return modifiedList.iterator();
    }



    private ArrayList<Object[]> filterTheFeature(Object[][] data) {
        String tagValue = System.getProperty("TagName");

        if (tagValue == null || tagValue.isEmpty()) {
            return getFeatureList(data);
        }

        List<String> tagList = Arrays.asList(tagValue.split(","));
        //List<String> featureList = Arrays.asList("Web Element Functions","Working with Java Script Popup");
        ArrayList<Object[]> modifiedList = new ArrayList<>();

        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                PickleEventWrapper pickleEventWrapper = (PickleEventWrapper) data[i][0];
                if (!pickleEventWrapper.getPickleEvent().pickle.getTags().isEmpty()) {
                    for (String aTag : tagList) {
                        if (isTagPresent(aTag, pickleEventWrapper.getPickleEvent().pickle.getTags())) {
                            modifiedList.add(data[i]);
                        }
                    }
                }

            }
        }
        return modifiedList;
    }

    private boolean isTagPresent(String aTag, List<PickleTag> aTagList) {

        for (PickleTag pickleTag : aTagList) {
            if (aTag.equalsIgnoreCase(pickleTag.getName()))
                return true;
        }
        return false;
    }

    private ArrayList<Object[]> getFeatureList(Object[][] data) {
        ArrayList<Object[]> modifiedList = new ArrayList<>();
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                modifiedList.add(data[i]);
            }
        }
        return modifiedList;
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }*/
}