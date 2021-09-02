package eu.busi.myplanning.domain.mappers;

import java.util.List;

/**
 * The interface Generic mapper.
 *
 * @param <E> the type parameter
 * @param <D> the type parameter
 * @param <L> the type parameter
 */
public interface GenericMapper<E, D, L> {

    /**
     * As entity e.
     *
     * @param dto the dto
     * @return the e
     */
    E fromDtoToEntity(D dto);

    /**
     * From light dto to entity e.
     *
     * @param lightDto the light dto
     * @return the e
     */
    E fromLightDtoToEntity(L lightDto);

    /**
     * As dto d.
     *
     * @param entity the entity
     * @return the d
     */
    D asDTO(E entity);

    /**
     * As light dto l.
     *
     * @param entity the entity
     * @return the l
     */
    L asLightDto(E entity);

    /**
     * As entity list list.
     *
     * @param dtoList the dto list
     * @return the list
     */
    List<E> fromDtoListToEntityList(List<D> dtoList);

    /**
     * From light dto list to entity list list.
     *
     * @param dtoList the dto list
     * @return the list
     */
    List<E> fromLightDtoListToEntityList(List<L> dtoList);

    /**
     * As dto list list.
     *
     * @param entityList the entity list
     * @return the list
     */
    List<D> asDTOList(List<E> entityList);

    /**
     * As light dto list list.
     *
     * @param entityList the entity list
     * @return the list
     */
    List<L> asLightDTOList(List<E> entityList);

}