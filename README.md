# Customer Registration Service

## Local DB via Docker
cp .env.example .env
docker compose up -d postgres

## Running with Local Profile and .env
cp .env.example .env
export $(grep -v '^#' .env | xargs) && mvn spring-boot:run -Dspring-boot.run.profiles=local
# If using Docker Compose for the app container, Compose will inject env automatically.
