import collections

class Solution:
    def numIslands(self, grid) -> int:
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        # keep track of visited nodes with set()
        visited = set()
        islands = 0

        def bfs(row, col):
            q = collections.deque()
            visited.add((row, col))
            q.append((row, col))

            while q:
                r, c = q.popleft()
                directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
                
                for dr, dc in directions:
                    new_row, new_col = r + dr, c + dc
                    if new_row in range(rows) and new_col in range(cols) and (new_row, new_col) not in visited and grid[new_row][new_col] == "1":
                        visited.add((new_row, new_col))
                        q.append((new_row, new_col))

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == "1" and (row, col) not in visited:
                    bfs(row, col)
                islands += 1

        return islands