package eu.busi.myplanning.domain.services;

import eu.busi.myplanning.domain.models.Agenda;

import java.util.List;

/**
 * The interface Agenda service.
 */
public interface AgendaService extends GenericService<Agenda, Long> {
    List<Agenda> findByUser(Long id);
    List<Agenda> findSharedAgendasByUser(Long id);
}