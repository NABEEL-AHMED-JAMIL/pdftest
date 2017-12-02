package com.ballistic.token_test.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Nabeel on 12/1/2017.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    protected BaseEntity getObjectByIdentifier(Set<? extends BaseEntity> entities, Long entityIdentifier){

        for (BaseEntity entity: entities) {
            if(entity.getId().longValue() == entityIdentifier.longValue()){
                return entity;
            }
        }
        return null;
    }
}
