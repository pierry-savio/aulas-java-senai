package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExporterCSV {
    public static void export(List<Sell> sells, String pathFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile))){
            writer.write("ID;Product;Category;UnitValue;Quantity;TotalValue");
            writer.newLine();

            for (Sell s : sells){
                String line = String.format("%d;%s;%s;%.2f;%d;%.2f",
                        s.getId(),
                        s.getProduct(),
                        s.getCategory(),
                        s.getUnitValue(),
                        s.getQuantity(),
                        s.getTotalValue());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Arquivo CSV gerado com sucesso: " + pathFile);
        } catch (IOException e) {
            System.out.println("Eroo ao exportar CSV: " + e.getMessage());
        }
    }
}
