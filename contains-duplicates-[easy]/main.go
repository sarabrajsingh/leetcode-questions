package main

import "fmt"

func containsDuplicate(nums []int) bool {

	if len(nums) <= 1 {
		return false
	}

	x := make(map[int]struct{})

	for _, val := range nums {
		if _, ok := x[val]; ok {
			return true
		}

		x[val] = struct{}{}
	}

	return false
}

func main() {
	fmt.Println(containsDuplicate([]int{1, 2, 3, 1}))
}
