import java.util.ArrayList;
public class Test {
	
	public static void main(String[] args)
	{
		int n=20;
		int graph[][];
		InputGeneration inputGeneration=new InputGeneration();
		ArrayList<Integer>nodes =inputGeneration.getNodes(n);
		NagamochiIbaraki nagamochiIbaraki=new NagamochiIbaraki(n);
		for(int m=19;m<=190;m=m+3)
		{
			
			int sum=0;
			for(int i=0;i<5;i++) {
				graph=inputGeneration.generateGraph(n, m);
				if(nagamochiIbaraki.isConnected(graph))
				{
					sum+=nagamochiIbaraki.runAlgorithm(graph, nodes);
				}
				
			
			}
			sum=sum/5;
			System.out.println("m= "+m+" Minimum cut size:"+sum);
			
		}
	}

}
