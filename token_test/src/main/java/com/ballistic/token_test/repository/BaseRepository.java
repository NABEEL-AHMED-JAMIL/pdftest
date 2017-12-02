package com.ballistic.token_test.repository;

import com.ballistic.token_test.domain.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Nabeel on 12/1/2017.
 */
@Repository
public class BaseRepository<T extends BaseEntity> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private static final String NULL_ID_MESSAGE = "Id connot be null.";

    @PersistenceContext
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Find the entity of T with a given id.
     *
     * @param id
     * @return
     */
    public T findById(Class<T> persistanceClass, Serializable id){

        if(id == null){
            throw new IllegalArgumentException(NULL_ID_MESSAGE);
        }
        return entityManager.find(persistanceClass, id);
    }

    /**
     * Delete the entity
     *
     * @param  entity
     * *
    */
    public void delete(T entity) {
        if(entity == null){
            throw new IllegalArgumentException("Cannot delete null entity.");
        }
        entityManager.remove(entity);
    }

    /**
     * Delete the entity of type T with the given Id.
     *
     * @param id
     */
    public void delete(Class<T> persistanceClass, Serializable id){
        if(id == null){
            throw new IllegalArgumentException(NULL_ID_MESSAGE);
        }
        entityManager.remove(persistanceClass);
    }

    /**
     * Returns all entities of type T.
     *
     * @return
     */
    public List<T> findAll(String entityName) {
        String sql = "Select entity From " + entityName + "entity";
        return getResultList(sql);
    }

    /**
     * Returns entity by property.
     *
     * @return
     */

    public List<T> findByProperty(String entityName, String property, Object value){
        String sql = "Select entity From " + entityName + " entity Where entity." + property +
                "=" + value;
        return getResultList(sql);
    }

    public T findSingleEntityByProperty(String entityName, String property, Object value){

        if(value instanceof String){
            value = "'" + value + "'";
        }
        String sql = "Select entity From " + entityName + " entity Where entity." + property + "=" + value;
        return getSingleResult(sql);
    }

    /**
     * Add a new entity.
     *
     * @param entity
     * @return
     */
    public Serializable persist(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Cannot persist null entity.");
        }
        entityManager.persist(entity);
        return entity.getId();
    }

    /**
     * Result list for a JPQL query.
     *
     * @param query
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> getResultList(String query) {
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * A single result, like count, max or a single row/column combo etc., for a
     * native SQL query.
     *
     * @param sqlQuery
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getSingleResult(String sqlQuery) {
        return (T) entityManager.createQuery(sqlQuery).getSingleResult();
    }

    /***************************************************************************************************
     *
     * @param namedQuery
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getSingleNamedQueryResult(String namedQuery) {
        return (T) entityManager.createNamedQuery(namedQuery).getSingleResult();
    }

    /****************************************************************************************************
     *
     * @param namedQuery
     * @param parameters
     * @return
     */
    public T getSingleNamedQueryResult(String namedQuery, Object[] parameters) {
        return getSingleNamedQueryResult(namedQuery, parameters, null);
        // (T)entityManager.createNamedQuery(namedQuery).se.getSingleResult();
    }

    /*****************************************************************************************************
     *
     * @param namedQuery
     * @param parameters
     * @return
     */
    public List<T> getNamedQueryResultList(String namedQuery,
                                           Object[] parameters) {
        return getNamedQueryResultList(namedQuery, parameters, null);
        // (T)entityManager.createNamedQuery(namedQuery).se.getSingleResult();
    }

    /****************************************************************************************************
     *
     * @param namedQuery
     * @param parameters
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getSingleNamedQueryResult(String namedQuery, Object[] parameters,
                                       Object[] parametersName) {
        return (T) getPreparedNamedQuery(namedQuery, parameters, parametersName)
                .getSingleResult(); // (T)entityManager.createNamedQuery(namedQuery).se.getSingleResult();

    }

    @SuppressWarnings("unchecked")
    public Object getSingleAggregateNamedQueryResult(String namedQuery,
                                                     Object[] parameters) {
        return getPreparedNamedQuery(namedQuery, parameters, null)
                .getSingleResult(); // (T)entityManager.createNamedQuery(namedQuery).se.getSingleResult();

    }

    /*****************************************************************************************************
     *
     * @param namedQuery
     * @param parameters
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> getNamedQueryResultList(String namedQuery,
                                           Object[] parameters, Object[] parametersName) {
        return getPreparedNamedQuery(namedQuery, parameters, parametersName)
                .getResultList(); // (T)entityManager.createNamedQuery(namedQuery).se.getSingleResult();
    }

    /*****************************************************************************************************
     *
     * @param namedQueryName
     * @param parameters
     * @return
     */
    private Query getPreparedNamedQuery(String namedQueryName,
                                        Object[] parameters, Object[] parametersName) {

        if (parametersName != null && parameters != null
                && parametersName.length != parameters.length) {
            throw new RuntimeException(
                    "length of parameters and parameters name array are not equals. parameters = "
                            + parameters.length + " -- parametersName = "
                            + parametersName.length);
        }

        Query namedQuery = entityManager.createNamedQuery(namedQueryName);

        if (parameters != null && parameters.length > 0) {
            for (int i = 1; i <= parameters.length; i++) {
                if (parametersName == null) {
                    namedQuery.setParameter(i, parameters[i - 1]);
                } else {
                    namedQuery.setParameter(
                            String.valueOf(parametersName[i - 1]),
                            parameters[i - 1]);
                }
            }
        }

        return namedQuery;
    }

    /**
     * Counts all the rows in the table for entity type T.
     *
     * @return count of all the entities of type T
     */
    public Long countAll(String entityName) {
        String sql = "select count(o) from " + entityName + " o";
        return (Long) entityManager.createQuery(sql).getSingleResult();
    }

    /**
     * Refresh the state of the instance from the database, overwriting changes
     * made to the entity, if any.
     *
     * @param entity
     */
    public void refresh(T entity) {
        entityManager.refresh(entity);
    }

    /**
     * Merge the state of the given entity into the current persistence context. <br>
     * <br>
     * Simply delegates to merge(T entity) method in this class.
     *
     * @see #merge
     * @param entity
     * @return the updated entity instance
     */
    public T update(T entity) {
        return this.merge(entity);
    }

    /**
     * Merge the state of the given entity into the current persistence context.
     *
     * @see #update
     * @param entity
     * @return The updated entity instance. The state of the passed entity is
     *         not changed; that is, it doesn't become managed.
     */
    public T merge(T entity) {
        return entityManager.merge(entity);
    }

    /**
     * Detach the state of the given entity from the current persistence
     * context.
     *
     * @see #update
     * @param entity
     * @return The detached entity instance.
     */
    public void detach(T entity) { entityManager.detach(entity); }


    public void flush() {
        entityManager.flush();
    }

}
