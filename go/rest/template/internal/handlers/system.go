package handlers

import (
	"svc-{{PROJECT_NAME_LOWERCASE}}/pkg/codes"
	"svc-{{PROJECT_NAME_LOWERCASE}}/pkg/responses"

	"github.com/gin-gonic/gin"
)

func Live(c *gin.Context) {

	responses.SendSuccessResponse(
		codes.SuccessLiveOK,
		gin.H{
			"alive": true,
		},
		c,
	)
}

func Ready(c *gin.Context) {

	responses.SendSuccessResponse(
		codes.SuccessReadyOK,
		gin.H{
			"ready": true,
		},
		c,
	)
}

func Health(c *gin.Context) {

	responses.SendSuccessResponse(
		codes.SuccessHealthOK,
		gin.H{
			"status": "UP",
			"ready":  true,
			"details": gin.H{
				"service": "OK",
			},
		},
		c,
	)
}
