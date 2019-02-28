package ru.academit.mikhajlov.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvConverter {
    public static void main(String[] args) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("table.html");
             Scanner scanner = new Scanner(new FileInputStream("РазборCSV.csv"), "windows-1251")) {
            writer.println("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>HTML table</title></head><body><table border=\"1\">");
            if (scanner.hasNextLine()) {
                writer.print("<tr><td>");
            }
            int quotesCount = 0;
            boolean isInQuotes;
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                for (int i = 0; i <= row.length() - 1; i++) {
                    if (row.charAt(i) == '>') {
                        writer.print("&gt");
                        continue;
                    } else if (row.charAt(i) == '<') {
                        writer.print("&lt");
                        continue;
                    } else if (row.charAt(i) == '&') {
                        writer.print("&amp");
                        continue;
                    }
                    if (row.charAt(i) == '"') {
                        ++quotesCount;
                    }
                    isInQuotes = quotesCount % 2 != 0;
                    if (!isInQuotes) {
                        if (row.charAt(i) == '"') {
                            continue;
                        }
                        if (row.charAt(i) == ',') {
                            writer.println("</td><td>");
                        } else {
                            writer.print(row.charAt(i));
                        }
                        if (i == row.length() - 1) {
                            writer.println("</td></tr><tr><td>");
                        }
                    } else {
                        if (i == 0) {
                            writer.print("<br/>");
                        }
                        if (row.charAt(i) == '"') {
                            if (i != 0 && row.charAt(i - 1) != ',') {
                                writer.print("\"");
                            }
                        } else if (row.charAt(i) == ',') {
                            writer.print(",");
                        } else {
                            writer.print(row.charAt(i));
                        }
                    }
                }
            }
            if (!scanner.hasNextLine()) {
                writer.println("</tr></table></body></html>");
            }
        }
    }
}


