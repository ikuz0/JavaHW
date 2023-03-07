

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvExport {
    public void writeResult(Toy toy){
        File file = new File("task2/DroppedToys.csv");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(toy.getToyName()+" Dropped, "+toy.getAmountRemaining()+" Remain\n");
            FileWriter fr = new FileWriter(file, true);
            fr.write(sb.toString());
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}