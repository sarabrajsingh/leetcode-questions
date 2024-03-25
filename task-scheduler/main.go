package main

import (
	"fmt"
	"strings"
)

func leastInterval(tasks []byte, n int) int {
	time := 0

}

func main() {
	t := []string{"A", "A", "A", "B", "B", "B"}
	tJoined := strings.Join(t, " ")
	tasks := []byte(tJoined)
	n := 2

	fmt.Println(leastInterval(tasks, n))
}
