package exceptions;


public class TaskNotFoundException extends Throwable {
    public TaskNotFoundException(String s) {
        System.out.println( " задачи не найдено: " + s );
    }
}
