package eu.busi.myplanning.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Schedule.
 */
@Table(name = "schedules")
public class Scheduling implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer day;

    @Column(nullable = false)
    private LocalDateTime startHour;

    @Column(nullable = false)
    private LocalDateTime endHour;

    @Column(nullable = false)
    private Boolean hasBreak;

    private LocalDateTime startBreak;

    private LocalDateTime endBreak;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgenda", referencedColumnName = "id")
    @JsonIgnoreProperties({"schedules"})
    private Agenda agenda;

    public Scheduling() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalDateTime startHour) {
        this.startHour = startHour;
    }

    public LocalDateTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalDateTime endHour) {
        this.endHour = endHour;
    }

    public Boolean getHasBreak() {
        return hasBreak;
    }

    public void setHasBreak(Boolean hasBreak) {
        this.hasBreak = hasBreak;
    }

    public LocalDateTime getStartBreak() {
        return startBreak;
    }

    public void setStartBreak(LocalDateTime startBreak) {
        this.startBreak = startBreak;
    }

    public LocalDateTime getEndBreak() {
        return endBreak;
    }

    public void setEndBreak(LocalDateTime endBreak) {
        this.endBreak = endBreak;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
