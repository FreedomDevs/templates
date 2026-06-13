package middleware

import (
	"github.com/gin-gonic/gin"
	"github.com/google/uuid"
)

func TraceMiddleware() gin.HandlerFunc {
	return func(c *gin.Context) {

		traceID := c.GetHeader("X-Trace-Id")

		if traceID == "" {
			traceID = uuid.NewString()
		}

		c.Request.Header.Set("X-Trace-Id", traceID)

		c.Next()
	}
}
