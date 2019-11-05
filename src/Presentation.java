import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Presentation {
	
	public static void main(String[] args)
	{
		/* number of nodes*/
		int n=20;
		int graph[][];
		
		InputGeneration inputGeneration=new InputGeneration();
		ArrayList<Integer>nodes =inputGeneration.getNodes(n);
		NagamochiIbaraki nagamochiIbaraki=new NagamochiIbaraki(n);
		
		/* Running our analysis */
		Map<Integer,Edge> mp=new HashMap<Integer,Edge>();
		for(int m=19;m<=190;m=m+3)
		{
			
			int sum=0;
			/* taking average of 5 trials */
			for(int i=0;i<5;i++)
			{
				graph=inputGeneration.generateGraph(n, m);
				if(nagamochiIbaraki.isConnected(graph))
				{
					sum+=nagamochiIbaraki.runAlgorithm(graph, nodes);
				}		
			}
			
			sum=sum/5;
			System.out.println("m="+m+"  edge connectivity: "+sum);
			//System.out.println(m+"," + sum);
			
			/* update lowest and highest values of m for which edge connectivity=sum */
			if(!mp.containsKey(sum))
			{
				mp.put(sum, new Edge(m,m));
			}
			else
			{
				Edge e=mp.get(sum);
				mp.put(sum, new Edge(e.getFirst(),m));
			}
			
		}
		
		/* print the spread of each edge connectivity value */
		System.out.println("Spread of edge connectivities...");
		
			mp.forEach((k,v)->System.out.println("Minimum cut="+k+" lowest="+v.getFirst()+" highest: "
			+v.getSecond()+" spread: "+Math.abs(v.getSecond()-v.getFirst())));
			//mp.forEach((k,v)->System.out.println(k+","+Math.abs(v.getSecond()-v.getFirst())));
		
	}

}
