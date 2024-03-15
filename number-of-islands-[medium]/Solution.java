import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return this.row == node.row &&
                this.col == node.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

public class Solution {
    public static void bfs(int row, int col, Set<Node> visited, char[][] grid) {
        Queue<Node> q = new LinkedList<>();
        Node n = new Node(row, col);
        q.add(n);
        visited.add(n);

        while (!q.isEmpty()) {
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            Node current = q.poll();

            for (int[] direction : directions) {
                int new_row = current.row + direction[0];
                int new_col = current.col + direction[1];

                if (new_row >= 0 && new_row < grid.length &&
                        new_col >= 0 && new_col < grid[0].length &&
                        grid[new_row][new_col] == '1') {
                    Node newNode = new Node(new_row, new_col);
                    if (!visited.contains(newNode)) {
                        visited.add(newNode);
                        q.add(newNode);
                    }
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        if (grid == null)
            return 0;

        final int rows = grid.length;
        final int cols = grid[0].length;

        int islands = 0;

        final Set<Node> visited = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Node n = new Node(row, col);
                if (grid[row][col] == '1' && !visited.contains(n)) {
                    bfs(row, col, visited, grid);
                    islands++;
                }
            }
        }

        return islands;
    }
    

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }
}
