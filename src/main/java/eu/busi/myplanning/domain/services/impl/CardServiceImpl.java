package eu.busi.myplanning.domain.services.impl;

import eu.busi.myplanning.api.models.CardDTO;
import eu.busi.myplanning.domain.mappers.CardMapper;
import eu.busi.myplanning.domain.models.Card;
import eu.busi.myplanning.domain.models.UserEntity;
import eu.busi.myplanning.domain.repositories.CardRepository;
import eu.busi.myplanning.domain.repositories.UserRepository;
import eu.busi.myplanning.domain.services.CardService;
import eu.busi.myplanning.exceptions.NotDeletedException;
import eu.busi.myplanning.exceptions.NotFoundException;
import eu.busi.myplanning.exceptions.NotSavedException;
import eu.busi.myplanning.exceptions.NotUpdatedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Card service.
 */
@Service
@Transactional
public class CardServiceImpl implements CardService {
    private final CardRepository repository;
    private final UserRepository userRepository;

    /**
     * Instantiates a new Card service.
     *
     * @param repository     the repository
     * @param userRepository the user repository
     */
    public CardServiceImpl(CardRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    /**
     * save a card
     * @param entity the entity
     * @return
     * @throws NotSavedException
     */
    @Override
    public CardDTO save(CardDTO entity) throws NotSavedException {
        try {
            return CardMapper
                    .INSTANCE
                    .asDTO(repository
                            .save(CardMapper
                                    .INSTANCE
                                    .fromDtoToEntity(entity)));
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * save a list of cards
     * @param entities the entities
     * @return
     * @throws NotSavedException
     */
    @Override
    public List<CardDTO> save(List<CardDTO> entities) throws NotSavedException {
        try {
            List<Card> cards = entities
                    .stream()
                    .map(CardMapper.INSTANCE::fromDtoToEntity)
                    .collect(Collectors.toList());

            return repository
                    .saveAll(cards)
                    .stream()
                    .map(CardMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotSavedException();
        }
    }

    /**
     * delete a card by an id
     * @param id the id
     * @return
     * @throws NotDeletedException
     */
    @Override
    public boolean deleteById(Long id) throws NotDeletedException {
        try {
            repository.deleteById(id);

            return !repository.existsById(id);
        } catch (Exception e) {
            throw new NotDeletedException();
        }
    }

    /**
     * find a card by an id
     * @param id the id
     * @return
     * @throws NotFoundException
     */
    @Override
    public Optional<CardDTO> findById(Long id) throws NotFoundException {
        try {
            return repository
                    .findById(id)
                    .map(CardMapper.INSTANCE::asDTO);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find all cards
     * @return
     * @throws NotFoundException
     */
    @Override
    public List<CardDTO> findAll() throws NotFoundException {
        try {
            return repository
                    .findAll()
                    .stream()
                    .map(CardMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * find cards from a pageable object
     * @param pageable the pageable
     * @return
     * @throws NotFoundException
     */
    @Override
    public Page<CardDTO> findAll(Pageable pageable) throws NotFoundException {
        try {
            Page<Card> entityPage = repository.findAll(pageable);
            List<CardDTO> entities = entityPage
                    .getContent()
                    .stream()
                    .map(CardMapper.INSTANCE::asDTO)
                    .collect(Collectors.toList());

            return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    /**
     * update a card
     * @param entity the entity
     * @param id     the id
     * @return
     * @throws NotUpdatedException
     */
    @Override
    public CardDTO update(CardDTO entity, Long id) throws NotUpdatedException {
        try {
            Optional<CardDTO> optional = findById(id);

            if (optional.isPresent()) {
                Card card = CardMapper.INSTANCE.fromDtoToEntity(optional.get());
                card.setRecap(entity.isRecap());
                card.setSize(entity.getSize());
                card.setType(entity.getType());

                return save(CardMapper.INSTANCE.asDTO(card));
            } else {
                throw new Exception("Ressource not found...");
            }
        } catch (Exception e) {
            throw new NotUpdatedException();
        }
    }

    /**
     * find cards used by a user
     * @param id
     * @return
     * @throws NotFoundException
     */
    @Override
    public List<CardDTO> findCardsByUserId(Long id) throws NotFoundException {
        try {
            Optional<UserEntity> optional = userRepository.findById(id);

            return optional
                    .map(userEntity -> repository
                            .findCardsByUsers(userEntity)
                            .stream()
                            .map(CardMapper.INSTANCE::asDTO)
                            .collect(Collectors.toList()))
                    .orElse(null);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}