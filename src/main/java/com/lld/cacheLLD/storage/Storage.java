package com.lld.cacheLLD.storage;

import com.lld.cacheLLD.exceptions.KeyNotFoundException;
import com.lld.cacheLLD.exceptions.StorageFullException;

public interface Storage<K, V> {
	
	public void add(K key, V value) throws StorageFullException;

	public void remove(K key) throws KeyNotFoundException;
	
	public V get(K key) throws KeyNotFoundException;
	
}
