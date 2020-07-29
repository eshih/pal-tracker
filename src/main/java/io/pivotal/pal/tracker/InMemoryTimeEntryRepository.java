package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();
    long idCount = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(idCount);
        timeEntryMap.put(idCount, timeEntry);
        idCount++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        if(timeEntryMap.get(id) != null){
            return timeEntryMap.get(id);
        }
        return null;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntryMap.replace(id, timeEntry);
        return timeEntryMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> list = timeEntryMap.values().stream()
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void delete(long id) {
        timeEntryMap.remove(id);
    }


}
