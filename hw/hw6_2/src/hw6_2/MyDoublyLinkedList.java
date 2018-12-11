/***************************
파일명: MyDoublyLinkedList.java
작성자: 김규희
작성일: 2018. 10. 10
설명: 이중 연결리스트 연산을 구현한다.
 *******************************/
package hw6_2;

public class MyDoublyLinkedList {
	private class Node{
		Node rlink,llink;
		int data;

		Node(int data){
			Node llink=null;
			this.data=data;
			Node rlink=null;
		}
	}

	private Node head=null;

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
		}
		else {
			newNode.rlink=head;
			head.llink=newNode;
			head=newNode;
		}
	}

	public String toString() {
		Node temp=head;
		String s="list = ";
		while(temp!=null) {
			s+=temp.data+" ";
			temp=temp.rlink;
		}
		return s;
	}
	/***************************************************
	public void printList() {
		if(head == null) {
			System.out.println("( )( )");
		}
		else {
			System.out.print("( ");
			Node temp = head;
			while(temp.rlink!=null) {
				System.out.print(temp.data+" ");
				temp=temp.rlink;
			}
			System.out.print(temp.data+") ");

			System.out.print("( ");
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.llink;
			}
			System.out.println(") ");

		}
	}
	 ***********************************/

	public void printList() {
		if(head==null) {
			System.out.println("() ()");
		}
		else {
			Node temp= head;
			System.out.print("( ");
			while(temp.rlink!=null) {
				System.out.print(temp.data+" ");
				temp=temp.rlink;
			}
			System.out.println(temp.data+" )");

			System.out.print("( ");
			while(temp.llink!=null) {
				System.out.print(temp.data+" ");
				temp=temp.llink;
			}
			System.out.println(temp.data+" )");
		}
	}

	public int size() {
		Node temp=head;
		int i=0;
		while(temp!=null) {
			i++;
			temp=temp.rlink;
		}
		return i;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		Node temp=head;
		if(head==null) {
			head=newNode;
		}
		else {
			while(temp.rlink!=null) {
				temp=temp.rlink;
			}
			temp.rlink=newNode;
			newNode.llink=temp;
		}
	}

	public int removeFirst() {
		int returnData=head.data;
		if(size()==1) {
			head=null;
		}
		else{
			head=head.rlink;
			head.llink=null;
		}
		return returnData;
	}

	public int removeLast() {
		int returnData;
		Node temp=head;
		if(size()==1) {
			returnData=head.data;
			head=null;
			return returnData;
		}
		else {
			while(temp.rlink!=null) {
				temp=temp.rlink;
			}
		}
		returnData=temp.data;
		temp.llink.rlink=null;
		return returnData;
	}
	public boolean remove(int data) {
		Node temp=head;
		while(temp!=null) {
			if(temp.data==data) {
				if(temp==head) {
					temp=temp.rlink;
					head=temp;
					return true;
				}
				else if(temp.rlink==null) {
					temp.llink.rlink=null;
					return true;
				}
				else{
					temp.rlink.llink=temp.llink;
					temp.llink.rlink=temp.rlink;
					temp=null;
					return true;
				}

			}
			temp=temp.rlink;
		}
		return false;
	}
	/************************************************
	public boolean remove(int data) {
		Node temp=head;
		while(temp!=null) {
			if(temp.data==data) {
				if(temp==head) {
					temp=temp.rlink;
					head=temp;
					return true;
				}
				else if(temp.rlink!=null) {
					temp.llink.rlink=null;
					return true;
				}
				else {
					temp.llink.rlink=temp.rlink;
					temp.rlink.llink=temp.llink;
					temp=null;
					return true;
				}
			}
			temp=temp.rlink;
		}
		return false;
	}
	 ************************************************/
}
