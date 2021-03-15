package openWeather

import java.util.*

data class OpenWeatherJson (
    val cod:Int?,
    val message: String?,
    val cnt: Double?,
    val list: ArrayList<WeatherJson>
){

    data class WeatherJson(
            val dt: Long?,
            val main: MainObj?,
            val weather: ArrayList<WeatherObj>?,
            val clouds: CloudsObj?,
            val wind: WindObj?,
            val sys: SysObj?,
            val dt_txt: String?
    ) {
        data class MainObj(
                val temp: Double?,
                val feelsLike: Double?,
                val tempMin: Double?,
                val tempMax: Double?,
                val pressure: Double?,
                val seaLevel: Double?,
                val grndLevel: Double?,
                val humidity: Double?,
                val tempKf: Double?
        )

        data class WeatherObj(
                val id: Int?,
                val main: String?,
                val description: String?,
                val icon: String?
        )

        data class CloudsObj(
                val all: Double?
        )

        data class WindObj(
                val speed: Double?,
                val deg: Double?
        )

        data class SysObj(
                val pod: String?
        )

    }
}