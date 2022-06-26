package com.example.sfgpetclinic.services.map;

import com.example.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long>{

    protected Map<Long,  T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if (object != null){
            if(object.getId() == null){
                object.setId(getNext());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be no null");
        }
        return  object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue()==object);
    }

    private Long getNext(){
        long nextId;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}