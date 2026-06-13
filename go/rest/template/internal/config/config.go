package config

import "github.com/ilyakaznacheev/cleanenv"

type Config struct {
	App struct {
		Name string `env:"APP_NAME"`
		Env  string `env:"APP_ENV"`
		Port string `env:"APP_PORT"`
	}
}

func MustLoad() *Config {

	var cfg Config

	err := cleanenv.ReadConfig(".env", &cfg)
	if err != nil {
		panic(err)
	}

	return &cfg
}
