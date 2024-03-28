from typing import List

class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        d = {}
        # creates a piece table
        for i in range(len(indices)):
            if s.startswith(sources[i], indices[i]):
                d[indices[i]] = i

        ans = ""

        counter = 0
        while counter < len(s):
            if counter in d:
                idx = d.get(counter)
                ans += targets[idx]
                counter += len(sources[idx])
            else:
                ans += s[counter]
                counter += 1
                
        return ans 


if __name__ == '__main__':
    s = Solution()
    print(s.findReplaceString("abcd", [0,2], ["a", "cd"], ["eee", "ffff"]))