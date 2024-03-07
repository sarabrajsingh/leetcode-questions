class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1, l2):

        stack_l1 = []
        stack_l2 = []
        
        while l1 is not None:
            stack_l1.append(l1.val)
            l1 = l1.next
        
        while l2 is not None:
            stack_l2.append(l2.val)
            l2 = l2.next

        sum_l1 = 0
        sum_l1_counter = len(stack_l1) - 1

        sum_l2 = 0
        sum_l2_counter = len(stack_l2) - 1

        while stack_l1:
            sum_l1 += stack_l1.pop() * (10 ** sum_l1_counter)
            sum_l1_counter -= 1
        
        while stack_l2:
            sum_l2 += stack_l2.pop() * (10 ** sum_l2_counter)
            sum_l2_counter -= 1

        total = sum_l1 + sum_l2

        total_stack = [int(digit) for digit in str(total)]

        dummy = ListNode()
        cur = dummy
        while total_stack:
            cur.next = ListNode(total_stack.pop())
            cur = cur.next

        return dummy.next

if __name__ == "__main__":
    s = Solution()

    n = Node(2)
    n.next = Node(4)
    n.next.next = Node(3)

    m = Node(5)
    m.next = Node(6)
    m.next.next = Node(4)

    ans = print(s.addTwoNumbers(n, m))