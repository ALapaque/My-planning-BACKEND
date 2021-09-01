package eu.busi.myplanning.domain.services;


import java.util.List;

public interface AgendaService<T> {
    List<T> findAll();
}
