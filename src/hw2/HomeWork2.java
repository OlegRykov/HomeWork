package hw2;

import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {
    static Random random = new Random();
    public static void main(String[] args) {

        replacingNumbers();

        fillArray();

        lessThan6();

        fillDiagonals();

        minAndMax();

        System.out.println(checkBalance());

        shiftNumbers(-2);
    }

    public static void replacingNumbers() {
        int [] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray () {
        int [] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = 0;
            } else {
                arr[i] =3 * i;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void lessThan6 () {
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = 2 * arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonals () {
        int [][] doubleArr = new int[6][6];
        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[i].length; j++) {
                if (i == j || i + j == 5) {
                    doubleArr[i][j] = 1;
                }
                System.out.printf("%-3s", doubleArr[i][j]);
            }
            System.out.println();
        }
    }

    public static void minAndMax () {
        int [] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            } else if ( min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Минимальное число - " + min);
        System.out.println("Максимальное число - " + max);
    }

    public static boolean checkBalance() {
        int [] arr = {2, 2, 2, 1, 2, 2, 10, 1};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            sum = sum + arr[i];
        }
        System.out.println();
        int left = 0;
        int right = sum;
        for (int i = 0; i < arr.length; i++) {
            left = left + arr[i];
            right = right - arr[i];
            if (left == right) {
                return left == right;
            }
        }
        return false;
    }

    public static void shiftNumbers(int n) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int firsElement = arr[0];
        int lastElement = arr[arr.length - 1];
        if(n > 0) {
            while (n != 0) {
                for (int i = arr.length - 2; i >= 0; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[0] = lastElement;
                lastElement = arr.length - 1;
                n--;
            }
        }else if(n < 0) {
            while (n != 0) {
                for (int i = 1; i < arr.length ; i++) {
                    arr[i - 1] = arr[i];
                }
                arr[arr.length - 1] = firsElement;
                firsElement = arr[0];
                n++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
