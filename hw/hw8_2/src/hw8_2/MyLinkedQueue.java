/********************************
 * 파일명 : MyLinkedQueue.java
 * 작성일: 2018년 11월 4일
 * 작성자: 김규희
 * 내용: 연결자료구조를 이용한 큐 구현을 연습한다.
 *********************************/
package hw8_2;

import java.util.NoSuchElementException;

public class MyLinkedQueue {

	private class Node{
		private int data;
		private Node link;

		public Node(int data){
			this.data=data;
			this.link=null;
		}
	}

	private int count=0;
	private Node front=null;
	private Node rear=null;


	public boolean isEmpty() {
		return count==0;
	}

	public void enQueue(int n) {
		Node newNode = new Node(n);
		if(isEmpty()) {
			rear=newNode;
			front=newNode;
		}
		else {
			rear.link=newNode;
			rear=newNode;
		}
		count++;
	}

	public int deQueue() {
		if(isEmpty())
			throw new NoSuchElementException();
		else {
			int returndata=front.data;
			front=front.link;
			count--;
			if(front==null)
				rear=null;
			return returndata;
		}
	}

	public int peek() {
		if(isEmpty())
			throw new NoSuchElementException();
		else
			return front.data;
	}

	public int size() {
		return count;
	}
}
