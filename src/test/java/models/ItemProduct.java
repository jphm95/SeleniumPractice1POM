package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("items")
public class ItemProduct {
    @ExcelCellName("NOMBRE")
    private String nombre;
    @ExcelCellName("PRECIO")
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
