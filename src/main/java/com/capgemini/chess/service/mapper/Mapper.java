package com.capgemini.chess.service.mapper;

import java.util.List;

public interface Mapper<E, T> {

       public T map2To(E entity);
 
       public E map2Entity(T to);
 
       public List<T> map2TOs(List<E> entities);
 
       public List<E> map2Entities(List<T> tos);
}

