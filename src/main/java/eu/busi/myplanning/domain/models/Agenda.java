package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Agenda.
 */
@Entity
@Table(name = "agendas")
public class Agenda implements AbstractEntity<Long>, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean byDefault = false;

    @Column(length = 60)
    private String name;

    private String color = "#1ed4d4";

    /**
     * owner of the agenda
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    @JsonIgnoreProperties({"sharedAgendas", "agenda", "agendas"})
    private UserEntity user;

    /**
     * team owner of the agenda
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTeam", referencedColumnName = "id")
    @JsonIgnoreProperties({"sharedAgendas", "agenda", "agendas"})
    private Team team;

    /**
     * shared users of this agenda
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teams_or_users_shared_agendas",
            joinColumns = @JoinColumn(name = "idAgenda"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))
    @JsonIgnoreProperties({"sharedAgendas", "agenda", "agendas"})
    List<UserEntity> sharedUsers = null;
    /**
     * shared teams of this agenda
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teams_or_users_shared_agendas",
            joinColumns = @JoinColumn(name = "idAgenda", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "idTeam", nullable = true))
    @JsonIgnoreProperties({"sharedAgendas", "agenda", "agendas"})
    List<Team> sharedTeams = null;
    /**
     * events linked to the agenda
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agenda", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"sharedAgendas", "agenda", "agendas"})
    private List<Event> events = new ArrayList<>();
    /**
     * shared events of this agenda
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "agendas_has_shared_events",
            joinColumns = @JoinColumn(name = "idAgenda"),
            inverseJoinColumns = @JoinColumn(name = "idEvent"))
    @JsonIgnoreProperties({"sharedAgendas", "agenda", "agendas"})
    private List<Event> sharedEvents = new ArrayList<>();

    public Agenda() {
    }

    public static Agenda defaultAgenda() {
        Agenda defaultAgenda = new Agenda();

        defaultAgenda.setName("APP.AGENDA.DEFAULT_NAME");
        defaultAgenda.setByDefault(true);
        defaultAgenda.setColor("#1ed4d4");

        return defaultAgenda;
    }

    @Override
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

    public Boolean getByDefault() {
        return byDefault;
    }

    public void setByDefault(Boolean byDefault) {
        this.byDefault = byDefault;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     * Gets team.
     *
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Gets events.
     *
     * @return the events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * Gets shared events.
     *
     * @return the shared events
     */
    public List<Event> getSharedEvents() {
        return sharedEvents;
    }

    /**
     * Sets shared events.
     *
     * @param sharedEvents the shared events
     */
    public void setSharedEvents(List<Event> sharedEvents) {
        this.sharedEvents = sharedEvents;
    }

    /**
     * Gets shared users.
     *
     * @return the shared users
     */
    public List<UserEntity> getSharedUsers() {
        return sharedUsers;
    }

    /**
     * Sets shared users.
     *
     * @param sharedUsers the shared users
     */
    public void setSharedUsers(List<UserEntity> sharedUsers) {
        this.sharedUsers = sharedUsers;
    }

    /**
     * Gets shared teams.
     *
     * @return the shared teams
     */
    public List<Team> getSharedTeams() {
        return sharedTeams;
    }

    /**
     * Sets shared teams.
     *
     * @param sharedTeams the shared teams
     */
    public void setSharedTeams(List<Team> sharedTeams) {
        this.sharedTeams = sharedTeams;
    }
}
