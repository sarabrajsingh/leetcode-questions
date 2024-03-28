package main

func twoSum(nums []int, target int) []int {

	m := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		c := target - nums[i]
		if _, ok := m[c]; ok {
			answer := make([]int, 2)
			answer[0] = m[c]
			answer[1] = i
			return answer
		}
		m[nums[i]] = i
	}

	return nil
}
