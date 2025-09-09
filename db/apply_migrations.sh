#!/usr/bin/env bash
# App: Customer Registration
# Package: db
# File: apply_migrations.sh
# Version: 0.1.0
# Turns: 3
# Author: AI Agent
# Date: 2025-09-09T19:18:27Z
# Exports: main
# Description: Applies SQL migrations using psql with environment-based connection parameters.

set -euo pipefail

DB_HOST="${DB_HOST:-localhost}"
DB_PORT="${DB_PORT:-5432}"
DB_NAME="${DB_NAME:-postgres}"
DB_USERNAME="${DB_USERNAME:-postgres}"
DB_PASSWORD="${DB_PASSWORD:-postgres}"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

for file in "${SCRIPT_DIR}/migrations"/*.sql; do
  echo "Applying $file"
  PGPASSWORD="${DB_PASSWORD}" psql \
    -h "${DB_HOST}" \
    -p "${DB_PORT}" \
    -U "${DB_USERNAME}" \
    -d "${DB_NAME}" \
    -f "$file"
done
