package eu.busi.myplanning.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * The type Schedule.
 */
@Table(name = "schedules")
public class Schedule implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer day;

    @Column(nullable = false)
    private Time startHour;

    @Column(nullable = false)
    private Time endHour;

    @Column(nullable = false)
    private Boolean hasBreak;

    private Time startBreak;

    private Time endBreak;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgenda", referencedColumnName = "id")
    @JsonIgnoreProperties({"schedules"})
    private Agenda agenda;

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

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() {
        return endHour;
    }

    public void setEndHour(Time endHour) {
        this.endHour = endHour;
    }

    public Boolean getHasBreak() {
        return hasBreak;
    }

    public void setHasBreak(Boolean hasBreak) {
        this.hasBreak = hasBreak;
    }

    public Time getStartBreak() {
        return startBreak;
    }

    public void setStartBreak(Time startBreak) {
        this.startBreak = startBreak;
    }

    public Time getEndBreak() {
        return endBreak;
    }

    public void setEndBreak(Time endBreak) {
        this.endBreak = endBreak;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
