import java.util.ArrayList;


public class InputGeneration {
	
	
	
	public int[][] generateGraph(int n,int m)
	{
		
		ArrayList<Edge> pairs=selectMEdges(m,n);
		
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
			{
				arr[i][j]=0;
			}
		}
		
		for(int i=0;i<pairs.size();i++)
		{
			Edge edge=pairs.get(i);
			arr[edge.first()][edge.second()]=1;
			arr[edge.second()][edge.first()]=1;
		}
		
		//Utils.printMatrix(arr, n,"Graph topology");
		return arr;
	}
	
	public ArrayList<Integer> getNodes(int n)
	{
		ArrayList<Integer>nodes=new ArrayList<Integer>();
	
	for(int j=0;j<n;j++)
	{
		nodes.add(j);
	}
	return nodes;
	}
	
	
	
	public  ArrayList<Edge> selectMEdges(int m, int n)
	{
		
		int low=0;
		int high=n-1;
		int range=high-low+1;
		
		ArrayList<Edge> edges=new ArrayList<Edge>();
		int i,j;
		while(edges.size()!=m)
		{
			i=(int)(Math.random()*range);
			j=(int)(Math.random()*range);
			if(i==j)
			{
				continue;
			}
			Edge e=new Edge(i,j);
			if(!checkEdgeExists(e,edges))
			{
				
				//System.out.println("Edge "+edges.size()+" : ("+ i+" "+j+") selected");
				edges.add(new Edge(i,j));
			}
			else
			{
				//System.out.println("edge "+i+" "+j+") already there");
				}
			
		}
		return edges;
		
	}
	
	static boolean checkEdgeExists(Edge e, ArrayList<Edge> edges)
	{
		for(int i=0;i<edges.size();i++)
		{
			Edge f=edges.get(i);
			if(f.first()==e.first()&&f.second()==e.second())
			{
				return true;
			}
		}
		return false;
	}
}
