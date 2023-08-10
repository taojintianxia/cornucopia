#!/bin/bash

read -p "Please input your username: " username

if id "$username" >/dev/null 2>&1; then
    echo "User : $username already exists"
    exit 1
fi

read -s -p "Please input your password: " password_hashed

useradd -m -s /bin/bash "$username"

echo "$username:$password_hashed" | chpasswd --encrypted

echo "Create user : $username successful"
