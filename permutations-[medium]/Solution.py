class Solution:
    def permute(self, nums):
        result = []

        # base case
        if len(nums) == 1:
            return [nums[:]]

        for i in range(len(nums)):
            n = nums.pop(0)

            perms = self.permute(nums)

            for perm in perms:
                perm.append(n)
            
            result.extend(perms)
            nums.append(n)
        
        return result

if __name__ == "__main__":
    s = Solution()
    print(s.permute([1,2,3]))