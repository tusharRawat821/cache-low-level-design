package com.lld.cacheLLD.datastructure;

public class DoublyLinkedList<K> {
	
	private DoublyLinkedListNode<K> head;
	private DoublyLinkedListNode<K> tail;
	
	public DoublyLinkedList() {
		// dummy nodes for easier logic detach/remove
		this.head = new DoublyLinkedListNode<>(null);
		this.tail = new DoublyLinkedListNode<>(null);
		
		// they are attached
		this.head.setNext(tail);
		this.tail.setPrev(head);
	}
	
	public void addAtLast(DoublyLinkedListNode<K> node) {
		DoublyLinkedListNode<K> tailPrev = this.tail.getPrev();
		tailPrev.setNext(node);
		
		node.setPrev(tailPrev);
		node.setNext(tail);
		
		tail.setPrev(node);
	}
	
	public void detachNode(DoublyLinkedListNode<K> node) {
		DoublyLinkedListNode<K> nodePrev = node.getPrev();
		DoublyLinkedListNode<K> nodeNext = node.getNext();
		
		nodePrev.setNext(nodeNext);
		nodeNext.setPrev(nodePrev);
		
		node.setNext(null);
		node.setPrev(null);
	}
	
	public DoublyLinkedListNode<K> getFirst() {
		if(listIsEmpty())
			return null;
		return this.head.getNext();
	}
	
	private boolean listIsEmpty() {
		return this.head.getNext() == this.tail;
	}
}
