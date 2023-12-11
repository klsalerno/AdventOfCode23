import java.io.*;
import java.util.*;

public class Day2_Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("../input_day2.txt");
        Scanner scanner = new Scanner(f);
        int redCount = 12;
        int greenCount = 13;
        int blueCount = 14;
        int sum_of_ids = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(": ");
            int game_id = Integer.parseInt(parts[0].substring(5)); // Extract game ID
            String[] subsets = parts[1].split("; "); // Extract subsets of cubes

            if (isPossible(subsets, redCount, greenCount, blueCount)) {
                sum_of_ids += game_id;
            }
        }
        System.out.println("Sum of possible game IDs: " + sum_of_ids);
    }

    public static boolean isPossible(String[] pulls, int red_count, int green_count, int blue_count) {
        for (String pull : pulls) {
            String[] cubeCounts = pull.split(", ");
            int red = 0, green = 0, blue = 0;
            for (String cubeCount : cubeCounts) {
                int count = Integer.parseInt(cubeCount.substring(0, cubeCount.indexOf(' ')));
                String color = cubeCount.substring(cubeCount.indexOf(' ') + 1);
                switch (color) {
                    case "red":
                        red += count;
                        break;
                    case "green":
                        green += count;
                        break;
                    case "blue":
                        blue += count;
                        break;
                }
            }
            if (red > red_count || green > green_count || blue > blue_count) {
                return false;
            }
        }
        return true;
    }
}
