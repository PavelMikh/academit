package ru.academit.mikhajlov.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvConverter {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Передано аргументов: " + args.length);
            System.out.println("Нужно ввести два аргумента: имя создаваемого файла и путь к входному файлу.");
        } else {
            try (PrintWriter writer = new PrintWriter(args[0]);
                 Scanner scanner = new Scanner(new FileInputStream(args[1]), "windows-1251")) {
                writer.println("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>HTML table</title></head><body><table border=\"1\">");
                if (scanner.hasNextLine()) {
                    writer.print("<tr><td>");
                }

                int quotesCount = 0;
                boolean isInQuotes;
                while (scanner.hasNextLine()) {
                    String row = scanner.nextLine();
                    for (int i = 0; i < row.length(); i++) {
                        char currentChar = row.charAt(i);

                        if (currentChar == '>') {
                            writer.print("&gt;");
                            continue;
                        } else if (currentChar == '<') {
                            writer.print("&lt;");
                            continue;
                        } else if (currentChar == '&') {
                            writer.print("&amp;");
                            continue;
                        }
                        if (currentChar == '"') {
                            ++quotesCount;
                        }

                        isInQuotes = quotesCount % 2 != 0;
                        if (!isInQuotes) {
                            if (currentChar == '"') {
                                continue;
                            }
                            if (currentChar == ',') {
                                writer.println("</td><td>");
                            } else {
                                writer.print(currentChar);
                            }
                            if (i == row.length() - 1) {
                                writer.println("</td></tr><tr><td>");
                            }
                        } else {
                            if (i == 0) {
                                writer.print("<br/>");
                            }
                            if (currentChar == '"') {
                                if (i != 0 && row.charAt(i - 1) != ',') {
                                    writer.print("\"");
                                }
                            } else if (currentChar == ',') {
                                writer.print(",");
                            } else {
                                writer.print(currentChar);
                            }
                        }
                    }
                }
                writer.println("</td></tr></table></body></html>");
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден.");
                throw e;
            }
        }
    }
}

