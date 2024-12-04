import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");

        Scanner scanner = new Scanner(file);

        String[][] matrix = new String[140][140];

        int lineCount = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            matrix[lineCount++] = line.split("");
        }
        scanner.close();

        int sumA1 = 0;
        int sumA2 = 0;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                if (x+3 >= matrix[y].length) {
                    continue;
                }

                String c1 = matrix[y][x];
                String c2 = matrix[y][x+1];
                String c3 = matrix[y][x+2];
                String c4 = matrix[y][x+3];

                if ((c1 + c2 + c3 + c4).equals("XMAS")){
                    sumA1++;
                }
                if ((c1 + c2 + c3 + c4).equals("SAMX")){
                    sumA1++;
                }
            }

            for (int x = 0; x < matrix.length; x++) {
                if (y+3 >= matrix[y].length) {
                    continue;
                }

                String c1 = matrix[y][x];
                String c2 = matrix[y+1][x];
                String c3 = matrix[y+2][x];
                String c4 = matrix[y+3][x];

                if ((c1 + c2 + c3 + c4).equals("XMAS")){
                    sumA1++;
                }
                if ((c1 + c2 + c3 + c4).equals("SAMX")){
                    sumA1++;
                }
            }
            for (int x = 0; x < matrix.length; x++) {
                if (y+3 >= matrix[y].length || x+3 >= matrix[y].length) {
                    continue;
                }

                String c1 = matrix[y][x];
                String c2 = matrix[y+1][x+1];
                String c3 = matrix[y+2][x+2];
                String c4 = matrix[y+3][x+3];

                if ((c1 + c2 + c3 + c4).equals("XMAS")){
                    sumA1++;
                }
                if ((c1 + c2 + c3 + c4).equals("SAMX")){
                    sumA1++;
                }
            }

            for (int x = 0; x < matrix.length; x++) {
                if (y+3 >= matrix.length || x-3 < 0) {
                    continue;
                }

                String c1 = matrix[y][x];
                String c2 = matrix[y+1][x-1];
                String c3 = matrix[y+2][x-2];
                String c4 = matrix[y+3][x-3];

                if ((c1 + c2 + c3 + c4).equals("XMAS")){
                    sumA1++;
                }
                if ((c1 + c2 + c3 + c4).equals("SAMX")){
                    sumA1++;
                }
            }

            for (int x = 0; x < matrix.length; x++) {
                if (y+2 >= matrix.length || x+2 >= matrix.length) {
                    continue;
                }

                String c1 = matrix[y][x];
                String c2 = matrix[y+1][x+1];
                String c3 = matrix[y+2][x+2];

                String d1 = matrix[y][x+2];
                String d2 = matrix[y+1][x+1];
                String d3 = matrix[y+2][x];

                if ((c1 + c2 + c3).equals("MAS") && (d1 + d2 + d3).equals("MAS")){
                    sumA2++;
                }
                if ((c1 + c2 + c3).equals("SAM") && (d1 + d2 + d3).equals("SAM")){
                    sumA2++;
                }
                if ((c1 + c2 + c3).equals("MAS") && (d1 + d2 + d3).equals("SAM")){
                    sumA2++;
                }
                if ((c1 + c2 + c3).equals("SAM") && (d1 + d2 + d3).equals("MAS")){
                    sumA2++;
                }
            }
        }

        System.out.println("Answer1: " + sumA1);
        System.out.println("Answer2: " + sumA2);
    }
}