package Jenkins;

public class JenkinsParamsVariable {

    /* Jenkins run */
    public static String GoogleDriveSpreadSheetName = System.getProperty("SpreadSheetName");
    public static String GoogleDriveSpreadSheetRowNumber = System.getProperty("SheetRowNumber");
    public static String TagName = System.getProperty("TagName");

    /* Local Run
    public static String GoogleDriveSpreadSheetName = "NewUser_FL_KFL_FA_CS";
    public static String GoogleDriveSpreadSheetRowNumber = "2";
     public static String TagName = "Register_PostSSO_For_FL_KFL_FA_CS_Single_User"; */



}
