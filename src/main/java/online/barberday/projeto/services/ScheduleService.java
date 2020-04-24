package online.barberday.projeto.services;

import online.barberday.projeto.models.Schedule;
import online.barberday.projeto.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final ScheduleRepository repository;

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule insert(Schedule schedule) {
        schedule.setId(null);
        return repository.save(schedule);
    }
}
