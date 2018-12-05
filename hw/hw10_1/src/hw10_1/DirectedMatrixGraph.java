/***************************
���ϸ�: DirectedMatrixGraph.java
�ۼ���: �����
�ۼ���: 2018. 12. 02
���α׷� ����:  adjacency matrix�� ������ directed graph�� ���̿켱Ž���� �����Ѵ�.
 ***************************/
package hw10_1;

public class DirectedMatrixGraph {

	private int[][] matrix; // 2���� �迭
	private int n; //���� �� 
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
			System.out.printf("���� ���� ���� - �߸��� ���� ��ȣ �Դϴ�. <%d, %d>\n",v1,v2);
		else if(hasEdge(v1,v2)==true)
			System.out.printf("���� ���� ���� - �̹� �����ϴ� �����Դϴ�. <%d, %d>\n", v1,v2);
		else
			matrix[v1][v2]=1;
	}


	public void printAdjacentVertices(int vertex) {
		if(vertex<0||vertex>n)
			System.out.println("�߸��� ���� ��ȣ �Դϴ�.");
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
			System.out.println("�߸��� ���� ��ȣ �Դϴ�.");
		else {
			for(int i=0; i<n; i++)
				visited[i]=false;
			System.out.print(vertex+"�� DFS => ");
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