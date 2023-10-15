package k21;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node m1, Node m2) {
		// TODO Auto-generated method stub
		int re=Double.compare(m1.getPathCost(), m2.getPathCost());
		if(re==0) {
			return m1.getLabel().compareTo(m2.getLabel());
		}
		else return re;
	}

}
