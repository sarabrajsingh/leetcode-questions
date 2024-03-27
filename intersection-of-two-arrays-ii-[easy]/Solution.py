from typing import List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = {}
        res = []
        for num in nums1:
            val = m.get(num, 0)
            m[num] = val + 1

        k = 0

        for num in nums2:
            if num in m:
                if m[num] > 0:
                    res.append(num)
                    m[num] = m[num] - 1
        
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.intersect([1,2,2,1], [2,2]))