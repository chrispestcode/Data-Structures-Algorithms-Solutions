package Easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean [][] visited = new boolean[image.length][image[0].length];
        floodFill(image, sr, sc, newColor, image[sr][sc],visited);
        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor, int targetColor, boolean[][] visited) {
        if(image[sr][sc] != targetColor){
            return image;
        }
        image[sr][sc] = newColor;
        visited[sr][sc]= true;
        if (sr < image.length-1 && !visited[sr+1][sc]) {
            floodFill(image, sr+1, sc, newColor,targetColor,visited);
        }
        if (sc < image[0].length-1 && !visited[sr][sc+1]){
            floodFill(image, sr, sc+1, newColor,targetColor,visited);
        }
        if(sr > 0 && !visited[sr-1][sc]) {
            floodFill(image, sr-1, sc, newColor,targetColor,visited);
        }
        if(sc > 0 && !visited[sr][sc-1]) {
            floodFill(image, sr, sc-1, newColor,targetColor,visited);
        }
        return image;
    }
}

/*
https://leetcode.com/problems/flood-fill

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the
image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color),
 and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.



Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.

Runtime > 100% Space > 100%
 */