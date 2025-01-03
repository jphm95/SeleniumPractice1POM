package data;

import com.poiji.bind.Poiji;
import models.ErrorMessageExcel;
import models.ItemProduct;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private static final String excelPath = "src/test/resources/data/dataExcel.xlsx";

    public static List<ItemProduct> readItemListProductExcel() {
        return Poiji.fromExcel(new File(excelPath), ItemProduct.class);
    }

    public static List<ErrorMessageExcel> readErrorMessagesExcel() {
        return Poiji.fromExcel(new File(excelPath), ErrorMessageExcel.class);
    }
}
