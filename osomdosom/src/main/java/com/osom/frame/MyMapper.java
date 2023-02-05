package com.osom.frame;
import java.util.List;

import com.osom.dto.Board;

public interface MyMapper<K,V> {
	public void insert(V v) throws Exception;
	public void delete(K k) throws Exception;
	public Board update(V v) throws Exception;
	
	public V select (K k) throws Exception;
	public List<V> selectall() throws Exception;

}