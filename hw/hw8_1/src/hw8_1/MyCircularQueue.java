/********************************
 * ���ϸ� : MyCircularQueue.java
 * �ۼ���: 2018�� 11�� 1��
 * �ۼ���: �����
 * ����: �迭�� �̿��� ���� ť ������ �����Ѵ�.
 *********************************/
package hw8_1;

import java.util.NoSuchElementException;

public class MyCircularQueue {
	private int[] circleArray;
	private int arraySize;
	private int count;
	private int front=0;
	private int rear=0;
	
	public MyCircularQueue(int arraySize) {
		this.arraySize=arraySize;
		circleArray= new int[arraySize];
		count=0;
	}
	
	public boolean isEmpty() {
		return count==0;
	}
	
	public boolean isFull() {
		return count==arraySize;
	}
	
	public void enQueue(int n) {
		if(isFull())
			System.out.println("Queue�� �������� ������ �� �����ϴ�.");
		else {
			count++;
			rear=(rear+1)%arraySize;
			circleArray[rear]=n;
		}
	}
	
	public int deQueue() {
		if(isEmpty())
			throw new NoSuchElementException();
		else {
			count--;
			front=(front+1)%arraySize;
			return circleArray[front];
		}
	}
	
	public int peek() {
		if(isEmpty())
			throw new NoSuchElementException();
		else 
			return circleArray[(front+1)%arraySize];
	}
	
	public int size() {
		return count;
	}
	
	
}
