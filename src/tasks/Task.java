package tasks;

import enums.Type;
import exceptions.*;
import java.time.*;
import java.util.Objects;

public abstract class Task {

    private static int idGenerator;
    private String title;
    private final Type type;
    private final int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(Type type, String title,  String dateTime,  String description) throws IncorrectArgumentException {
        this.id = idGenerator++;
        this.type = type;
        setTitle(title);
        this.dateTime = LocalDateTime.parse(LocalDate.parse(dateTime)+ "T00:00");
        setDescription(description);
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if(title == null || title.isEmpty() || title.isBlank())
            throw new IncorrectArgumentException( " title ");
        else this.title = title;
    }
    public void setDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.isEmpty() || description.isBlank())
            throw new IncorrectArgumentException( " description ");
        else  this.description = description;
    }
    public Integer getId() {return id;}
    public Type getType() {return type;}
    public String getTitle() { return title; }
    public String getDescription()  { return description; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) {this.dateTime = dateTime;}
    public abstract boolean appearsIn(LocalDate localDate);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return id == ((Task) o).id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

}
