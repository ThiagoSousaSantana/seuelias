package online.barberday.projeto.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String branch;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "SERVICE")
    private List<String> services;
    private String barber;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", branch='" + branch + '\'' +
                ", services=" + services +
                ", barber='" + barber + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(branch, schedule.branch) &&
                Objects.equals(barber, schedule.barber) &&
                Objects.equals(dateTime, schedule.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branch, barber, dateTime);
    }
}
