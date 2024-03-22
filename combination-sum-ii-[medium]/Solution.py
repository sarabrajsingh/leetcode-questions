from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        res = []

        candidates.sort()

        def backtrack(curr, pos, target):

            if target == 0:
                res.append(curr.copy())

            if target <= 0:
                return
            
            prev = float('-inf')

            for i in range(pos, len(candidates)):

                if candidates[i] == prev:
                    continue

                curr.append(candidates[i])
                backtrack(curr, i + 1, target=(target-candidates[i]))
                curr.pop()

                prev = candidates[i]

        backtrack([], 0, target)

        return res

if __name__ == '__main__':
    s = Solution()
    print(s.combinationSum2([10,1,2,7,6,1,5], 8))