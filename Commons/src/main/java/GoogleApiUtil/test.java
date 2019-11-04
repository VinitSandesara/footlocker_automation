package GoogleApiUtil;

import gherkin.formatter.model.Comment;
import gherkin.formatter.model.ExamplesTableRow;

import java.util.*;

public class test {

    private static String spreadsheetId = "1OyDDGPtuDqdpTOQnt59cgf5WKjgb8cFHU5HyhYGFGKo";
    private static String range = "Update!A1:C3";


    public static void main(String[] args) throws Exception {

        GoogleSheetAPI_GetCall sheetAPI = new GoogleSheetAPI_GetCall();

        List<List<Object>> RowDataFromExcel = sheetAPI.getSpreadSheetRecords(spreadsheetId, range);

        List<ExamplesTableRow> exampleRows = getDataTableRows(RowDataFromExcel);

        // Examples examples = getDataTable(exampleRows);

        String str1 = "NewUser_FS_EB,NewUser_FL_KFL_FA_CS";
        String str2 = "2,3";

        List<List<String>> FInalList = new ArrayList<List<String>>();
        List<String> listOfLists = null;
        List<String> list1;
        List<String> list2 = new ArrayList<String>();
        HashMap<String, List<String>> ParalleLKey = new HashMap<>();


        for (int i = 0; i < Arrays.asList(str1.split("\\s*,\\s*")).size(); i++) {

            listOfLists = new ArrayList<String>();

            list1 = Arrays.asList(str1.split("\\s*,\\s*"));
            list2 = Arrays.asList(str2.split("\\s*,\\s*"));

            listOfLists.add(list1.get(i));
            listOfLists.add(list2.get(i));


            FInalList.add(listOfLists);

             ParalleLKey.put("Scneario_One_"+i+"", FInalList.get(i));

        }


        System.out.println("Hello Your multi ==>>>" + FInalList);


        ParalleLKey.put("Scneario_One", FInalList.get(0));
        ParalleLKey.put("Scneario_Two", FInalList.get(1));


        System.out.println("Scenario Two Value is ==>>>" + ParalleLKey.get("Scneario_Two").get(0));


    }

    private static List<ExamplesTableRow> getDataTableRows(List<List<Object>> excelData) {
        List<ExamplesTableRow> exampleRows = new LinkedList<>();
        int line = 1;

        for (List<Object> list : excelData) {
            Comment commnet = new Comment("", line);
            ExamplesTableRow tableRow = new ExamplesTableRow(Arrays.asList(commnet), (ArrayList<String>) (ArrayList<?>) (list), line++, "");
            exampleRows.add(tableRow);
        }
        return exampleRows;
    }

   /* private Examples getDataTable(List<ExamplesTableRow> dataTableRows) {
		ParameterInfo parameterInfo = new ParameterInfo(null, null, null, null);
	    TableConverter tableConverter = new TableConverter(new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()), parameterInfo);

		Examples table = new Examples();
		return table;
	}*/

}
