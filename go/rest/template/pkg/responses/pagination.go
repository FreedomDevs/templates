package responses

type Pagination struct {
	Page       int    `json:"page"`
	PageSize   int    `json:"pageSize"`
	Total      int64  `json:"total"`
	TotalPages int    `json:"totalPages"`
	NextPage   string `json:"nextPage,omitempty"`
	PrevPage   string `json:"prevPage,omitempty"`
}
