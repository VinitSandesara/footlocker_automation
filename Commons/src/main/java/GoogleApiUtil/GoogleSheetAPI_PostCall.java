package GoogleApiUtil;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;


import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetAPI_PostCall {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME =
            "Google Sheets API Java Quickstart";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart.json");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     * <p>
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart.json
     */
    private static final List<String> SCOPES =
            Arrays.asList(SheetsScopes.SPREADSHEETS);

    public static ValueRange response;
    public static UpdateValuesResponse request;


    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }


    /**
     * Creates an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
                GoogleSheetAPI_GetCall.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Sheets API client service.
     *
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static ValueRange getResponse(String SheetName, String RowStart, String RowEnd) throws IOException {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();


        // Prints the names and majors of students in a sample spreadsheet:
        String spreadsheetId = "1OyDDGPtuDqdpTOQnt59cgf5WKjgb8cFHU5HyhYGFGKo";
        String range = SheetName + "!" + RowStart + ":" + RowEnd;
        response = service.spreadsheets().values()
                .get(spreadsheetId, range).execute();

        return response;

    }


    public static void setValue(String SheetName, String RowStart, String RowEnd) throws IOException {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
        // Prints the names and majors of students in a sample spreadsheet:
        String spreadsheetId = "1OyDDGPtuDqdpTOQnt59cgf5WKjgb8cFHU5HyhYGFGKo";
        String range = RowStart + ":" + RowEnd;

        List<List<Object>> arrData = getData();

        ValueRange oRange = new ValueRange();
        oRange.setRange(range); // I NEED THE NUMBER OF THE LAST ROW
        oRange.setValues(arrData);

        List<ValueRange> oList = new ArrayList<>();
        oList.add(oRange);


      /*  CellData setUserEnteredValue = new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue("cell text"));

        CellFormat myFormat = new CellFormat();
        myFormat.setBackgroundColor(new Color().setRed((float) 1)); // red background
        myFormat.setTextFormat(new TextFormat().setFontSize(16)); // 16pt font

        setUserEnteredValue.setUserEnteredFormat(myFormat);*/


        BatchUpdateValuesRequest oRequest = new BatchUpdateValuesRequest();
        oRequest.setValueInputOption("RAW");
        oRequest.setData(oList);


        BatchUpdateValuesResponse oResp1 = service.spreadsheets().values()
                .batchUpdate(spreadsheetId, oRequest).execute();

        // service.spreadsheets().values().update (spreadsheetId, range,) ;
        //return request;

    }

    public static List<List<Object>> getData() {

        List<Object> data1 = new ArrayList<Object>();
        data1.add("Viank Sandesara che");

        List<List<Object>> data = new ArrayList<List<Object>>();
        data.add(data1);

        return data;
    }


    public static BatchUpdateSpreadsheetResponse HighlightRowOnceUserRegistered(String sheetId, int setStartRowIndex, int setEndRowIndex, int setStartColumnIndex, int setEndColumnIndex, int sheetIndex)
            throws IOException {
        // [START sheets_conditional_formatting]
        Sheets service = getSheetsService();


        // [START sheets_conditional_formatting]

      /*  List<GridRange> ranges = Collections.singletonList(new GridRange()
                .setSheetId(0)
                .setStartRowIndex(1)
                .setEndRowIndex(2)
                .setStartColumnIndex(0)
                .setEndColumnIndex(2)
        );*/

        List<Request> requests = Arrays.asList(

              /*  new Request().setUpdateDimensionProperties(
                        new UpdateDimensionPropertiesRequest()
                                .setRange(
                                        new DimensionRange()
                                                .setSheetId(0)
                                                .setDimension("COLUMNS")
                                                .setStartIndex(0)
                                                .setEndIndex(1)
                                )

                                .setProperties(
                                        new DimensionProperties()
                                                .setPixelSize(300))
                                .setFields("pixelSize")),

                new Request().setRepeatCell(new RepeatCellRequest()
                        .setCell(new CellData()
                                .setUserEnteredFormat(new CellFormat().setBackgroundColor(new Color()
                                        .setRed(1f)
                                        .setGreen(0.0f)
                                        .setBlue(0.0f))))
                        .setFields("userEnteredFormat.backgroundColor"))*/

              /* new Request().setRepeatCell(new RepeatCellRequest()
                        .setCell(new CellData()
                                .setUserEnteredFormat(new CellFormat().setTextFormat(
                                new TextFormat().setFontSize(36))))
                               .setFields("*"))*/


                /*  Here Row and Col always start with 0.
                    Example :

                    Note :
                    - Here If you want to stop row 3 then start row will be -1
                    - Same for Col if you want to stop at col 2 start will be -1

                           -  if i want to highlight A1 which is first row first col then it will be
                                0 (row), 1 (rowEnd), 0 (col), 1 (colEnd)
                           -  if i want to highlight A1 which is 2nd row 1st col then it will be
                                1 (row), 2 (rowEnd), 0 (col), 1 (colEnd)
                           -  if i want to highlight B3 which is 3rd row 2nd col then it will be
                                2 (row), 3 (rowEnd), 1 (col), 2 (colEnd)
                           -  If i wan to stop at E5 then it will be 3rd row and 5th col
                                2 (row), 3 (rowEnd), 1 (col), 2 (colEnd)

                        - If you want to highlight full row say 3rd to till col E5
                                2 (row), 3 (rowEnd), 0 (col), 5 (colEnd)

                 */
                new Request().setRepeatCell(new RepeatCellRequest()

                        .setRange(new GridRange().setSheetId(sheetIndex)
                                .setStartRowIndex(setStartRowIndex)
                                .setEndRowIndex(setEndRowIndex)
                                .setStartColumnIndex(setStartColumnIndex)
                                .setEndColumnIndex(setEndColumnIndex))

                        .setCell(new CellData()
                                .setUserEnteredFormat(new CellFormat().setBackgroundColor(new Color()
                                        .setRed(1f)
                                        .setGreen(0.0f)
                                        .setBlue(0.0f))))
                        .setFields("userEnteredFormat.backgroundColor"))


        );


        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest()
                .setRequests(requests);
        BatchUpdateSpreadsheetResponse result = service.spreadsheets()
                .batchUpdate(sheetId, body)
                .execute();
        System.out.printf("%d cells updated.", result.getReplies().size());
        // [END sheets_conditional_formatting]
        return result;


    }


    public static void main(String[] args) throws Exception {

       // List<List<Object>> values = GoogleSheetAPI_PostCall.getResponse("Login","A1","G1").getValues();
        // GoogleSheetAPI_PostCall.setValue("Update", "A1", "A");
        // GoogleSheetAPI_PostCall.HighlightRowOnceUserRegistered("1OyDDGPtuDqdpTOQnt59cgf5WKjgb8cFHU5HyhYGFGKo",1,2,0,8,1091307946);
        int row = 4;
        List<List<Object>> values = GoogleSheetAPI_PostCall.getResponse("Login", "A"+row+"", "G"+row+"").getValues();

        int count = values.get(0).size();

        for (List<Object> val : values) {


            System.out.println("Your values ==>>" + val.get(0));
            System.out.println("Your values ==>>" + val.get(1));
            System.out.println("Your values ==>>" + val.get(2));
        }


    }


}
