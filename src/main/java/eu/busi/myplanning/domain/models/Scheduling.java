package eu.busi.myplanning.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
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

    /**
     * Instantiates a new Scheduling.
     */
    public Scheduling() {
    }

    /**
     * Gets id
     * @return
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Sets id
     * @param id the id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public Integer getDay() {
        return day;
    }

    /**
     * Sets day.
     *
     * @param day the day
     */
    public void setDay(Integer day) {
        this.day = day;
    }

    /**
     * Gets start hour.
     *
     * @return the start hour
     */
    public Time getStartHour() {
        return startHour;
    }

    /**
     * Sets start hour.
     *
     * @param startHour the start hour
     */
    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    /**
     * Gets end hour.
     *
     * @return the end hour
     */
    public Time getEndHour() {
        return endHour;
    }

    /**
     * Sets end hour.
     *
     * @param endHour the end hour
     */
    public void setEndHour(Time endHour) {
        this.endHour = endHour;
    }

    /**
     * Gets has break.
     *
     * @return the has break
     */
    public Boolean getHasBreak() {
        return hasBreak;
    }

    /**
     * Sets has break.
     *
     * @param hasBreak the has break
     */
    public void setHasBreak(Boolean hasBreak) {
        this.hasBreak = hasBreak;
    }

    /**
     * Gets start break.
     *
     * @return the start break
     */
    public Time getStartBreak() {
        return startBreak;
    }

    /**
     * Sets start break.
     *
     * @param startBreak the start break
     */
    public void setStartBreak(Time startBreak) {
        this.startBreak = startBreak;
    }

    /**
     * Gets end break.
     *
     * @return the end break
     */
    public Time getEndBreak() {
        return endBreak;
    }

    /**
     * Sets end break.
     *
     * @param endBreak the end break
     */
    public void setEndBreak(Time endBreak) {
        this.endBreak = endBreak;
    }

    /**
     * Gets agenda.
     *
     * @return the agenda
     */
    public Agenda getAgenda() {
        return agenda;
    }

    /**
     * Sets agenda.
     *
     * @param agenda the agenda
     */
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
