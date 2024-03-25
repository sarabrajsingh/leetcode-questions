package main

import "fmt"

func search(nums []int, target int) int {

	if len(nums) == 0 {
		return -1
	}

	left := 0
	right := len(nums) - 1

	for left <= right {
		middle := (left + right) / 2

		if nums[middle] == target {
			return middle
		}

		if nums[middle] > target {
			right = middle - 1
		} else if nums[middle] < target {
			left = middle + 1
		}
	}

	return -1
}

func main() {
	nums := []int{-1, 0, 3, 5, 9, 12}
	target := 9

	fmt.Println(search(nums, target))
}
