package eu.busi.myplanning.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.threeten.bp.OffsetDateTime;

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
    private OffsetDateTime startHour;

    @Column(nullable = false)
    private OffsetDateTime endHour;

    @Column(nullable = false)
    private Boolean hasBreak;

    private OffsetDateTime startBreak;

    private OffsetDateTime endBreak;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgenda", referencedColumnName = "id")
    @JsonIgnoreProperties({"schedules"})
    private Agenda agenda;

    public Schedule() {
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

    public OffsetDateTime getStartHour() {
        return startHour;
    }

    public void setStartHour(OffsetDateTime startHour) {
        this.startHour = startHour;
    }

    public OffsetDateTime getEndHour() {
        return endHour;
    }

    public void setEndHour(OffsetDateTime endHour) {
        this.endHour = endHour;
    }

    public Boolean getHasBreak() {
        return hasBreak;
    }

    public void setHasBreak(Boolean hasBreak) {
        this.hasBreak = hasBreak;
    }

    public OffsetDateTime getStartBreak() {
        return startBreak;
    }

    public void setStartBreak(OffsetDateTime startBreak) {
        this.startBreak = startBreak;
    }

    public OffsetDateTime getEndBreak() {
        return endBreak;
    }

    public void setEndBreak(OffsetDateTime endBreak) {
        this.endBreak = endBreak;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
