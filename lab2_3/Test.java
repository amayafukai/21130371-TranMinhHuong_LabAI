package k21;

import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		Node result = algo1.execute(nodeS, "G");
		Node result1 = algo2.execute(nodeS, "G");
		NodeUtils go = new NodeUtils();
		NodeUtils go1 = new NodeUtils();
		List<String> list= go.printPath(result);
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println(result.getPathCost());

	}
}
