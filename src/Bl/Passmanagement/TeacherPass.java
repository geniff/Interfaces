package Bl.Passmanagement;

import Bl.Interfaces.IPass;

//Преподавательский класс
public class TeacherPass extends Pass implements IPass {
    private String faculty;
    private String department;

//Конструктор класса
    public TeacherPass(String firstName, String lastName, String surname, String faculty, String department)
    {
        super(firstName, surname, lastName);
        this.department = department;
        this.faculty = faculty;

    }

    @Override
    public String toString() {
        return "Преподаватель: " + firstName + " " + lastName +
                ", Факультет: " + faculty +
                ", Кафедра: " + department;
    }

    @Override
    public String updateOrCancel() {
        return "Пропуск преподавателя " + firstName + " " + lastName + " успешно обновлен";
    }
}
