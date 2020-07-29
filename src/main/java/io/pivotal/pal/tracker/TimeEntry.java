package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;
//    private static final long serialVersionUID = 1L;

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.id = 1L;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this(projectId, userId, date, hours);
        this.id = timeEntryId;
    }

    public TimeEntry() {

    }

    public TimeEntry(TimeEntry timeEntry) {
        this(timeEntry.id, timeEntry.projectId, timeEntry.userId, timeEntry.date, timeEntry.hours);
    }

    public long getId() {
        return this.id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return getId() == timeEntry.getId() &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                date.equals(timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), projectId, userId, date, hours);
    }
}
