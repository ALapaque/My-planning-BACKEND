package eu.busi.myplanning.domain.models;

/**
 * The interface Abstract entity.
 *
 * @param <T> the type parameter
 */
public interface AbstractEntity<T> {


    /**
     * Gets id.
     *
     * @return the id
     */
    T getId();

    /**
     * Sets id.
     *
     * @param id the id
     */
    void setId(T id);
}
