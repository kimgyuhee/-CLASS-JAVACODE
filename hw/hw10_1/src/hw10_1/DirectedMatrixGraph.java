/***************************
파일명: DirectedMatrixGraph.java
작성자: 김규희
작성일: 2018. 12. 02
프로그램 설명:  adjacency matrix로 구현한 directed graph의 깊이우선탐색을 이해한다.
 ***************************/
package hw10_1;

public class DirectedMatrixGraph {

	private int[][] matrix; // 2차원 배열
	private int n; //정점 수 
	private boolean[] visited;

	public DirectedMatrixGraph(int n) {
		this.n=n;
		matrix=new int[n][n];
		visited=new boolean[n];
	}

	public boolean hasEdge(int v1, int v2) {
		if(matrix[v1][v2]==1)
			return true;
		return false;
	}

	public void addEdge(int v1, int v2) {
		if((v1<0||v1>=n)||(v2<0||v2>=n))
			System.out.printf("간선 삽입 오류 - 잘못된 정점 번호 입니다. <%d, %d>\n",v1,v2);
		else if(hasEdge(v1,v2)==true)
			System.out.printf("간선 삽입 오류 - 이미 존재하는 간선입니다. <%d, %d>\n", v1,v2);
		else
			matrix[v1][v2]=1;
	}


	public void printAdjacentVertices(int vertex) {
		if(vertex<0||vertex>n)
			System.out.println("잘못된 정점 번호 입니다.");
		else {
			for(int a=0; a<n;a++) {
				if(matrix[vertex][a]==1)
					System.out.print(a+" ");
			}
			System.out.println("");
		}
	}
	public void depthFirstSearch(int vertex) {
		if(vertex<0||vertex>n)
			System.out.println("잘못된 정점 번호 입니다.");
		else {
			for(int i=0; i<n; i++)
				visited[i]=false;
			System.out.print(vertex+"의 DFS => ");
			dfs(vertex);
			System.out.println("");
		}
	}

	private void dfs(int vertex) {
		visited[vertex]=true;
		System.out.print(vertex+" ");
		for(int i=0; i<n;i++) {
			if(matrix[vertex][i]==1&&!visited[i])
				dfs(i);
		}
	}
}