package online.barberday.projeto.repositories;

import online.barberday.projeto.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    boolean existsByBarberAndDateTimeAfterAndDateTimeBefore(String barber, LocalDateTime after, LocalDateTime before);
}
