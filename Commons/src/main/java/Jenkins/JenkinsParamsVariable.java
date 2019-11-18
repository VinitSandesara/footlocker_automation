package Jenkins;

import cucumber.api.Scenario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JenkinsParamsVariable {

    /* Jenkins run */
    public static String GoogleDriveSpreadSheetName = System.getProperty("SpreadSheetName");
    public static String GoogleDriveSpreadSheetRowNumber = System.getProperty("SheetRowNumber");
    public static String TagName = System.getProperty("TagName");


    /* Local Run

    public static String GoogleDriveSpreadSheetName = "NewUser_FS_EB,Registered_NewUser_FS_EB";
    public static String GoogleDriveSpreadSheetRowNumber = "2,3";
    public static String TagName = "@Debug_New_Single_User"; */



    public static boolean isSheetNameAndSheetRowParsed = false;
    public static HashMap<String, List<String>> getSheetNameWithItsRowNumber = new HashMap<>();



    public static void putSheetNameAndSheetRowNumber(String key, Scenario scenario, int counter) {


        scenario.write("Counter at beginnner is ==>> " + counter);
        List<List<String>> FinalValues = new ArrayList<List<String>>();

        List<String> putSheetNameWithRowNumber = new ArrayList<String>();

        List<String> ListOfGoogleSpreadSheet = Arrays.asList(JenkinsParamsVariable.GoogleDriveSpreadSheetName.split("\\s*,\\s*"));
        List<String> ListSpreadSheetRows = Arrays.asList(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber.split("\\s*,\\s*"));

      //  for (int i = 0; i < ListOfGoogleSpreadSheet.size(); i++) {

            putSheetNameWithRowNumber.add(ListOfGoogleSpreadSheet.get(counter));
            putSheetNameWithRowNumber.add(ListSpreadSheetRows.get(counter));

            FinalValues.add(putSheetNameWithRowNumber);
            scenario.write("=== YOUR FinalValues IS ==== " + FinalValues);

            getSheetNameWithItsRowNumber.put(key, FinalValues.get(0));


      //  }

       // scenario.write("=== YOUR HASHMAP IS ==== " + getSheetNameWithItsRowNumber);

    }


    static {

        if (!isSheetNameAndSheetRowParsed) {

            /* Jenkins run
            List<String> Key_ListOfScenarios = Arrays.asList(TagName.split("\\s*,\\s*"));
            List<List<String>> FinalValues = new ArrayList<List<String>>();


            for (int i = 0; i < Key_ListOfScenarios.size(); i++) {

                List<String> putSheetNameWithRowNumber = new ArrayList<String>();

                List<String> ListOfGoogleSpreadSheet = Arrays.asList(GoogleDriveSpreadSheetName.split("\\s*,\\s*"));
                List<String> ListSpreadSheetRows = Arrays.asList(GoogleDriveSpreadSheetRowNumber.split("\\s*,\\s*"));

                putSheetNameWithRowNumber.add(ListOfGoogleSpreadSheet.get(i));
                putSheetNameWithRowNumber.add(ListSpreadSheetRows.get(i));

                FinalValues.add(putSheetNameWithRowNumber);

                getSheetNameWithItsRowNumber.put(Key_ListOfScenarios.get(i), FinalValues.get(i));

            }

            System.out.println("HASHMAP VALUES ARE ====>>>>" + getSheetNameWithItsRowNumber);

            isSheetNameAndSheetRowParsed = true; */



            /* Local Test

            List<String> Key_ListOfScenarios = Arrays.asList(TagName.split("\\s*,\\s*"));
            List<List<String>> FinalValues = new ArrayList<List<String>>();


            for (int i = 0; i < Key_ListOfScenarios.size(); i++) {

                List<String> putSheetNameWithRowNumber = new ArrayList<String>();

                List<String> ListOfGoogleSpreadSheet = Arrays.asList(GoogleDriveSpreadSheetName.split("\\s*,\\s*"));
                List<String> ListSpreadSheetRows = Arrays.asList(GoogleDriveSpreadSheetRowNumber.split("\\s*,\\s*"));

                putSheetNameWithRowNumber.add(ListOfGoogleSpreadSheet.get(i));
                putSheetNameWithRowNumber.add(ListSpreadSheetRows.get(i));

                FinalValues.add(putSheetNameWithRowNumber);

                getSheetNameWithItsRowNumber.put(Key_ListOfScenarios.get(i), FinalValues.get(i));

            }

            isSheetNameAndSheetRowParsed = true; */


        }


    }


}
