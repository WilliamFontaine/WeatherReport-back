package fr.hesias.WeatherReport.Service;

import fr.hesias.WeatherReport.Mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<ENTITY, DTO> {

    private final JpaRepository<ENTITY, UUID> repository;

    private final BaseMapper<ENTITY, DTO> mapper;

    public BaseService(JpaRepository<ENTITY, UUID> repository, BaseMapper<ENTITY, DTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<DTO> findAll() {
        return mapper.entityToDtos(repository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<DTO> findById(UUID id) {
        return repository.findById(id).map(mapper::entityToDto);
    }

    @Transactional
    public DTO create(DTO dto) {
        ENTITY entity = mapper.dtoToEntity(dto);
        return mapper.entityToDto(repository.save(entity));
    }

    @Transactional
    public DTO update(UUID id, DTO dto) {
        Optional<ENTITY> entity = repository.findById(id);
        if (entity.isEmpty()) {
            return null;
        }
        ENTITY entityUpdated = mapper.dtoToEntity(dto);
        return mapper.entityToDto(repository.save(entityUpdated));
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
