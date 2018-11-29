package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Transient
    protected Integer Id;
    protected Date createdAt;
    protected Date updatedAt;

    @Override
    public String toString() {
        Map<String, Object> values = new HashMap<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                values.put(field.getName(), field.get(this));
            }catch (IllegalAccessException ex){

            }
        }
        return values.toString();
    }
}
