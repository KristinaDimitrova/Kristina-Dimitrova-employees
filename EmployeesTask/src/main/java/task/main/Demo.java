package task.main;

import task.find.Searcher;
import task.find.TextParser;
import java.io.File;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert the path to the file!");
        // in this case "employees.txt"
        String fileName = scanner.nextLine();
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("File does not exist!");
        } else {
            Searcher.findTeamLongestWorkedTogether(TextParser.parse(f));
        }
    }
}
