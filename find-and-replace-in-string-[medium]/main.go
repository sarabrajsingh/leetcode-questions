package main

import "strings"

func findReplaceString(s string, indices []int, sources []string, targets []string) string {
	m := make(map[int]int)

	for i := 0; i < len(indices); i++ {
		if strings.HasPrefix(s[indices[i]:], sources[i]) {
			m[indices[i]] = i
		}
	}

	var ans strings.Builder

	counter := 0

	for counter < len(s) {
		if idx, ok := m[counter]; ok {
			ans.WriteString(targets[idx])
			counter += len(sources[idx])
		} else {
			ans.WriteByte(s[counter])
			counter++
		}
	}

	return ans.String()
}

func main() {

}
