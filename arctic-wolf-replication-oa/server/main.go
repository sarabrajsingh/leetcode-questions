package main

import (
	"encoding/json"
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
	user1 := User{
		ID:    1,
		Name:  "John Doe",
		Email: "john.doe@gmail.com",
		Age:   30,
		Address: Address{
			Street: "123 Main Street",
			City:   "New York",
			State:  "NY",
			Zip:    "10001",
		},
	}

	user2 := User{
		ID:    2,
		Name:  "John Doe 2",
		Email: "john.doe2@gmail.com",
		Age:   31,
		Address: Address{
			Street: "1234 Main Street",
			City:   "New York",
			State:  "NY",
			Zip:    "10002",
		},
	}

	var users []User
	users = append(users, user1)
	users = append(users, user2)

	http.HandleFunc("/users", func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "application/json")

		jsonData, err := json.Marshal(users)
		if err != nil {
			http.Error(w, err.Error(), http.StatusInternalServerError)
			return
		}

		w.Write(jsonData)
	})

	log.Println("starting server on :8080")
	log.Fatal(http.ListenAndServe(":8080", nil))
}
