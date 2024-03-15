class Solution:
    def increasingTriplet(self, nums) -> bool:

        first = second = third = float('inf')

        for num in nums:
            if num <= first:
                first = num
            elif num <= second:
                second = num
            else:
                return True
    
        return False
    
if __name__ == "__main__":
    s = Solution()
    print(s.increasingTriplet([2,4,-2,-3]))