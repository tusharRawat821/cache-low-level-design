package com.lld.cacheLLD;

import com.lld.cacheLLD.evictionstrategy.EvictionStrategy;
import com.lld.cacheLLD.exceptions.StorageFullException;
import com.lld.cacheLLD.storage.Storage;

public class Cache<K, V> {
	
	// immuttable as once set cannot change later.
	private final Storage<K, V> storage;	
	private final EvictionStrategy<K> evictionStrategy;
	
	public Cache(Storage<K, V> storage, EvictionStrategy<K> evictionStrategy) {
		this.storage = storage;
		this.evictionStrategy  = evictionStrategy;
	}
	
	// support 2 apis: put and get.
	private void put(K key, V value) {
		try {
			storage.add(key, value);
			evictionStrategy.keyAccessed(key);
		}
		catch (StorageFullException ex) {
			System.out.println("Cache is full. Eviction in place.");
			K evictedKey = evictionStrategy.evict();
			storage.remove(evictedKey);
			System.out.println("Creating space by evicting item..." + evictedKey);
			put(key, value);
		}
	}
	
	private V get(K key) {
		V value = storage.get(key);
		evictionStrategy.keyAccessed(key);
		return value;
	}
}
