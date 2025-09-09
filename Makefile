# App: common
# Package: root
# File: Makefile
# Version: 0.3.0
# Turns: 1,3
# Author: AI Agent
# Date: 2025-09-09T19:18:27Z
# Exports: build, test, docker-up, docker-down, docker-logs, db-migrate
# Description: Simplifies Maven build/test operations, Docker Compose lifecycle, and database migrations.

.PHONY: build test docker-up docker-down docker-logs db-migrate

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

db-migrate:
	./db/apply_migrations.sh
