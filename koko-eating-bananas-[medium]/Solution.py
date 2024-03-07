import math

class Solution:
    def minEatingSpeed(self, piles, h: int) -> int:
        l, r = 1, max(piles)
        res = r

        while l <= r:
            mid = (l + r) // 2

            total_t = 0

            for pile in piles:
                total_t += math.ceil(float(pile) / mid)
            
            if total_t <= h:
                res = mid
                r = mid - 1
            else:
                l = mid + 1

        return res

if __name__ == '__main__':
    s = Solution()
    print(s.minEatingSpeed([3,6,7,11], 8))
