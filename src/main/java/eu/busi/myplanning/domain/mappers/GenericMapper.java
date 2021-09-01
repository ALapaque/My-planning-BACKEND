package eu.busi.myplanning.domain.mappers;

import java.util.List;

/**
 * The interface Generic mapper.
 *
 * @param <E> the type parameter
 * @param <D> the type parameter
 */
public interface GenericMapper<E, D> {

    /**
     * As entity e.
     *
     * @param dto the dto
     * @return the e
     */
    E asEntity(D dto);

    /**
     * As dto d.
     *
     * @param entity the entity
     * @return the d
     */
    D asDTO(E entity);

    /**
     * As entity list list.
     *
     * @param dtoList the dto list
     * @return the list
     */
    List<E> asEntityList(List<D> dtoList);

    /**
     * As dto list list.
     *
     * @param entityList the entity list
     * @return the list
     */
    List<D> asDTOList(List<E> entityList);

}