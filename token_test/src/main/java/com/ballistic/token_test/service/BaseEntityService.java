package com.ballistic.token_test.service;

import com.ballistic.token_test.domain.model.BaseEntity;
import com.ballistic.token_test.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * Created by Nabeel on 12/1/2017.
 */
@Service
@Transactional
public class BaseEntityService<T extends BaseEntity> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected BaseRepository<T> baseRepository;

    private Class<T> persistentClass;
    private String persistentClassSimpleName;

    /**
     * Find the entity of T with a given id.
     * @param id
     * @return
     */
    public T findById(Serializable id) {
        return baseRepository.findById(getPersistentClass(), id);
    }

    /**
     * Delete the entity of type T with the given Id.
     *
     * @param id
     */
    public void delete(Serializable id) {
        baseRepository.delete(getPersistentClass(), id);
    }

    public void deleteAll(Set<T> entitySet){
        if(entitySet == null){
            return;
        }
        for (T t : entitySet) {
            delete(t.getId());
        }
    }

    /**
     * Returns all entities of type T.
     * @return
     */
    public List<T> findAll() {
        return baseRepository.findAll(getEntityName());
    }

    /**
     * Returns Entity by property.
     * @return
     */
    public List<T> findByProperty(String entityName,String property,Object value) {
        if(value instanceof String){
            value = "'"+value+"'";
        }
        return baseRepository.findByProperty(entityName, property, value);
    }

    /**
     * Returns all entities of type T.
     * @return
     */
    public T findSingleEntityByProperty(String entityName,String property,Object value) {
        return baseRepository.findSingleEntityByProperty(entityName, property, value);
    }
    /**
     * Counts all the rows in the table for entity type T.
     * @return count of all the entities of type T
     */
    public Long countAll() {
        return baseRepository.countAll(getEntityName());
    }

    public Long persist(T t){
        return (Long)this.baseRepository.persist(t);
    }

    public T merge(T t){
        return this.baseRepository.merge(t);
    }

    public void flush(){
        this.baseRepository.flush();
    }

    public void refresh(T t){
        this.baseRepository.refresh(t);
    }

    /**
     * BaseService being parameterized generic class, this method returns the 
     * Class that's being used as the parameter for this instance. 
     * @return
     */
    @SuppressWarnings("unchecked")
    protected Class<T> getPersistentClass() {
        if (this.persistentClass == null) {
            Type gsc = getClass().getGenericSuperclass();
            this.persistentClass = (Class<T>) ((ParameterizedType) gsc)
                    .getActualTypeArguments()[0];
        }
        return this.persistentClass;
    }

    /**
     * The entity name for type T.
     * @return
     */
    protected String getEntityName() {
        if (this.persistentClassSimpleName == null) {
            this.persistentClassSimpleName = getPersistentClass().getSimpleName();
        }
        return this.persistentClassSimpleName;
    }

}
