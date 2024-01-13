import collections


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        cols = collections.defaultdict(set)
        rows = collections.defaultdict(set)
        squares = collections.defaultdict(set) # key = (row / 3, col / 3)

        for row in range(9):
            for col in range(9):
                if board[row][col] == ".":
                    continue
                if (
                    board[row][col] in rows[row] or # if board[row][col] in rows[row] then we've seen this number in the row before
                    board[row][col] in cols[col] or # if board[row][col] in cols[col] then we've seen this number in the col before
                    board[row][col] in squares[(row // 3, col // 3)] # if board[row][col] in squares[(r // 3, c // 3)] then we've seen this number in the 3x3 square before
                ):
                    return False
            
            rows[row].add(board[row][col])
            cols[col].add(board[row][col])
            squares[(row // 3, col // 3)].add(board[row][col])

        return True

if __name__ == '__main__':
    s = Solution()