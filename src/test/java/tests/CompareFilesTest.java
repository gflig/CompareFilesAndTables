package tests;

import compare.CompareFiles;
import org.testng.annotations.Test;

import java.io.IOException;

public class CompareFilesTest {
    @Test
    public void compareFiles() throws IOException {
        //Set the paths of the files to compare
//        String filePath1 = "C:\\Users\\g_fli\\QA\\CompareCSVFiles\\TestCSV_1.csv";
//        String filePath2 = "C:\\Users\\g_fli\\QA\\CompareCSVFiles\\TestCSV_2.csv";

        String filePath1 = "Sales_Records_10000_1.csv";
        String filePath2 = "Sales_Records_10000_2.csv";

        CompareFiles compareFiles = new CompareFiles();
        compareFiles.compareTwoFiles(filePath1, filePath2);
    }
}
