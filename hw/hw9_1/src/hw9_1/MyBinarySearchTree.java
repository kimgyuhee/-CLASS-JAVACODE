/**************************************
���ϸ�: MyBinarySearchTree.java
�ۼ���: 2018.11.16.
�ۼ���: �����
����: int�� Ű�� �����ϴ� ����Ž��Ʈ���� �����ڷᱸ���� ������ Ŭ����
 ******************************************/

package hw9_1;

import java.util.NoSuchElementException;

public class MyBinarySearchTree {
	// (1) Ʈ���� ��带 ǥ���ϴ� private Ŭ���� Node - �ʵ�(int�� key, leftChild, rightChild), ������(key���� �Ű������� �޾� �ʱ�ȭ)
	private class Node{
		int key;
		Node leftChild;
		Node rightChild;

		Node(int key) {
			this.key=key;
		}
	}


	// (2) private �ν��Ͻ� ���� Ʈ���� ��Ʈ ��带 ��ų ����(root)�� �����ϰ� null�� �ʱ�ȭ
	private Node root=null;


	// Ʈ���� Ű�� key�� �����ϴ� �޼ҵ�
	public void insert(int key) {
		root = insertKey(root, key);
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� Ű�� key�� �����ϰ�, ���� �� ��Ʈ�� �����ϴ� �޼ҵ�(��� �˰���)
	private Node insertKey(Node p, int key) {
		if(p == null) {  
			Node newNode = new Node(key);
			return newNode; 
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;  // ��Ʈ �Һ�
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;  // ��Ʈ �Һ�       
		}
		else {  // key = p.key �� ��� ���� ����
			System.out.println("���� ����. �ߺ��� Ű���� �����մϴ�: " + key);
			return p;   // ��Ʈ �Һ�
		}
	}  

	// Ʈ���� ������ȸ�ϸ� ����ϴ� �޼ҵ�
	public void printInorder() {
		inorder(root);
		System.out.println();
	}

	// (3) p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ����ϴ� �޼ҵ�(��� �˰���)
	private void inorder(Node p) {
		if(p!=null) {
			inorder(p.leftChild);
			System.out.print(p.key+" ");
			inorder(p.rightChild);
		}

	}

	// (4) Ʈ���� �ִ� Ű���� �����ϴ� �޼ҵ�(�ݺ� �˰���) - ���� Ʈ���� ��� NoSuchElementException ���� �߻�
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

	// Ʈ���� Ű�� key�� �����ϴ��� ���θ� �����ϴ� �޼ҵ�
	public boolean contains(int key) {
		return search(root, key);
	}

	// (5) p�� ��Ʈ�� �ϴ� Ʈ���� Ű�� key�� �����ϴ��� ���θ� �����ϴ� �޼ҵ�(��� �˰���)
	private boolean search(Node p, int key) {
		if(p==null)
			return false;
		else if(p.key==key)
			return true;
		else
			return search(p.leftChild,key)||search(p.rightChild,key);
	}

	// (6) Ʈ���� Ű�� key�� �����ϴ� �޼ҵ�(�ݺ� �˰���) - ���� ��������(true/false)�� ����
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
		while ���� ������ ���� focusNode�� ������ ��带 ����Ű��,
		parent �� ������ ����� �θ��带 ����Ű�� �ǰ�, ������ ���
		�� �θ��� ����� left���� right������ ���� ������ ������ �ȴ�.
		********************/
		
		while(focusNode.key != key) {
			parent = focusNode; //������ ��带 ã�� �����߿��� focusNode�� ����ؼ� �ٲ�� parent ���� ���⼭ ����صд�.
			
			if(key < focusNode.key) {
				isLeftChild = true; // ������� ��尡 ���ʿ� �ִ� ���� ��Ͽ�
				focusNode = parent.leftChild;
			} else {
				isLeftChild = false; // ������� ��尡 �����ʿ� �ִ� ���� ��Ͽ�
				focusNode = parent.rightChild;
			}
			
			if(focusNode == null) {
				return false;
			}

		}
		
		Node replacementNode;
		//������� ����� �ڽ� ��尡 ���� ���
		if(focusNode.leftChild == null && focusNode.rightChild == null) {
			if (focusNode == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		// ������� ����� ������ �ڽĳ�尡 ���� ��� (���� �ڽ� ��常 �ִ� ���)
		else if(focusNode.rightChild == null) {
			replacementNode = focusNode.leftChild;

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		// ������� ����� ���� �ڽĳ�尡 ���� ��� (������ �ڽ� ��常 �ִ� ���)
		else if (focusNode.leftChild == null) {
			replacementNode = focusNode.rightChild;
			
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
		}
		
		// ������� ����� ���� �ڽĳ�尡 ��� �ִ� ���
		// ������ �ڽ� ����� sub tree ���� ���� ���� ��带 ã�Ƽ� ������� ��尡 �ִ� �ڸ��� ��ġ��Ų��
		else {
			// ������ ����� ������ sub tree �� �����صд�
			Node rightSubTree = focusNode.rightChild;

			// ������ ��� �ڸ��� ���� �� ���ο� ��� (������ sub tree ���� ���� ���� ���� ���� ���)
			// �� ���� ���� child �� ����� �Ѵ� (���� ���� ���̱� ������)
			replacementNode = getRightMinNode(focusNode.rightChild);

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;

			replacementNode.rightChild = rightSubTree;
			// ������� ����� ������ sub tree �� ��尡 �ϳ��ۿ� ���� ���
			if (replacementNode == rightSubTree) 
				replacementNode.rightChild = null;

			replacementNode.leftChild = focusNode.leftChild; // ������� ����� ���� sub tree �� �����Ų��
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

