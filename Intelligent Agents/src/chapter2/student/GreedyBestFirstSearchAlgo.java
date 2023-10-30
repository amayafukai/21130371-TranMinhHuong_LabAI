package student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public class  GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
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
						n.setParent(current);
						n.setG(current.getG() + child.getWeight());
						frontier.add(n);
					}
//					else if (n.getG() > current.getG() + child.getWeight()) {
//						n.setParent(current);
//						n.setG(current.getG() + child.getWeight());
//					}	
				}
			}
		}

		frontier.add(root);
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
	    PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparatorByHn());
	    HashSet<Node> visited = new HashSet<>();

	    Node startNode = findNode(root, start);
	    if (startNode == null) {
	      throw new IllegalArgumentException("Start node not found");
	    }

	    Node goalNode = findNode(root, goal);
	    if (goalNode == null) {
	      throw new IllegalArgumentException("Goal node not found");
	    }

	    queue.add(startNode);
	    while (!queue.isEmpty()) {
	      Node currentNode = queue.poll();
	      visited.add(currentNode);

	      if (currentNode.getLabel().equals(goalNode.getLabel())) {
	        return currentNode;
	      }

	      List<Node> children = currentNode.getChildrenNodes();
	      for (Node child : children) {
	        if (!visited.contains(child) && !queue.contains(child)) {
	          child.setParent(currentNode);
	          queue.add(child);
	        }
	      }
	    }

	    return null; // No path found
	  }

	  public Node findNode(Node root, String label) {
	    if (root == null || label == null) {
	      return null;
	    }

	    if (root.getLabel().equals(label)) {
	      return root;
	    }

	    Queue<Node> queue = new LinkedList<>();
	    queue.add(root);

	    while (!queue.isEmpty()) {
	      Node currentNode = queue.poll();
	      if (currentNode != null) {
	        if (currentNode.getLabel().equals(label)) {
	          return currentNode;
	        }
	        queue.addAll(currentNode.getChildrenNodes());
	      }
	    }

	    return null; // Node not found
	  }

}
