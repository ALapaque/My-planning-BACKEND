package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.busi.myplanning.models.CardSize;
import eu.busi.myplanning.models.CardType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Card.
 */
@Table(name = "cards")
@Entity
public class Card implements AbstractEntity<Long>, Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isRecap", nullable = false)
    private boolean recap;

    @Enumerated(EnumType.STRING)
    private CardType type;

    @Enumerated(EnumType.STRING)
    private CardSize size;

    /**
     * user linked to dashboard's cards
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_has_cards",
            joinColumns = @JoinColumn(name = "idCard"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))
    @JsonIgnoreProperties("cards")
    private List<UserEntity> users = new ArrayList<>();

    public Card() {
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
     * Is recap boolean.
     *
     * @return the boolean
     */
    public boolean isRecap() {
        return recap;
    }

    /**
     * Sets recap.
     *
     * @param recap the recap
     */
    public void setRecap(boolean recap) {
        this.recap = recap;
    }


    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardSize getSize() {
        return size;
    }

    public void setSize(CardSize size) {
        this.size = size;
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
}