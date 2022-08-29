import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int maxSize = 11;
        int minSize = 5;
        int maxValue = 1000;
        int max = 0;
        int min = 0;
        int count = 0;
        double average = 0;
        Random random = new Random();

        int[][] array = new int[random.nextInt(minSize, maxSize)][random.nextInt(minSize, maxSize)];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(maxValue);
                if (max < array[i][j])
                    max = array[i][j];
                if (min > array[i][j] || (j == 0 && i == 0))
                    min = array[i][j];
                average += array[i][j];
                count++;
            }
        }
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднее значение: " + average / count);

        printMatrix(array);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

