package services;

import exceptions.*;
import tasks.*;
import java.time.*;
import java.util.*;

public class TaskService {

    private final Map<Integer,Task> taskMap = new HashMap<>();
    private Collection<Task> removedTasks = new ArrayList<>();

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task remove(int id) throws TaskNotFoundException {
        if ( !taskMap.containsKey(id) ) throw new TaskNotFoundException( " в методе удаления ");
        return taskMap.remove(id);
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {

        var result = new ArrayList<Task>();
        for ( Map.Entry<Integer,Task> entry : taskMap.entrySet() )
            if (entry.getValue().appearsIn(localDate))
                result.add(entry.getValue());
        return result;

    }
}