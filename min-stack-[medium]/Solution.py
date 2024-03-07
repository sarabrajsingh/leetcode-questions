class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        min = min(val, self.min[-1] if self.min else val)
        self.min.append(min)

    def pop(self) -> None:
        self.stack.pop()
        self.min.pop()


    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int: 
        return self.min[-1]
    
if __name__ == '__main__':
    minStack = MinStack()
    minStack.push(2)
    minStack.push(0)
    minStack.push(3)
    minStack.push(0)

    print(minStack.getMin())
    minStack.pop()

    print(minStack.getMin())
    minStack.pop()

    print(minStack.getMin())
    minStack.pop()

    print(minStack.getMin())