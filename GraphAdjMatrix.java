import java.util.Iterator;
import java.util.LinkedList;

public class GraphAdjMatrix implements Graph{
	
	int[][] edges;
	int size;
	
	public GraphAdjMatrix(int size) {
		this.size = size;
		edges = new int[size][size];
	}

	public void addEdge(int v1, int v2) {
		edges[v1][v2] = 1;
	}
	
	public void topologicalSort() {
		boolean[] visited = new boolean[size];
		topologicalSort(0, visited);
	}
	
	private void topologicalSort(int v, boolean[] visited) {
		if(!visited[v]) {
			System.out.println(v);
			visited[v] = true;
			Iterator<Integer> it = getNeighbors(v).iterator();
			while(it.hasNext()) 
				topologicalSort(it.next(), visited);
		}	
		else {
			System.out.println("There is a cycle");
		}
	}

	public int[] neighbors(int vertex) {
		int nLength = 0;
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(edges[vertex][i] == 1)
				nLength++;		
		}
		int[] neighbors = new int[nLength];
		for(int i = 0; i < size; i++) {
			if(edges[vertex][i] == 1)
				neighbors[count++] = i;	
		}
		return neighbors;
	}
	
	private LinkedList<Integer> getNeighbors(int v) {
		LinkedList<Integer> neighbors = new LinkedList<Integer>();
		for(int i = 0; i < size; i++) {
			if(edges[v][i] == 1) 
				neighbors.add(new Integer(i));
		}
		return neighbors;
	}

}
