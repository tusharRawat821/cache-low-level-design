package com.lld.cacheLLD.datastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublyLinkedListNode<K> {
	
	private K key;
	private DoublyLinkedListNode<K> prev;
	private DoublyLinkedListNode<K> next;
	
	public DoublyLinkedListNode(K key) {
		this.key = key;
		this.prev = null;
		this.next = null;
	}
	
}
