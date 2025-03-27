package DAL;

import Bl.Passmanagement.Pass;
import Bl.Passmanagement.TeacherPass;
import Bl.Passmanagement.StudentPass;
import Bl.Passmanagement.BuilderPass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UniversityPassSystem {
    private List<Pass> register = new ArrayList<>();

    public void loadPassesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Предполагаем, что данные разделены запятыми
                if (parts.length < 2) {
                    System.out.println("Неверный формат строки: " + line);
                    continue; // Пропустить неверные строки
                }

                String type = parts[0].trim(); // Тип пропуска
                String name = parts[1].trim(); // Имя владельца пропуска
                Pass pass = null;

                switch (type.toLowerCase()) {
                    case "student":
                        if (parts.length < 7) {
                            System.out.println("Недостаточно данных для StudentPass: " + line);
                            continue;
                        }
                        String surname = parts[2].trim();
                        String lastName = parts[3].trim();
                        String faculty = parts[4].trim();
                        String startStudyDate = parts[5].trim();
                        boolean studentStudy = Boolean.parseBoolean(parts[6].trim());
                        pass = new StudentPass(name, surname, lastName, faculty, startStudyDate, studentStudy);
                        break;
                    case "teacher":
                        if (parts.length < 6) {
                            System.out.println("Недостаточно данных для TeacherPass: " + line);
                            continue;
                        }
                        surname = parts[2].trim();
                        lastName = parts[3].trim();
                        faculty = parts[4].trim();
                        String department = parts[5].trim();
                        pass = new TeacherPass(name, lastName, surname, faculty, department);
                        break;
                    case "builder":
                        if (parts.length < 8) {
                            System.out.println("Недостаточно данных для BuilderPass: " + line);
                            continue;
                        }
                        surname = parts[2].trim();
                        lastName = parts[3].trim(); // Добавлено
                        faculty = parts[4].trim();
                        String startDate = parts[5].trim();
                        String endDate = parts[6].trim();
                        boolean hasCompletedWork = Boolean.parseBoolean(parts[7].trim());
                        pass = new BuilderPass(name, lastName, surname, faculty, startDate, endDate, hasCompletedWork);
                        break;
                    default:
                        System.out.println("Неизвестный тип пропуска: " + type);
                        continue; // Пропустить неизвестные типы
                }

                if (pass != null) {
                    register.add(pass); // Добавляем пропуск в реестр
                }
            }
            System.out.println("Пропуска успешно загружены из файла: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public List<Pass> getRegister() {
        return register; // Возвращаем список пропусков
    }
}
