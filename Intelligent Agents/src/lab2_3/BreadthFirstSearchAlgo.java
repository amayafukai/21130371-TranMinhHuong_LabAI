package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explorer = new ArrayList<Node>();
		frontier.add(root);
		while (frontier.isEmpty()==false) {
			Node test=frontier.poll();
			if(test.getLabel().equals(goal)) return test;
			explorer.add(test);
			List<Node> list=test.getChildrenNodes();
			for (Node n : list) {
				if(frontier.contains(n)==false&&explorer.contains(n)==false)
					frontier.add(n);
				n.setParent(test);
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
