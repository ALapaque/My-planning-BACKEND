package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Team.
 */
@Table(name = "teams")
@Entity
public class Team implements AbstractEntity<Long>, Serializable {
    private final static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    /**
     * contains the agendas of the team
     */
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties({"team", "sharedTeams"})
    private List<Agenda> agendas = new ArrayList<>();

    /**
     * contains the users of the team
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "users_has_teams",
            joinColumns = @JoinColumn(name = "idTeam"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))
    @JsonIgnoreProperties("teams")
    private List<UserEntity> users = new ArrayList<>();

    /**
     * contains the agendas shared to the team
     */
    @ManyToMany(mappedBy = "sharedTeams", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"team", "sharedTeams"})
    private List<Agenda> sharedAgendas = new ArrayList<>();

    /**
     * Instantiates a new Team.
     */
    public Team() {
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
     * Gets agendas.
     *
     * @return the agendas
     */
    public List<Agenda> getAgendas() {
        return agendas;
    }

    /**
     * Sets agendas.
     *
     * @param agendas the agendas
     */
    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<UserEntity> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    /**
     * Gets shared agendas.
     *
     * @return the shared agendas
     */
    public List<Agenda> getSharedAgendas() {
        return sharedAgendas;
    }

    /**
     * Sets shared agendas.
     *
     * @param sharedAgendas the shared agendas
     */
    public void setSharedAgendas(List<Agenda> sharedAgendas) {
        this.sharedAgendas = sharedAgendas;
    }
}