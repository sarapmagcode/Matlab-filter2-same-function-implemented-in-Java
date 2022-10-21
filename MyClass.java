
/*

author:
Mark Jason T. Galang

about:
this program produces the same result upon using filter2(filter, image, 'same') in Matlab

*/

public class MyClass {
    public static void main(String args[]) {
        int[][] mat = new int[][] {
            {20, 20, 20, 10, 10, 10, 10, 10, 10},
            {20, 20, 20, 20, 20, 20, 20, 20, 10},
            {20, 20, 20, 10, 10, 10, 10, 20, 10},
            {20, 20, 10, 10, 10, 10, 10, 20, 10},
            {20, 10, 10, 10, 10, 10, 10, 20, 10},
            {10, 10, 10, 10, 20, 10, 10, 20, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10},
            {20, 10, 20, 20, 10, 10, 10, 20, 20},
            {20, 10, 10, 20, 10, 10, 20, 10, 20}
        };
        int[][] a = new int[][] {
            {-1, -1, 0},
            {-1, 0, 1},
            {0, 1, 1}
        };
        int[][] b = new int[][] {
            {0, -1, -1},
            {1, 0, -1},
            {1, 1, 0}
        };
        int[][] c = new int[][] {
            {-1, -1, -1},
            {2, 2, 2},
            {-1, -1, -1}
        };
        int[][] d = new int[][] {
            {-1, 2, -1},
            {-1, 2, -1},
            {-1, 2, -1}
        };
        int[][] e = new int[][] {
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
        };
        int[][] f = new int[][] {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int[][] g = new int[][] {
            {-1, 0, 1},
            {-1, 0, 1},
            {-1, 0, 1}
        };
        int[][] h = new int[][] {
            {0, -1, 0},
            {-1, 4, -1},
            {0, -1, 0}
        };
        System.out.println("Applying the mask to each pixel:");
        int n = mat.length;
        int[][] newMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //change the last parameter (mask that you want to apply)
                newMat[i][j] = computeCurrentCell(mat, n, i, j, a);
            }
        }
        System.out.println("\nResult after applying the mask:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newMat[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static int computeCurrentCell(int[][] mat, int n, int row, int col, int[][] mask) {
        int[] dx = new int[] {1, -1, 0, 0, -1, -1, 1, 1};
        int[] dy = new int[] {0, 0, 1, -1, 1, -1, 1, -1};
        //should be matching with the indices of mask matrix
        int mkRow = 1, mkCol = 1;
        int ans = mat[row][col] * mask[mkRow][mkCol];
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (0 <= newRow && newRow < n && 0 <= newCol && newCol < n) {
                System.out.print(mat[newRow][newCol] + " * " + mask[mkRow+dx[i]][mkCol+dy[i]]);
                ans += mat[newRow][newCol] * mask[mkRow+dx[i]][mkCol+dy[i]];
            } else {
                System.out.print(0 + " * " +mask[mkRow+dx[i]][mkCol+dy[i]]);
            }
            if (i < dx.length - 1) {
                System.out.print(" + ");
            } else {
                System.out.print(" = ");
            }
        }
        System.out.println(ans);
        return ans;
    }
}