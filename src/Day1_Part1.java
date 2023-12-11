import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class Day1_Part1 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("input_day1.txt");
        Stream<String> lines = Files.lines(path);
        int sum = lines.mapToInt(line -> getNumber(line)).sum();
        System.out.println("Sum of calibration values: " + sum);
        lines.close();
    }

    public static int getNumber(String line) {
        String str = line.replaceAll("[^\\d]", "");
        int len = str.length();
        if (len == 1) {
            str += str;
        } else if (len > 2) {
            str = "" + str.charAt(0) + str.charAt(len - 1);
        }
        return Integer.parseInt(str);
    }
}
