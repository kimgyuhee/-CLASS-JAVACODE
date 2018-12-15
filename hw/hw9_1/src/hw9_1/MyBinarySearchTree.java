/**************************************
파일명: MyBinarySearchTree.java
작성일: 2018.11.16.
작성자: 김규희
설명: int형 키값 저장하는 이진탐색트리를 연결자료구조로 구현한 클래스
 ******************************************/

package hw9_1;

import java.util.NoSuchElementException;

public class MyBinarySearchTree {
	// (1) 트리의 노드를 표현하는 private 클래스 Node - 필드(int형 key, leftChild, rightChild), 생성자(key값을 매개변수로 받아 초기화)
	private class Node{
		int key;
		Node leftChild;
		Node rightChild;

		Node(int key) {
			this.key=key;
		}
	}


	// (2) private 인스턴스 변수 트리의 루트 노드를 가킬 변수(root)를 선언하고 null로 초기화
	private Node root=null;


	// 트리에 키값 key를 삽입하는 메소드
	public void insert(int key) {
		root = insertKey(root, key);
	}

	// p를 루트로 하는 트리에 키값 key를 삽입하고, 삽입 후 루트를 리턴하는 메소드(재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if(p == null) {  
			Node newNode = new Node(key);
			return newNode; 
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;  // 루트 불변
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;  // 루트 불변       
		}
		else {  // key = p.key 인 경우 삽입 실패
			System.out.println("삽입 실패. 중복된 키값이 존재합니다: " + key);
			return p;   // 루트 불변
		}
	}  

	// 트리를 중위순회하며 출력하는 메소드
	public void printInorder() {
		inorder(root);
		System.out.println();
	}

	// (3) p를 루트로 하는 트리를 중위 순회하며 키값을 출력하는 메소드(재귀 알고리즘)
	private void inorder(Node p) {
		if(p!=null) {
			inorder(p.leftChild);
			System.out.print(p.key+" ");
			inorder(p.rightChild);
		}

	}

	// (4) 트리의 최대 키값을 리턴하는 메소드(반복 알고리즘) - 공백 트리인 경우 NoSuchElementException 예외 발생
	public int max() {
		if(root == null) {
			throw new NoSuchElementException();
		}
		else {
			Node p =root;
			while(p.rightChild!=null) {
				p=p.rightChild;
			}
			return p.key;

		}

	}

	// 트리가 키값 key를 포함하는지 여부를 리턴하는 메소드
	public boolean contains(int key) {
		return search(root, key);
	}

	// (5) p를 루트로 하는 트리에 키값 key가 존재하는지 여부를 리턴하는 메소드(재귀 알고리즘)
	private boolean search(Node p, int key) {
		if(p==null)
			return false;
		else if(p.key==key)
			return true;
		else
			return search(p.leftChild,key)||search(p.rightChild,key);
	}

	// (6) 트리에 키값 key를 삽입하는 메소드(반복 알고리즘) - 삽입 성공여부(true/false)를 리턴
	public boolean add(int key) {
		Node p=root;
		Node q=null;
		Node newNode = new Node(key);
		while(p!=null) {
			if(key==p.key)
				return false;
			q=p;
			if(key<p.key)
				p=p.leftChild;
			else
				p=p.rightChild;
		}

		if(root==null) {
			root=newNode;
			return true;
		}
		else if(key<q.key) {
			q.leftChild=newNode;
			return true;
		}
		else {
			q.rightChild=newNode;
			return true;
		}
	}

	public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		/*******************
		while 문이 끝나고 나면 focusNode는 삭제될 노드를 가리키고,
		parent 는 삭제될 노드의 부모노드를 가리키게 되고, 삭제될 노드
		가 부모의 노드의 left인지 right인지에 대한 정보를 가지게 된다.
		********************/
		
		while(focusNode.key != key) {
			parent = focusNode; //삭제할 노드를 찾는 과정중에서 focusNode는 계속해서 바뀌고 parent 노드는 여기서 기억해둔다.
			
			if(key < focusNode.key) {
				isLeftChild = true; // 지우려는 노드가 왼쪽에 있는 노드냐 기록용
				focusNode = parent.leftChild;
			} else {
				isLeftChild = false; // 지우려는 노드가 오른쪽에 있는 노드냐 기록용
				focusNode = parent.rightChild;
			}
			
			if(focusNode == null) {
				return false;
			}

		}
		
		Node replacementNode;
		//지우려는 노드의 자식 노드가 없는 경우
		if(focusNode.leftChild == null && focusNode.rightChild == null) {
			if (focusNode == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		// 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
		else if(focusNode.rightChild == null) {
			replacementNode = focusNode.leftChild;

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		// 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
		else if (focusNode.leftChild == null) {
			replacementNode = focusNode.rightChild;
			
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		// 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
		// 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
		else {
			// 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
			Node rightSubTree = focusNode.rightChild;

			// 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을 가진 노드)
			// 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기 때문에)
			replacementNode = getRightMinNode(focusNode.rightChild);

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;

			replacementNode.rightChild = rightSubTree;
			// 지우려는 노드의 오른쪽 sub tree 에 노드가 하나밖에 없는 경우
			if (replacementNode == rightSubTree) 
				replacementNode.rightChild = null;

			replacementNode.leftChild = focusNode.leftChild; // 지우려는 노드의 왼쪽 sub tree 를 연결시킨다
		}

		return true;
	}

	private Node getRightMinNode(Node rightChildRoot) {
		Node parent = rightChildRoot;
		Node focusNode = rightChildRoot;

		while (focusNode.leftChild != null) {
			parent = focusNode;
			focusNode = focusNode.leftChild;
		}

		parent.leftChild = null;
		return focusNode;
	}
}

