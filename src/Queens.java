import java.awt.Color;

public class Queens {

	public static final int BOARD_SIZE = 8;
	public static final int EMPTY = 0;
	public static final int QUEEN = 1;
	private int mult, multHalf;
	protected int board[][];

	public Queens() {
		board = new int[BOARD_SIZE][BOARD_SIZE];
		mult = (int) (QueensTest.size / BOARD_SIZE);
		multHalf = mult / 2;
	}
	
	public void drawQueen(int row, int col) {

		StdDraw.setPenColor(Color.blue);
		StdDraw.filledRectangle(col * mult + multHalf, row * mult + multHalf, multHalf, multHalf);

	}

	public void drawEmpty(int row, int col) {
		if ((row % 2 == 1 && col % 2 == 1) || (row % 2 == 0 && col % 2 == 0)) {
			StdDraw.setPenColor(Color.gray);
			StdDraw.filledRectangle(col * mult + multHalf, row * mult + multHalf, multHalf, multHalf);
		} else {
			StdDraw.setPenColor(Color.white);
			StdDraw.filledRectangle(col * mult + multHalf, row * mult + multHalf, multHalf, multHalf);
		}
	}

	public void initBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] == EMPTY) {
					if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
						StdDraw.setPenColor(Color.gray);
						StdDraw.filledRectangle(j * mult + multHalf, i * mult + multHalf, multHalf, multHalf);
					} else {
						StdDraw.setPenColor(Color.white);
						StdDraw.filledRectangle(j * mult + multHalf, i * mult + multHalf, multHalf, multHalf);
					}
				}
			}
		}
	}

	@Deprecated
	public void draw() {

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] == EMPTY) {
					if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
						StdDraw.setPenColor(Color.gray);
						StdDraw.filledRectangle(j * mult + multHalf, i * mult + multHalf, multHalf, multHalf);
					} else {
						StdDraw.setPenColor(Color.white);
						StdDraw.filledRectangle(j * mult + multHalf, i * mult + multHalf, multHalf, multHalf);
					}
				} else {
					StdDraw.setPenColor(Color.blue);
					StdDraw.filledRectangle(j * mult + multHalf, i * mult + multHalf, multHalf, multHalf);
				}
			}
		}
	}

	public boolean placeQueens(int col) throws InterruptedException {
		//draw();
		if (col == BOARD_SIZE) {
			return true;
		}
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (isSafe(i, col)) {
				board[i][col] = QUEEN;
				drawQueen(i, col);
				if (placeQueens(col + 1)) {
					return true;
				}
				board[i][col] = EMPTY;
				drawEmpty(i, col);
			}
		}
		return false;
	}

	// Check if a position is safe
	public boolean isSafe(int row, int col) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (i == col)
				continue;
			if (board[row][i] == QUEEN)
				return false;
		}
		for (int c = 0; c < BOARD_SIZE; c++) {
			int s = (col - c);
			if (s == 0)
				continue;
			if (row + s >= BOARD_SIZE || row + s < 0) {

			} else {
				if (board[row + s][c] == QUEEN) {
					return false;
				}
			}

			if (row - s >= BOARD_SIZE || row - s < 0) {
			} else {
				if (board[row - s][c] == QUEEN)
					return false;
			}
		}

		return true;
	}

}
