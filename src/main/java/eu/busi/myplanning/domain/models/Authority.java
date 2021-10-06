package eu.busi.myplanning.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Authority.
 */
@Table(name = "authorities")
@Entity
public class Authority implements AbstractEntity<Long>, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 60, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_has_authorities",
            joinColumns = @JoinColumn(name = "idAuthority"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    @JsonIgnoreProperties("authorities")
    private List<Role> roles = new ArrayList<>();

    /**
     * Instantiates a new Authority.
     */
    public Authority() {
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
     * Gets roles.
     *
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}