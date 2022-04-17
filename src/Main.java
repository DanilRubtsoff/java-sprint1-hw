import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker myTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                boolean isCorrect;
                Integer month;
                Integer day;
                Integer steps;

                do {
                    System.out.println("Введите месяц числом от 1 до 12: " + "\n");
                    month = scanner.nextInt();
                    isCorrect = myTracker.checkUserMonth(month);
                } while (!isCorrect);

                do {
                    System.out.println("Введите день месяца за который вводите пройденное число шагов от 1 до 30: " + "\n");
                    day = scanner.nextInt();
                    isCorrect = myTracker.checkUserDay(day);
                } while (!isCorrect);

                do {
                    System.out.println("Введите целое число шагов: " + "\n");
                    steps = scanner.nextInt();
                    isCorrect = myTracker.checkUserSteps(steps);
                } while (!isCorrect);

                myTracker.inputUserdata(month, day, steps);

            } else if (command == 2) {
                boolean isCorrect;
                Integer month;

                do {
                    System.out.println("Введите месяц числом от 1 до 12: " + "\n");
                    month = scanner.nextInt();
                    isCorrect = myTracker.checkUserMonth(month);
                } while (!isCorrect);

                myTracker.monthUserStatistic(month);

            } else if (command == 3) {
                System.out.println("Введите целевое число шагов в день: " + "\n");
                Integer userData = scanner.nextInt();
                myTracker.setAimStepNumber(userData);
                System.out.println("Новая цель по количеству шагов в день: " + myTracker.aimStepNumber + "\n");

            } else if (command == 4) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет." + "\n");
            }

        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }

}//public class Main



