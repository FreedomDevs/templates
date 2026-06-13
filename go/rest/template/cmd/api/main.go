package main

import (
	"log"
	"svc-{{PROJECT_NAME_LOWERCASE}}/internal/config"
	"svc-{{PROJECT_NAME_LOWERCASE}}/internal/routes"
)

func main() {

	cfg := config.MustLoad()

	router := routes.Setup()

	log.Printf("starting service on port %s", cfg.App.Port)

	err := router.Run(":" + cfg.App.Port)
	if err != nil {
		panic(err)
	}
}
