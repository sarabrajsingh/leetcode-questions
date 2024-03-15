class Solution:
    def maxOperations(self, nums, k) -> int:
        count = 0

        l = 0
        r = len(nums) - 1

        #nums.sort()

        while l < r:
            sum = nums[l] + nums[r]
            if sum == k:
                l += 1
                r -= 1
                count += 1
            elif sum > k:
                r -= 1
            else:
                l += 1

        return count

if __name__ == '__main__':
    s = Solution()
    print(s.maxOperations([4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4], 6))