from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        for i in range(len(nums)):
            if nums[i] > 0:
                break
            # need to skip duplicates here too in the sorted array
            if i == 0 or nums[i-1] != nums[i]:
                self.helper(nums, i, res)

        return res
    
    def helper(self, nums: List[int], i : int, res : List[List[int]]):
        left, right = i + 1, len(nums) - 1
        while left < right:
            sum = nums[i] + nums[left] + nums[right]
            if sum < 0:
                left += 1
            elif sum > 0:
                right -=1
            else:
                res.append([nums[i], nums[left], nums[right]])
                left += 1
                right -= 1
                # skip duplicates from the left right
                while left < right and nums[left-1] == nums[left]:
                    left += 1
    
if __name__ == '__main__':
    s = Solution()
    print(s.threeSum([-1,0,1,2,-1,-4]))