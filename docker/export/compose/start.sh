#!/bin/bash
SCRIPT_DIR="$(dirname "$0")"
cd "$SCRIPT_DIR" || exit
docker-compose start