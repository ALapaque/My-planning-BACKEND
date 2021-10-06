package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * The type User entity.
 */
@Entity
@Table(name = "users")
public class UserEntity extends DateAudit implements AbstractEntity<Long>, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String organization;

    @NotBlank
    @Column(length = 40, nullable = false)
    private String firstName;

    @NotBlank
    @Column(length = 40, nullable = false)
    private String lastName;

    @NotBlank
    @Column(unique = true, length = 100, nullable = false)
    private String username;

    @NaturalId
    @NotBlank
    @Email
    @Column(unique = true, length = 40, nullable = false)
    private String email;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String password;

    /**
     * user role
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRole", referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private Role role;

    /**
     * user posted comments
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("user")
    private List<Comment> comments;

    /**
     * user agendas
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("user")
    private List<Agenda> agendas;

    /**
     * user teams
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "users_has_teams",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idTeam"))
    @JsonIgnoreProperties("users")
    private List<Team> teams = new LinkedList<>();

    /**
     * user dashboard's cards
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "users_has_cards",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idCard"))
    @JsonIgnoreProperties("users")
    private List<Card> cards = new LinkedList<>();

    /**
     * user shared agendas
     */
    @ManyToMany(mappedBy = "sharedUsers", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Agenda> sharedAgendas;

    /**
     * Instantiates a new User entity.
     */
    public UserEntity() {
    }

    /**
     * Instantiates a new User entity.
     *
     * @param id            the id
     * @param firstName     the first name
     * @param organization  the organization
     * @param lastName      the last name
     * @param username      the username
     * @param email         the email
     * @param password      the password
     * @param role          the role
     * @param comments      the comments
     * @param agendas       the agendas
     * @param teams         the teams
     * @param cards         the cards
     * @param sharedAgendas the shared agendas
     */
    public UserEntity(Long id, String firstName, String organization, String lastName, String username, String email, String password, Role role, List<Comment> comments, List<Agenda> agendas, List<Team> teams, List<Card> cards, List<Agenda> sharedAgendas) {
        this.id = id;
        this.firstName = firstName;
        this.organization = organization;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.comments = comments;
        this.agendas = agendas;
        this.teams = teams;
        this.cards = cards;
        this.sharedAgendas = sharedAgendas;
    }

    /**
     * Gets Id
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Lists id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Lists first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets organization.
     *
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets organization.
     *
     * @param organization the organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Lists last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Lists username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Lists email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Lists password encoded
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Lists role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
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
     * Lists comments.
     *
     * @param comments the comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
     * Lists agendas.
     *
     * @param agendas the agendas
     */
    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * Lists teams.
     *
     * @param teams the teams
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Lists cards.
     *
     * @param cards the cards
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
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
     * Lists shared agendas.
     *
     * @param sharedAgendas the shared agendas
     */
    public void setSharedAgendas(List<Agenda> sharedAgendas) {
        this.sharedAgendas = sharedAgendas;
    }
}