package GoogleApiUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GoogleSheetData {


    private static String spreadsheetId = "1OyDDGPtuDqdpTOQnt59cgf5WKjgb8cFHU5HyhYGFGKo";
    private String range = "Login!A3:B3";
    String userName = "dct.fl.automation@gmail.com";
    String password = "ToAutomateFL123";
    private static GoogleSheetAPI_GetCall sheetAPI;

    public static void main(String[] args) throws Exception {

        CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess("NewUser_FS_EB", 2);
    }

    public static void CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess(String SheetName, int Row) {


        try {
            GoogleSheetAPI_PostCall.CopySpecificRowFromOneSheetToAnotherAtTheEnd(spreadsheetId, "Registered_" + SheetName, SheetName, Row);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*  try {
            GoogleSheetAPI_PostCall.HighlightRowOnceUserRegistered(
                    spreadsheetId,
                    Row - 1,
                    Row,
                    0,
                    GoogleSheetAPI_PostCall.getResponse(SheetName, "A" + Row + "", "G" + Row + "").getValues().get(0).size() + 1,
                    1091307946);
        } catch (IOException e) {
            e.printStackTrace();
        } */


    }


    public static List<List<Object>> getGoogleSheetData(String SheetName, String FromRowToColSelection) {
        //Get data from sheet  and verify first profile info of john
        sheetAPI = new GoogleSheetAPI_GetCall();
        List<List<Object>> values = null;
        try {
            values = sheetAPI.getSpreadSheetRecords(spreadsheetId, SheetName + "!" + FromRowToColSelection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;


    }


    public static List<List<Object>> getGoogleSheetFilledCellData(String SheetName) {
        //Get data from sheet  and verify first profile info of john
        GoogleSheetAPI_GetCall sheetAPI = new GoogleSheetAPI_GetCall();
        List<List<Object>> values = null;
        try {
            values = sheetAPI.getSpreadSheetRecords(spreadsheetId, SheetName + "!" + "A2:R500");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;


    }

    public static String getCellValueBasedOnColumnName(String SheetName, int row, String ColName) {

        sheetAPI = new GoogleSheetAPI_GetCall();
        int index = 0;

        try {
            List<List<Object>> colHeader = GoogleSheetAPI_PostCall.getResponse(SheetName, "A1", "Y1").getValues();
            List<List<Object>> CellValue = sheetAPI.getSpreadSheetRecords(spreadsheetId, SheetName + "!" + "A" + row + "" + ":" + "Y" + row + "");

            for (List<Object> val : colHeader) {

                for (int i = 0; i <= val.size(); i++) {

                    if (val.get(i).toString().equalsIgnoreCase(ColName)) {
                        index = i;
                        break;
                    }

                }
            }

            return CellValue.get(0).get(index).toString();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static HashMap<String, String> getListOfCellValuesBasedOnColumnName(String SheetName, int row, String ListOfRequiredFieldsString) {

        sheetAPI = new GoogleSheetAPI_GetCall();
        int counter = 0;
        HashMap<String, String> colIndex = new HashMap<String, String>();


        try {
            List<List<Object>> colHeader = GoogleSheetAPI_PostCall.getResponse(SheetName, "A1", "Y1").getValues();
            List<List<Object>> CellValue = sheetAPI.getSpreadSheetRecords(spreadsheetId, SheetName + "!" + "A" + row + "" + ":" + "Y" + row + "");
            List<String> ListOfRequiredFields = Arrays.asList(ListOfRequiredFieldsString.split("\\s*,\\s*"));

            for (List<Object> val : colHeader) {

                for (int j = 0; j < ListOfRequiredFields.size(); j++) {

                    for (int i = 0; i < val.size(); i++) {


                        if (val.get(i).toString().equalsIgnoreCase(ListOfRequiredFields.get(j))) {
                            // colIndex.put(ListOfRequiredFields.get(i), i);
                            colIndex.put(ListOfRequiredFields.get(i), CellValue.get(0).get(i).toString());
                            counter++;
                            break;


                        }

                    }

                }

                return colIndex;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static List<List<Object>> getSpecificRowFromGoogleSheet(String SheetName, int row) {

        sheetAPI = new GoogleSheetAPI_GetCall();
        List<List<Object>> values = null;
        try {
            values = sheetAPI.getSpreadSheetRecords(spreadsheetId, SheetName + "!" + "A" + row + "" + ":" + "G" + row + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;

    }

    public static String getSpecificColFromGoogleSheet(String SheetName, String col, int row) {

        sheetAPI = new GoogleSheetAPI_GetCall();

        try {
            return sheetAPI.getSpreadSheetRecords(spreadsheetId, SheetName + "!" + col + row + "").get(0).get(0).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static String getSpecificRowColValueFromGoogleSheet(String SheetName, String RowColIndex) {

        sheetAPI = new GoogleSheetAPI_GetCall();
        try {
            return sheetAPI.getSpreadSheetRecords(spreadsheetId, SheetName + "!" + RowColIndex).get(0).get(0).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void HighlightRowOnceUserRegistered(String FromRowToColSelection, String ExcelSheetName) {

        List<String> list = new ArrayList<String>(Arrays.asList(FromRowToColSelection.split(":")));

        String[] FromCol = list.get(0).split("(?<=\\D)(?=\\d)");
        String[] ToCol = list.get(1).split("(?<=\\D)(?=\\d)");


        try {
            GoogleSheetAPI_PostCall.HighlightRowOnceUserRegistered(
                    spreadsheetId,
                    Integer.parseInt(FromCol[1]) - 1,
                    Integer.parseInt(FromCol[1]),
                    0,
                    8,
                    1091307946);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void HighlightRowOnceUserRegistered(String ExcelSheetName, int row) {

       /* List<String> list = new ArrayList<String>(Arrays.asList(FromRowToColSelection.split(":")));

        String[] FromCol = list.get(0).split("(?<=\\D)(?=\\d)");
        String[] ToCol = list.get(1).split("(?<=\\D)(?=\\d)");*/


        try {
            GoogleSheetAPI_PostCall.HighlightRowOnceUserRegistered(
                    spreadsheetId,
                    row - 1,
                    row,
                    0,
                    GoogleSheetAPI_PostCall.getResponse(ExcelSheetName, "A" + row + "", "G" + row + "").getValues().get(0).size() + 1,
                    1091307946);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
