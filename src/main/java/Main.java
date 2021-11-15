//The Life
//Made by Igor Suvorov

import java.util.Random;

public class Main {
    private static final String ALIVE = "X";
    private static final String DEAD = "O";

    public static void main(String[] args) {

        String[][] field = new String[10][10];

        fillInField(field);

        System.out.println("Start field: ");
        printArrayOfStrings(field);

        playTheLife(field, new Random().nextInt(19) + 1);

    }

    static void printArrayOfStrings(String[][] array) {
        for (String[] row:
             array) {
            for (String cell:
                 row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void fillInField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = new Random().nextBoolean() ? ALIVE : DEAD;
            }
        }
    }

    static void playTheLife(String[][] field, int stepsCount) {

        System.out.println("Steps count: " + stepsCount);

        for (int i = 0; i < stepsCount; i++) {

            field = makeOneStep(field);
            System.out.println("Step № " + (i+1) + ":");
            printArrayOfStrings(field);

        }
    }

    static String[][] makeOneStep(String[][] field) {
        String[][] resultField = new String[field.length][field.length];

        for (int j = 0; j < resultField.length; j++) {
            for (int k = 0; k < resultField.length; k++) {

                int aliveCellsAround = countAliveCellsAround(field, j, k);
                if (field[j][k].equals(ALIVE) & aliveCellsAround >= 2 & aliveCellsAround <=3) {
                    resultField[j][k] = ALIVE;
                } else if (field[j][k].equals(DEAD) & aliveCellsAround == 3) {
                    resultField[j][k] = ALIVE;
                } else {
                    resultField[j][k] = DEAD;
                }

            }
        }

        return resultField;
    }

    static int countAliveCellsAround(String[][] field, int j, int k) {

        int aliveCellsCount = 0;
        int rowIndexBuffer;
        int cellIndexBuffer;

        for (int m = -1; m <= 1; m++) {

            if (j + m < 0) rowIndexBuffer = field.length - 1;
            else if (j + m > field.length - 1) rowIndexBuffer = 0;
            else rowIndexBuffer = j + m;

            for (int n = -1; n <= 1; n++) {

                if (k + n < 0) cellIndexBuffer = field.length - 1;
                else if (k + n > field.length - 1) cellIndexBuffer = 0;
                else cellIndexBuffer = k + n;

                if (field[rowIndexBuffer][cellIndexBuffer].equals(ALIVE) & !(m == 0 & n == 0)) {
                    aliveCellsCount = aliveCellsCount + 1;
                }

            }
        }

    return aliveCellsCount;
    }

}
