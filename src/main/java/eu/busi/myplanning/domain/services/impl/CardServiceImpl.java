package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.domain.models.Card;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.CardRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CardService {
    private final CardRepository repository;
    private final UserRepository userRepository;

    public CardServiceImpl(CardRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Card save(Card entity) {
        return repository.save(entity);
    }

    @Override
    public List<Card> save(List<Card> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    @Override
    public Card findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Card> findAll(Pageable pageable) {
        Page<Card> entityPage = repository.findAll(pageable);
        List<Card> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Card update(Card entity, Long id) {
        Card card = findById(id);

        return save(entity);
    }

    @Override
    public List<Card> findCardsByUserId(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(userEntity -> repository.findCardsByUsers(userEntity)).orElse(null);

    }
}