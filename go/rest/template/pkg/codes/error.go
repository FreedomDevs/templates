package codes

import "svc-{{PROJECT_NAME_LOWERCASE}}/pkg/responses"

var (
	ErrInternalError = func(err error) responses.ErrorResponseCode {
		return responses.ErrorResponseCode{
			Code:    "INTERNAL_ERROR",
			Message: err.Error(),
			Status:  500,
		}
	}
)
