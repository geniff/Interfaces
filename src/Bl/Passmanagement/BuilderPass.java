package Bl.Passmanagement;

import Bl.Interfaces.IPass;

public class BuilderPass extends Pass implements IPass {
    private String faculty;
    private String startDate;
    private String endDate;
    private boolean workCompleted;

    //Конструктор класса
    public BuilderPass(String firstName, String lastName, String surname, String faculty, String startDate, String endDate,
                       boolean workCompleted)
    {
        super(firstName, surname, lastName);
        this.startDate = startDate;
        this.endDate = endDate;
        this.faculty = faculty;
        this.workCompleted = workCompleted;

    }

    @Override
    public String toString() {
        return "Строитель: " + firstName + " " + lastName +
                ", Факультет: " + faculty +
                ", Период работы: " + startDate + " - " + endDate +
                ", Работа завершена: " + (workCompleted ? "Да" : "Нет");
    }

    @Override
    public String updateOrCancel() {
        return "Пропуск строителя " + firstName + " " + lastName + " аннулирован";
    }

    public boolean hasCompletedWork() {
        return workCompleted;
    }

    public void setWorkCompleted(boolean completed)
    {
        this.workCompleted = completed;
    }
}
