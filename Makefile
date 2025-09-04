# App: common
# Package: root
# File: Makefile
# Version: 0.1.0
# Author: AI
# Date: 2025-09-04T22:11:01Z
# Exports: build, test
# Description: Simplifies Maven build and test operations.

.PHONY: build test

build:
	./mvnw clean package

test:
	./mvnw test
