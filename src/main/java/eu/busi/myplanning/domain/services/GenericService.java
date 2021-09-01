package eu.busi.myplanning.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Generic service.
 *
 * @param <E> the type parameter
 * @param <I> the type parameter
 */
public interface GenericService<E, I> {
    /**
     * Save e.
     *
     * @param entity the entity
     * @return the e
     */
    E save(E entity);

    /**
     * Save list.
     *
     * @param entities the entities
     * @return the list
     */
    List<E> save(List<E> entities);

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteById(I id);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    E findById(I id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<E> findAll();

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<E> findAll(Pageable pageable);

    /**
     * Update e.
     *
     * @param entity the entity
     * @param id     the id
     * @return the e
     */
    E update(E entity, I id);
}