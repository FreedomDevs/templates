package routes

import (
	"svc-{{PROJECT_NAME_LOWERCASE}}/internal/handlers"
	"svc-{{PROJECT_NAME_LOWERCASE}}/internal/middleware"

	"github.com/gin-gonic/gin"
)

func Setup() *gin.Engine {

	r := gin.New()

	r.Use(
		middleware.TraceMiddleware(),
		gin.Recovery(),
	)

	r.GET("/live", handlers.Live)
	r.GET("/ready", handlers.Ready)
	r.GET("/health", handlers.Health)

	return r
}
