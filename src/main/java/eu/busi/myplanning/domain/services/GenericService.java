package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import eu.busi.myplanning.exceptions.NotUpdatedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

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
    E save(E entity) throws NotSavedException;

    /**
     * Save list.
     *
     * @param entities the entities
     * @return the list
     */
    List<E> save(List<E> entities) throws NotSavedException;

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteById(I id) throws NotDeletedException;

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<E> findById(I id) throws NotFoundException;

    /**
     * Find all list.
     *
     * @return the list
     */
    List<E> findAll() throws NotFoundException;

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<E> findAll(Pageable pageable) throws NotFoundException;

    /**
     * Update e.
     *
     * @param entity the entity
     * @param id     the id
     * @return the e
     */
    E update(E entity, I id) throws NotUpdatedException;
}