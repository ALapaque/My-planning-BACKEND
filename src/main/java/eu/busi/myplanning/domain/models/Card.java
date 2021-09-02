package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.busi.myplanning.domain.enumerations.CardSize;
import eu.busi.myplanning.domain.enumerations.CardType;
import eu.busi.myplanning.models.CardDTO;

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
    private CardDTO.TypeEnum type;

    @Enumerated(EnumType.STRING)
    private CardDTO.SizeEnum size;

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

    public CardDTO.TypeEnum getType() {
        return type;
    }

    public void setType(CardDTO.TypeEnum type) {
        this.type = type;
    }

    public CardDTO.SizeEnum getSize() {
        return size;
    }

    public void setSize(CardDTO.SizeEnum size) {
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