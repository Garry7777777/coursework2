package tasks;

import enums.Type;
import exceptions.IncorrectArgumentException;
import java.time.LocalDate;

public class OneTimeTask extends Task {
    public OneTimeTask(Type type, String title, String dateTime, String description) throws IncorrectArgumentException {
        super(type, title, dateTime, description);
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.isEqual(getDateTime().toLocalDate()) ;
    }

}
