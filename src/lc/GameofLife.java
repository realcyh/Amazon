package lc;

public class GameofLife {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] copy = new int[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                copy[i][j] = board[i][j];
            }
        }

        int[] neighbor = {0,1,-1};

        for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {
                int liveNeigh = 0;
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        if (!(neighbor[i] == 0 && neighbor[j] == 0)) {
                            int rr = r+neighbor[i];
                            int cc = c+neighbor[j];
                            if ((rr >= 0 && rr<row) && (cc>=0 && cc<col) && copy[rr][cc] == 1 ) {
                                liveNeigh += 1;
                            }

                        }
                    }
                }

                if (copy[r][c] == 1 &&(liveNeigh<2 || liveNeigh>3)) {
                    board[r][c] = 0;
                }
                if (copy[r][c] == 0 && liveNeigh == 3) {
                    board[r][c] = 1;
                }
            }
        }

    }

}
