package com.travelmanager.hateoas.abstracts;

import lombok.Getter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;
import java.util.Optional;

/**
 * Abstract RestService for handling basic http-requests
 * Connects to database using {@linkplain PagingAndSortingRepository}
 *
 * @author lfb0801
 */
public abstract class HateoasService<T extends ResourceSupport, Identifier> {

    @Getter
    private PagingAndSortingRepository<T, Identifier> repo;

    public HateoasService(PagingAndSortingRepository<T, Identifier> _repo) {
        repo = _repo;
    }

    /**
     * Use this method to return the classname of the instance.
     *
     * @return class of the instance.
     */
    public abstract Class<? extends HateoasService<T, Identifier>> getClazz();

    public abstract Class<? extends ResourceSupport> getType();

    public void create(T entity) {
        repo.save(entity);
    }

    public T read(Identifier indentifier) {
        Optional<T> result = repo.findById(indentifier);
        return result.orElse(null);
    }

    public Collection<T> readAll() {
        Iterable<T> result = repo.findAll();
        return (Collection<T>) result;
    }

    public void update(T entity) {
        repo.save(entity);
    }

    public void delete(T entity) {
        repo.delete(entity);
    }
}
