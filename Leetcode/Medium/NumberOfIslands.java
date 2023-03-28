class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    count+=
                            islandCheck(grid, i, j);
                }
            }
        }
        return count;
    }

    int islandCheck(char[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j]=='0') return 0;
        if(grid[i][j]=='1') {
            grid[i][j]='2';
            islandCheck(grid,i+1,j);
            islandCheck(grid,i-1,j);
            islandCheck(grid,i,j+1);
            islandCheck(grid,i,j-1);
            return 1;
        }
        return 0;
    }
}

/**
 * https://leetcode.com/problems/number-of-islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 *  return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 *
 * Runtime: Beats 90.61%  Space: Beats 27.65%
 */