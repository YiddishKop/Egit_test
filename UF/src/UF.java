import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


//hello world


public class UF {
	private int[] id;
	private int count;
	public UF(int N){
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		// TODO
		return id[p];
	}
	
	public void union(int p, int q){
		// TODO
		int pID = find(p);
		int qID = find(q);
		if (pID == qID) return;
		for (int i =0; i < id.length; i++)
			if (id[i] == pID) id[i] = qID;
		count--;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}

}
