import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileScan
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if(args.length > 1)
        {
            System.out.println("File not found. Run the program again");
        }
        File selectFile;
        if(args.length == 0) {
            JFileChooser chooser = new JFileChooser("src");
            int status = chooser.showSaveDialog(null);

            if (status != JFileChooser.APPROVE_OPTION) {
                System.out.println("Select a file");
                return;
            }

            selectFile = chooser.getSelectedFile();
        }
          else {
            selectFile = new File(args[0]);

            if (!selectFile.exists()) {
                System.out.println("File not found!");
                return;
            }
        }
          Scanner reader = new Scanner(selectFile);
        int lineNum = 0;
        int wordCount = 0;
        int charCount = 0;
       String line;

        while (reader.hasNextLine())
        {
            line = reader.nextLine(); //read a line from the file. read line by line
            System.out.println(line);
            charCount += line.length();
            wordCount += line.split(" ").length;
            wordCount += line.length();
            lineNum += 1;
            System.out.printf("\nLine %4d %-50s ", lineNum, line);
        }
        reader.close();
        System.out.println("\n\nFILE SUMMARY REPORT");
        System.out.println("--------------------");
        System.out.println("File Name: " + selectFile.getName());
        System.out.println("Number of Lines: " + lineNum);
        System.out.println("Number of Words: " + wordCount);
        System.out.println("Number of Characters: " + charCount);
    }
}