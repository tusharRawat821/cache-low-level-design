package com.lld.cacheLLD.evictionstrategy;

import java.util.HashMap;
import java.util.Map;

import com.lld.cacheLLD.datastructure.DoublyLinkedList;
import com.lld.cacheLLD.datastructure.DoublyLinkedListNode;

public class LRUEvictionStrategy<K> implements EvictionStrategy<K> {

	private DoublyLinkedList<K> dll;
	private Map<K, DoublyLinkedListNode<K>> mapper;

	public LRUEvictionStrategy() {
		this.dll = new DoublyLinkedList<>();
		this.mapper = new HashMap<>();
	}

	@Override
	public void keyAccessed(K key) {
		// approach.
		if (mapper.containsKey(key)) {
			dll.detachNode(mapper.get(key));
			dll.addAtLast(mapper.get(key));
		} else {
			DoublyLinkedListNode<K> node = new DoublyLinkedListNode<>(key);
			dll.addAtLast(node);
			mapper.put(key, node);
		}
	}
	
	@Override
	public K evict() {
		// strategy of eviction.
		DoublyLinkedListNode<K> lruNode = dll.getFirst();
		if (lruNode == null)
			return null;
		dll.detachNode(lruNode);
		lruNode.setNext(null);
		lruNode.setPrev(null);
		return lruNode.getKey();
	}

}
