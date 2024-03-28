from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        m = {}

        for i in range(len(nums)):
            compliment = target - nums[i]
            if compliment in m:
                return [m.get(compliment), i]
            m[nums[i]] = i

        return None