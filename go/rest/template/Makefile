APP_NAME=svc-{{PROJECT_NAME_LOWERCASE}}
BINARY=bin/$(APP_NAME)

help:
	@echo "make run         - run service"
	@echo "make build       - build binary"
	@echo "make tidy        - go mod tidy"
	@echo "make clean       - remove build artifacts"

run:
	go run ./cmd/api

build:
	go build -o $(BINARY) ./cmd/api

tidy:
	go mod tidy

clean:
	rm -rf bin
