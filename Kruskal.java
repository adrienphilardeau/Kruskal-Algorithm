import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){
        /* Fill this method (The statement return null is here only to compile) */
    	WGraph A = new WGraph();
        DisjointSets myset = new DisjointSets(g.getNbNodes());
        ArrayList<Edge> edges = g.listOfEdgesSorted();
        for(Edge e : edges){       	
        	if(IsSafe(myset, e)){
        		A.addEdge(e);
        		//System.out.println(A.listOfEdgesSorted());
        		myset.union(e.nodes[0], e.nodes[1]);
        	}
        }
        return A;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){
        /* Fill this method (The statement return 0 is here only to compile) */
    		if(p.find(e.nodes[0]) != p.find(e.nodes[1]))
    			return true;
    		return false;
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
