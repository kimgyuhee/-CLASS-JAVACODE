/******************************
���ϸ�: UndirectedListGraph.java
�ۼ���: 2018.12.02
�ۼ���: �����
����: adjacency list�� ������ undirected graph�� �ʺ�켱Ž���� �����Ѵ�.
 *******************************/
package hw10_2;

import java.util.Queue;
import java.util.LinkedList;

public class UndirectedListGraph {
	private class Node{
		int vertex;
		Node link;
		Node(int vertex){
			this.vertex=vertex;
		}
	}

	private Node[] list;
	private int n; // ������
	private boolean[] visited;

	public UndirectedListGraph(int n) {
		this.n=n;
		list=new Node[n];
		visited=new boolean[n];
	}

	public boolean hasEdge(int v1, int v2) {
		Node temp1=list[v1];
		while(temp1!=null) {
			if(temp1.vertex==v2)
				return true;
			temp1=temp1.link;
		}
		return false;
	}

	public void addEdge(int v1, int v2) {
		if(!isValid(v1) || !isValid(v2))
			System.out.println("�߸��� ���� ��ȣ�Դϴ�.");
		else if(hasEdge(v1, v2))
			System.out.println("���� ���� ���� - �̹� �����ϴ� �����Դϴ�.("+v1+", "+v2+")");
		else {
			Node newNode1=new Node(v2);
			newNode1.link=list[v1];
			list[v1]=newNode1;

			Node newNode2=new Node(v1);
			newNode2.link=list[v2];
			list[v2]=newNode2;
		}
	}

	public boolean isValid(int v) {
		return v>=0 && v<n;
	}

	public void printAdjacentVertices(int v) {
		if(!isValid(v))
			System.out.println("�߸��� �����Դϴ�.");
		else {
			Node temp=list[v];
			while(temp!=null) {
				System.out.print(temp.vertex+" ");
				temp=temp.link;
			}
			System.out.println("");
		}
	}

	public void breadthFirstSearch(int vertex) {
		if(!isValid(vertex))
			System.out.println("�߸��� �����Դϴ�.");
		else {
			for(int i=0; i<n;i++) {
				visited[i]=false;
			}
			bfs(vertex);

		}

	}
	private void bfs(int vertex) {
		visited[vertex]=true;
		System.out.print(vertex+" ");
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(vertex);

		while(!q.isEmpty()) {
			int w=q.poll();
			for(int i=0 ;i<n;i++) {
				if(hasEdge(w,i)&&visited[i]==false) {
					visited[i]=true;
					System.out.print(i+" ");
					q.offer(i);
				}

			}
		}
	}

}