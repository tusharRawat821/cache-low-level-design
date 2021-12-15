package com.lld.cacheLLD.evictionstrategy;

public interface EvictionStrategy<K> {
	public void keyAccessed(K key);
	
	public K evict();
}
