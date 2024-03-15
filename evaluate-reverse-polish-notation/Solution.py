class Solution:
    def evalRPN(self, tokens) -> int:
        stack = []
        for token in tokens:
            if token == "+":
                stack.append(int(stack.pop()) + int(stack.pop()))
            elif token == "*":
                stack.append(int(stack.pop()) * int(stack.pop()))
            elif token == "-":
                a = stack.pop()
                b = stack.pop()
                stack.append(int(b)-int(a))
            elif token == "/":
                n = stack.pop()
                d = stack.pop()
                stack.append(int(n) / int(d))
            else:
                stack.append(token)

        return stack.pop()

if __name__ == '__main__':
    s = Solution()
    print(s.evalRPN(["2","1","+","3","*"]))