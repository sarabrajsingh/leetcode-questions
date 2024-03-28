from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])

        merged = [intervals[0]]

        for start, end in intervals:
            lastPairEnd = merged[-1][1]

            if start <= lastPairEnd:
                merged[-1][1] = max(end, lastPairEnd)
            else:
                merged.append([start, end])

        return merged

if __name__ == '__main__':
    pass