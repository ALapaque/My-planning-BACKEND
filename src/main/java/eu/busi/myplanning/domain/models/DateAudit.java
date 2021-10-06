package eu.busi.myplanning.domain.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

/**
 * abstract class which will give date auditing attributs
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DateAudit {

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Instant getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
