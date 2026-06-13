package codes

import "svc-{{PROJECT_NAME_LOWERCASE}}/pkg/responses"

var (
	SuccessLiveOK = responses.SuccessResponseCode{
		Code:    "LIVE_OK",
		Message: "Сервис жив",
		Status:  200,
	}

	SuccessReadyOK = responses.SuccessResponseCode{
		Code:    "READY_OK",
		Message: "Сервис готов к приёму запросов",
		Status:  200,
	}

	SuccessHealthOK = responses.SuccessResponseCode{
		Code:    "HEALTH_OK",
		Message: "Сервис работает",
		Status:  200,
	}
)
