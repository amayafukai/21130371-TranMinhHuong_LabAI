package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explorer = new ArrayList<Node>();
		frontier.add(root);
		while (frontier.isEmpty() == false) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			else {
				explorer.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node n = child.getEnd();
					if (!explorer.contains(n) && !frontier.contains(n)) {

						frontier.add(n);
						n.setParent(current);
						n.setPathCost(current.getPathCost() + child.getWeight());
					}
					else if (n.getPathCost() > current.getPathCost() + child.getWeight()) {
						n.setParent(current);
						n.setPathCost(current.getPathCost() + child.getWeight());
					}	
				}
			}
		}

		frontier.add(root);
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
