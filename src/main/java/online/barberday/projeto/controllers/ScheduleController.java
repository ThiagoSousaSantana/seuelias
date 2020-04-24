package online.barberday.projeto.controllers;

import online.barberday.projeto.models.Schedule;
import online.barberday.projeto.services.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Schedule> insert(@RequestBody Schedule schedule) {
        Schedule schedulePersisted = service.insert(schedule);
        return ResponseEntity.ok(schedulePersisted);
    }
}
