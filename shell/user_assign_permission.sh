#!/bin/bash

GROUP_NAME=$1
DIRECTORY=$2

sudo groupadd "${GROUP_NAME}"
sudo gpasswd -a "$USER" "${GROUP_NAME}"

sudo chown "$USER:${GROUP_NAME}" "${DIRECTORY}"
