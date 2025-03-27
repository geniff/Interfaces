package Bl;

import Bl.Passmanagement.BuilderPass;
import Bl.Passmanagement.StudentPass;
import Bl.Passmanagement.TeacherPass;
import DAL.UniversityPassSystem;
import Bl.Passmanagement.Pass;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UniversityPassSystem passSystem = new UniversityPassSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Пропуски для прохода в университет");
            System.out.println("1. Загрузить пропуска из файла");
            System.out.println("2. Вывести информацию о пропусках");
            System.out.println("3. Вывести пропуска, которые должны быть аннулированы");
            System.out.println("4. Вывести пропуска, которые должны быть обновлены");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите путь к файлу: ");
                    String filePath = scanner.nextLine();
                    passSystem.loadPassesFromFile(filePath);
                    System.out.println("Пропуска успешно загружены.");
                    break;
                case 2:
                    List<Pass> passes = passSystem.getRegister();
                    for (Pass pass : passes) {
                        System.out.println(pass);  // Автоматически вызовется pass.toString()
                    }
                    break;
                case 3:
                    passes = passSystem.getRegister();
                    System.out.println("Пропуска, которые должны быть аннулированы:");
                    for (Pass pass : passes) {
                        if (pass instanceof StudentPass && ((StudentPass) pass).hasGraduated()) {
                            System.out.println(pass);
                        } else if (pass instanceof BuilderPass && ((BuilderPass) pass).hasCompletedWork()) {
                            System.out.println(pass);
                        }
                    }
                    break;
                case 4:
                    passes = passSystem.getRegister();
                    System.out.println("Пропуска, которые должны быть обновлены:");
                    for (Pass pass : passes) {
                        if (pass instanceof TeacherPass) {
                            System.out.println(pass);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неправильный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
