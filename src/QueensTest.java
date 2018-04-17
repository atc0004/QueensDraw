
public class QueensTest {
	public static double size = 1000;

	public static void main(String[] args) throws InterruptedException {

		
		StdDraw.setCanvasSize((int) size, (int) size);
		StdDraw.setXscale(0.0, size);
		StdDraw.setYscale(0.0, size);

		Queens q = new Queens();
		q.initBoard();
		long timeStart = System.currentTimeMillis();
		q.placeQueens(0);
		
		System.out.println("Took the algorithm + drawing: " + (double) (System.currentTimeMillis() - timeStart) / 1000 + " seconds.");
		
		
	}
}
