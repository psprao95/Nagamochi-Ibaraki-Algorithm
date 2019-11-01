import java.util.ArrayList;

public class NagamochiIbaraki {
	
	private int n;
	private ArrayList<Integer> nodes;
	private int[][] graph;
	NagamochiIbaraki(int n)
	{
		this.n=n;
	}
	
	
	public static void main(String[] args)
	{
		int n=20;
		InputGeneration inputGeneration=new InputGeneration();
		int [][]graph=inputGeneration.generateGraph(20, 19);
		NagamochiIbaraki nagamochiIbaraki=new NagamochiIbaraki(n);
		System.out.println("Graph connectivity: "+nagamochiIbaraki.isConnected(graph));
	}
	
	public int runAlgorithm(int graph[][],ArrayList<Integer> nodes )
	{
		int p=nodes.size();
		//System.out.println("Number of nodes: "+p);
		if(nodes.size()==2)
		{
			//System.out.println("Reached base case");
			//Utils.printMatrix(graph, n, "Contracted graph");
			return getDegree(graph,nodes);
		}
		
		//int p=nodes.size();
		
			nodes=maximumAdjacency(graph,nodes);
			//Utils.printList(nodes,"Maximum Adjacency Ordering");
			int a =getDegree(graph,nodes);
			graph=contractGraph(graph,nodes);
			nodes.remove(nodes.size()-1);
			int b=runAlgorithm(graph,nodes);
			return Math.min(a,b);
		
	}
		
	
	public int getDegree(int graph[][],ArrayList<Integer>nodes)
	{
		int p=nodes.size();
		int node=nodes.get(p-1);
		int degree=0;
		for(int i=0;i<p-1;i++)
		{
			
				degree=degree+graph[node][nodes.get(i)];
			
		}

		return degree;
	}
	
	public int[][] contractGraph(int graph[][],ArrayList<Integer>nodes)
	{
		int p=nodes.size();
		int x=nodes.get(p-2);
		int y=nodes.get(p-1);
		graph[x][y]=0;
		graph[y][x]=0;
		for(int i=0;i<p-2;i++)
		{
			
			int k=nodes.get(i);
			
				graph[x][k]+=graph[y][k];
			
		}
		
		//System.out.println("Node "+y+" contracted into "+x);
		return graph;
	}
	
	public ArrayList<Integer> maximumAdjacency(int [][] graph, ArrayList<Integer> nodes)
	{
		
		
		ArrayList<Integer> temp=new ArrayList<Integer>();
		int p=nodes.size();
		int v=(int)(Math.random()*p);
		int v1=nodes.get(v);
		
		temp.add(v1);
		
		for(int i=2;i<=p;i++)
		{
			v=chooseNode(graph,nodes,temp);
			temp.add(v);
			
		}
		return temp;
	}
	
	
	public int chooseNode(int graph[][], ArrayList<Integer> nodes,ArrayList<Integer> cur_set)
	{
		int node=0,res=-1,count;
		int p=nodes.size();
		int q=cur_set.size();
		for(int i=0;i<p;i++)
		{
			int k=nodes.get(i);
			if(cur_set.contains(k))
			{
				continue;
			}
			
			count=0;
			for(int j=0;j<q;j++)
			{
				if(graph[k][cur_set.get(j)]==1)
						{count++;
						}
						
			}
			if(count>res)
			{
				res=count;
				node=k;
			}
		}
		return node;
	}
	
	public boolean isConnected(int graph[][])
	{
		nodes=new ArrayList<Integer>();
		this.graph=graph;
		DFS(0);
		if(nodes.size()!=n)
		{
			return false;
		}
		return true;
		
	}
	
	
	public void DFS(int v)
	{
		nodes.add(v);
		for(int i=0;i<n;i++)
		{
			if(graph[v][i]!=0&&!nodes.contains(i))
			{
				DFS(i);
			}
		}
		
	}
}
