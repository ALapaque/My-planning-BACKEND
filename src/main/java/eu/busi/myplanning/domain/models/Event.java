package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.busi.myplanning.domain.dto.EventStatus;
import eu.busi.myplanning.domain.dto.EventType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Event.
 */
@Entity
@Table(name = "events")
public class Event extends DateAudit implements AbstractEntity<Long>, Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "is_a_day_off")
    private boolean dayOff = false;

    @Column(nullable = false, name = "is_private")
    private boolean privateEvent = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus statusDisplayed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    private Instant startDate;

    @Column(nullable = false)
    private Instant endDate;

    private String meetingUrl;

    private String report;

    /**
     * comments linked to this event
     */
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("comments")
    private List<Comment> comments = new ArrayList<>();

    /**
     * agenda linked to this event
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAgenda", referencedColumnName = "id")
    @JsonIgnoreProperties({"sharedEvents", "events"})
    private Agenda agenda;

    /**
     * shared events of this agenda
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "agendas_has_shared_events",
            joinColumns = @JoinColumn(name = "idEvent"),
            inverseJoinColumns = @JoinColumn(name = "idAgenda"))
    @JsonIgnoreProperties({"sharedEvents", "events"})
    private List<Agenda> sharedAgendas = new LinkedList<>();

    public Event() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Is a day off boolean.
     *
     * @return the boolean
     */
    public boolean isDayOff() {
        return dayOff;
    }

    /**
     * Sets a day off.
     *
     * @param dayOff the a day off
     */
    public void setDayOff(boolean dayOff) {
        this.dayOff = dayOff;
    }

    /**
     * Is private boolean.
     *
     * @return the boolean
     */
    public boolean isPrivateEvent() {
        return privateEvent;
    }

    /**
     * Sets private.
     *
     * @param privateEvent the a private
     */
    public void setPrivateEvent(boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public EventStatus getStatusDisplayed() {
        return statusDisplayed;
    }

    public void setStatusDisplayed(EventStatus statusDisplayed) {
        this.statusDisplayed = statusDisplayed;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets meeting url.
     *
     * @return the meeting url
     */
    public String getMeetingUrl() {
        return meetingUrl;
    }

    /**
     * Sets meeting url.
     *
     * @param meetingUrl the meeting url
     */
    public void setMeetingUrl(String meetingUrl) {
        this.meetingUrl = meetingUrl;
    }

    /**
     * Gets report.
     *
     * @return the report
     */
    public String getReport() {
        return report;
    }

    /**
     * Sets report.
     *
     * @param report the report
     */
    public void setReport(String report) {
        this.report = report;
    }

    /**
     * Gets comments.
     *
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets comments.
     *
     * @param comments the comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public List<Agenda> getSharedAgendas() {
        return sharedAgendas;
    }

    public void setSharedAgendas(List<Agenda> sharedAgendas) {
        this.sharedAgendas = sharedAgendas;
    }
}
