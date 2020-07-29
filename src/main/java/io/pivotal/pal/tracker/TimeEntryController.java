package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("time-entries")
public class TimeEntryController {
    private  TimeEntryRepository repo;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        repo = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry entry = repo.create(timeEntryToCreate);
        return new ResponseEntity<>(
                entry,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        TimeEntry entry = repo.find(timeEntryId);
        if(entry != null) {
            return new ResponseEntity<>(
                    entry,
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(
                null,
                HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(
                repo.list(),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {
            TimeEntry entry = repo.update(timeEntryId, expected);
            if(entry != null) {
                return new ResponseEntity<>(
                        entry,
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long timeEntryId) {
        repo.delete(timeEntryId);
        return new ResponseEntity<>(
                null,
                HttpStatus.NO_CONTENT);
    }
}
