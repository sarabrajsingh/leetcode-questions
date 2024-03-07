class Solution:
    def topKFrequent(self, nums, k):
        count = {}
        buckets = [[] for i in range(len(nums) + 1)]

        for n in nums:
            count[n] = 1 + count.get(n, 0)
        for n, c in count.items():
            l = buckets[n]
            l.append(c)
            buckets[n] = l

        print(count)
        print(buckets)

        res = []

        for i in range(len(buckets) - 1, 0 , -1):
            for n in buckets[i]:
                res.append(n)
                if len(res) == k:
                    return res


if __name__ == '__main__':
    s = Solution()

    print(s.topKFrequent([1,2,2,2,2,3], 2))