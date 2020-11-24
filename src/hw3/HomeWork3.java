package hw3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int userChoice = 1;
        while (userChoice == 1) {
            int attempts = 3;
            int number = random.nextInt(10);
            int userNum = 0;
            for (int i = 0; i < attempts; i++) {
                System.out.println("Угадайте число от 0 до 9. " + "Осталось попыток: " + (attempts - i));
                userNum = sc.nextInt();
                if (userNum > number) {
                    System.out.println("Загаданное число меньше.");
                } else if (userNum < number) {
                    System.out.println("Загаданное число больше.");
                } else {
                    System.out.println("Вы угадали!");
                    System.out.println("Вы выиграли!");
                    break;
                }
            }
            if (number != userNum) {
                System.out.println("Вы проиграли!");
            }
            do {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                userChoice = sc.nextInt();
            } while (userChoice > 1 || userChoice < 0);
        }

 //=============================================================================================
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println("Угадайте слово из списка:");
        int countInString = 5;
        for (int i = 0; i <= words.length / countInString; i++) {
            for (int j = i * countInString; j < countInString * (i + 1) && j < words.length; j++) {
                System.out.printf("%-15s", words[j]);
            }
            System.out.println();
        }
        String userWord = null;
        String hiddenWord = words[random.nextInt(words.length)];
        hiddenWord = hiddenWord + symbol(hiddenWord);
        while (hiddenWord != userWord) {
            userWord = sc.next();
            userWord = userWord + symbol(userWord);
            if(!userWord.equals(hiddenWord)) {
                for (int i = 0; i != hiddenWord.length(); i++) {
                    hiddenWord.charAt(i);
                    userWord.charAt(i);
                    if (hiddenWord.charAt(i) == userWord.charAt(i)) {
                        System.out.print(hiddenWord.charAt(i));
                    }else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }else {
                break;
            }
        }
        char s = '#';
        sb.append(userWord);
        for (int i = userWord.length() - 1; i > 0; i--) {
            if (userWord.charAt(i) == s) {
                sb.deleteCharAt(i);
            }
        }
        System.out.println("Вы угадали!!!");
        System.out.println("Загаданное слово - " + sb);
    }

    public static String symbol (String word) {
        String s = "#";
        for (int i = 0; i < 14 - word.length(); i++) {
            s = s + "#";
        }
        return s;
    }
}
