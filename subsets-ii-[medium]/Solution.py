"""
Backtracking algorithm to generate the superset of the list of nums given to the function
"""
import copy

class Solution:
    def subsetsWithDup(self, nums):
        #base case always include the set itself and the empty set
        ans = []
        nums.sort()
      
        def backtracking(i, subset):

            if i == len(nums):
                ans.append(subset[::])
                return

            # all subsets that include nums[i]
            subset.append(nums[i])
            backtracking(i+1, subset)
            subset.pop()
            
            # all subsets that don't include nums[i]
            # [1,2,2,2,3] <- skip all 2s
            while i + 1 < len(nums) and nums[i] == nums[i+1]:
                i += 1
            backtracking(i+1, subset)

        backtracking(0, [])

        return ans

if __name__ == "__main__":
    s = Solution()
    print(s.subsetsWithDup([1,2,2]))