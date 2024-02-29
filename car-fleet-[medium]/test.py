import openai

while True:
    user_input = input("User: ")

    response = openai.ChatCompletion.create(
        model="gpt-3",  # Use a different model if desired
        message=user_input,
        completion_type="text",
        parameters={# Additional parameters, such as temperature, can be added here if desired
        },
        max_tokens=200,  # The maximum number of tokens to return
        stop_sequence="\n",  # Stop when the chatbot generates a newline character
    )

    print(f"Bot: {response.choices[0].text}")