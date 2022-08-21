package compare;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CompareFiles {
    private ArrayList<String> createArrayList(String filePath) throws IOException {
        //Define new Array List
        ArrayList<String> arrayList = new ArrayList();
        BufferedReader csvFile = new BufferedReader(new FileReader(filePath));
        String dataRow;
        while ((dataRow = csvFile.readLine()) != null) {
            arrayList.add(dataRow);
        }
        return arrayList;
    }

    private boolean compareData(ArrayList<String> arrayList1, ArrayList<String> arrayList2, String filePath) {
        boolean comparisonResult = true;
        for (String s : arrayList2) {
            if (!arrayList1.contains(s)) {
                System.out.println("Not in " + filePath + ": " + s);
                comparisonResult = false;
            }
        }
        return comparisonResult;
    }

    public void compareTwoFiles(String filePath1, String filePath2) throws IOException {
        ArrayList<String> arrayList1 = new ArrayList();
        arrayList1 = createArrayList(filePath1);

        ArrayList<String> arrayList2 = new ArrayList();
        arrayList2 = createArrayList(filePath2);

        boolean comparisonResult1 = compareData(arrayList1, arrayList2, filePath1);
        boolean comparisonResult2 = compareData(arrayList2, arrayList1, filePath2);

        String assertMessage;
        String expectedMessage = "Files are identical";
        if (!comparisonResult1 || !comparisonResult2) {
            assertMessage = "Files are NOT identical";

        } else {
            assertMessage = "Files are identical";
        }
        Assert.assertEquals(assertMessage, expectedMessage, assertMessage);
    }
}
