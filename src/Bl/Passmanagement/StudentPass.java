package Bl.Passmanagement;

import Bl.Interfaces.IPass;

public class StudentPass extends Pass implements IPass {
    private String faculty;
    private String startStudyDate;
    private boolean studentStudy;

    //Конструктор класса
    public StudentPass(String firstName, String surname,  String lastName, String faculty, String startStudyDate, boolean studentStudy)
    {
        super(firstName, surname, lastName);
        this.startStudyDate = startStudyDate;
        this.faculty = faculty;
        this.studentStudy = studentStudy;

    }

    @Override
    public String toString() {
        return "Студент: " + firstName + " " + lastName +
                ", Факультет: " + faculty +
                ", Дата поступления: " + startStudyDate +
                ", Окончил: " + (studentStudy ? "Да" : "Нет");
    }

    @Override
    public String updateOrCancel() {
        return "Пропуск студента " + firstName + " " + lastName + " аннулирован";
    }

    public boolean hasGraduated() {
        return studentStudy;
    }
}
