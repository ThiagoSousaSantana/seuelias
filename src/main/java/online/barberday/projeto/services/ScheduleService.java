package online.barberday.projeto.services;

import online.barberday.projeto.models.Schedule;
import online.barberday.projeto.repositories.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@Service
public class ScheduleService {

    private final ScheduleRepository repository;

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule insert(Schedule newSchedule) {
        newSchedule.setId(null);
        validateSchedule(newSchedule);
        return repository.save(newSchedule);
    }

    private void validateSchedule(Schedule schedule) {
        if (schedule.getDateTime().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Horário não pode ser menor que o horário atual");
        }

        var exists =  repository.existsByBarberAndDateTimeAfterAndDateTimeBefore(schedule.getBarber(),
                schedule.getDateTime().minusMinutes(40),
                schedule.getDateTime().plusMinutes(40));

        if (exists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Horário indisponivel");
        }
    }
}
