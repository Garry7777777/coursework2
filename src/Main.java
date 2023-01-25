import services.TaskService;
import static enums.Type.*;
import exceptions.*;
import tasks.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws TaskNotFoundException, IncorrectArgumentException {

        var yearlyTask = new YearlyTask( PERSONAL, "ежегодно", "2023-01-25", " desk ");
        var monthlyTask = new MonthlyTask( WORK, "ежемесячно", "2023-01-25", " desk ");
        var weeklyTask = new WeeklyTask( PERSONAL, "еженедельно", "2023-01-25", " desk ");
        var dailyTask = new DailyTask( WORK, "ежедневно", "2023-01-25", " desk ");
        var taskService = new TaskService();

        // добавляем
        taskService.add(yearlyTask);
        taskService.add(monthlyTask);
        taskService.add(weeklyTask);
        taskService.add(dailyTask);

        // удаляем
        if (taskService.remove(1) == null) throw new IncorrectArgumentException( " id ");

        // через неделю
        System.out.println(taskService.getAllByDate(LocalDate.parse("2023-02-01")));

        // через год
        System.out.println(taskService.getAllByDate(LocalDate.parse("2024-01-25")));
    }
}