package task.find;

import task.find.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextParser {

    static public ArrayList<Row> parse(File file){
        ArrayList<Row> rows = new ArrayList<>();
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] temp= line.split(", ");
                Row row = new Row(temp[0], temp[1], temp[2], temp[3]);
                rows.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
