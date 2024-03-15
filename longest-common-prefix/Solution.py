class Solution:
    def longestCommonPrefix(self, strs) -> str:

        if len(strs) == 1:
            return strs[0]

        res = ""

        sorted(strs)

        counter = 0

        first = strs[0]
        if len(strs) > 1:
            second = strs[len(strs) - 1]

        if first == second:
            return first
            
        while(first[counter] == second[counter]):
            counter += 1

        return first[0:counter]
    
if __name__ == '__main__':
    s = Solution()

    print(s.longestCommonPrefix(["","b"]))