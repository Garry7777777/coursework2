package tasks;

import enums.Type;
import exceptions.IncorrectArgumentException;
import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask(Type type, String title, String dateTime, String description) throws IncorrectArgumentException {
        super(type, title, dateTime, description);
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.isEqual(getDateTime().toLocalDate()) || localDate.isAfter(getDateTime().toLocalDate()) ;
    }

}
