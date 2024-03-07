package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
)

type User struct {
	ID      int     `json:"id`
	Name    string  `json:"name"`
	Email   string  `json:"email"`
	Age     int     `json:"age"`
	Address Address `json:"address"`
}

type Address struct {
	Street string `json:"street"`
	City   string `json:"city"`
	State  string `json:"state"`
	Zip    string `json:"zip"`
}

func main() {
	resp, err := http.Get("http://localhost:8080/users")
	if err != nil {
		log.Fatal("couldn't hit GET request endpoint")
	}

	// body, err := io.ReadAll(resp.Body)
	// if err != nil {
	// 	log.Fatal("couldn't read response body")
	// }

	defer resp.Body.Close()

	var users []User
	if err = json.NewDecoder(resp.Body).Decode(&users); err != nil {
		log.Fatal("couldn't unmarshal json")
	}

	for _, user := range users {
		fmt.Println(user)
	}
}
