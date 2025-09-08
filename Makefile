# App: common
# Package: root
# File: Makefile
# Version: 0.2.0
# Author: AI
# Date: 2025-09-07T15:30:00Z
# Exports: build, test, docker-up, docker-down, docker-logs
# Description: Simplifies Maven build/test operations and Docker Compose lifecycle.

.PHONY: build test docker-up docker-down docker-logs

build:
	./mvnw clean package

test:
	./mvnw test

docker-up:
	docker compose up -d

docker-down:
	docker compose down

docker-logs:
	docker compose logs -f
