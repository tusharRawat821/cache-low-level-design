package com.lld.cacheLLD.storage;

import java.util.HashMap;
import java.util.Map;

import com.lld.cacheLLD.exceptions.KeyNotFoundException;
import com.lld.cacheLLD.exceptions.StorageFullException;

public class HashMapBasedStorage<K, V> implements Storage<K, V> {

	private Map<K, V> storage; // in-memory cache hashmap
	private final Integer capacity;

	public HashMapBasedStorage(final Integer capacity) {
		this.storage = new HashMap<>();
		this.capacity = capacity;
	}
	
	@Override
	public void add(K key, V value) throws StorageFullException {
		if (this.storage.size() == capacity)
			throw new StorageFullException("");
		storage.put(key, value);
	}

	@Override
	public void remove(K key) throws KeyNotFoundException {
		if (!this.storage.containsKey(key))
			throw new KeyNotFoundException(String.format("Key={} not found", key));
		storage.remove(key);
	}

	@Override
	public V get(K key) throws KeyNotFoundException {
		if (!this.storage.containsKey(key))
			throw new KeyNotFoundException(String.format("Key={} not found", key));
		return storage.get(key);
	}

}
