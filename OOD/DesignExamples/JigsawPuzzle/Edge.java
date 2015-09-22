package JigsawPuzzle;

public class Edge {
	enum Type { inner, outer, flat }
	Piece parent;
	Type type;
	int index; // Index to pieces.edges
	Edge attached_to;
	
	public boolean fitsWith(Edge edge) { return true; }
	
}
