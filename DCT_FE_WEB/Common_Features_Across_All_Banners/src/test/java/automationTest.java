import GoogleApiUtil.GoogleSheetAPI_GetCall;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class automationTest {

    private String spreadsheetId = "1OyDDGPtuDqdpTOQnt59cgf5WKjgb8cFHU5HyhYGFGKo";
    private String range = "Login!A3:B3";
    String userName = "dct.fl.automation@gmail.com";
    String password = "ToAutomateFL123";


    @Test
    public void readData() throws IOException {
        //Get data from sheet  and verify first profile info of john
        GoogleSheetAPI_GetCall sheetAPI = new GoogleSheetAPI_GetCall();

       // String value = sheetAPI.getSpreadSheetRecords(spreadsheetId, "Login!B3").get(0);



        List<List<Object>> values = sheetAPI.getSpreadSheetRecords(spreadsheetId, "Login!B3");

           System.out.println("1st col ==>> " + values.get(0).get(0));

        for (List<Object> row : values) {


            System.out.println("1st col ==>> " + row.get(0));
            System.out.println("2nd col  ==>>" + row.get(1));
        }
    }

    @Test
    public void updateRecord() throws IOException {

        GoogleSheetAPI_GetCall sheetAPI = new GoogleSheetAPI_GetCall();
         sheetAPI.updateSpreadSheetRecords();

    }


}
