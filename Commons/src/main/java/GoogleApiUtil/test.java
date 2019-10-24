package GoogleApiUtil;

import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.model.Comment;
import gherkin.formatter.model.Examples;
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
