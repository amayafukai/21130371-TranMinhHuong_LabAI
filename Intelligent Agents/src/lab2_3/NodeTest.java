package k21;

public class NodeTest {
	public static void main(String[] args) {
		Node a = new Node("A");

		// Tạo một nút mới với nhãn "B".
		Node b = new Node("B");

		// Thêm một cạnh từ nút "A" đến nút "B" với chi phí là 10.
		a.addEdge(b, 10);

		// Tạo một nút mới với nhãn "C".
		Node c = new Node("C");

		// Thêm một cạnh từ nút "B" đến nút "C" với chi phí là 20.
		b.addEdge(c, 20);

		// In chi phí của đường dẫn từ nút gốc đến nút "C".
		System.out.println(b.getPathCost()); // 30
	}
}
