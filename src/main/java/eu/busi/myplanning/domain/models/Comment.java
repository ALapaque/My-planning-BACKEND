package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * The type Comment.
 */
@Entity
@Table(name = "comments")
public class Comment extends DateAudit implements AbstractEntity<Long>, Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    /**
     * this contains the redactor of the comment
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    @JsonIgnoreProperties("comments")
    private UserEntity user;

    /**
     * this is the event where the comment has been posted
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEvent", referencedColumnName = "id")
    @JsonIgnoreProperties("events")
    private Event event;

    /**
     * Instantiates a new Comment.
     */
    public Comment() {
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
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
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
     * Gets event.
     *
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(Event event) {
        this.event = event;
    }
}
