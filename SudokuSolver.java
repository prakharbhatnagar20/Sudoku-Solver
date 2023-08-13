package beginJava;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[][] { {3, 0, 6, 5, 0, 8, 4, 0, 0},
			{5, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 8, 7, 0, 0, 0, 0, 3, 1},
			{0, 0, 3, 0, 1, 0, 0, 8, 0},
			{9, 0, 0, 8, 6, 3, 0, 0, 5},
			{0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			{1, 3, 0, 0, 0, 0, 2, 5, 0},
			{0, 0, 0, 0, 0, 0, 0, 7, 4},
			{0, 0, 5, 2, 0, 6, 3, 0, 0} };
		System.out.println(solve(board));
		display(board);
		

	}
	static boolean solve(int[][] board) {
		int n = board.length;
		int row=-1;
		int col=-1;
		boolean emptyLeft = true;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]==0) {
					row=i;
					col=j;
					emptyLeft = false;
					break;
							
				}
				
			}
			if(emptyLeft==false) {
				break;
			}
			
		}
		if(emptyLeft==true) {
			return true;
		}
		for(int number=1;number<=9;number++) {
			if(isSafe(board, row, col, number)) {
				board[row][col]=number;
				if(solve(board)) {
					return true;
				}
				else {
					board[row][col]=0;
				}
			}
			
		}
		return false;
	}
	
	static boolean isSafe(int[][] board, int row, int col, int num) {
//		check row
		for(int i=0;i<board.length;i++) {
			if(board[row][i]==num) {
				return false;
			}
		}
//		check column
		for(int[] nums: board) {
			if(nums[col]==num) {
				return false;
			}
		}
//		check in block matrix
		int sqrt = (int)(Math.sqrt(board.length));
		int rowStart = row-row%sqrt;
		int colStart = col-col%sqrt;
		
		for(int r=rowStart;r<rowStart+sqrt;r++) {
			for(int c=colStart;c<colStart+sqrt;c++) {
				if(board[r][c]==num) {
					return false;
				}
			}
		}
		return true;
	}
	private static void display(int[][] board) {
		for(int[] row: board) {
			for(int num: row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
