package student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
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
						n.setG(current.getG() +n.getH()+ child.getWeight());
					}
					else if (n.getG() > current.getH() + child.getWeight()) {
						frontier.remove(n);
						n.setParent(current);
						n.setG(current.getG()+ child.getWeight());
						frontier.add(n);
					}	
				}
			}
		}

		frontier.add(root);
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		
		return null;
	}
}
