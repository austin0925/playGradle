import com.alibaba.fastjson.JSONObject
import okhttp3.OkHttpClient
import okhttp3.Request
import openWeather.OpenWeatherJson
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun main() {
    println("Hello World!")

    val client = OkHttpClient()

    val request = Request.Builder()  // 實例化一個 Builder
       .url("http://api.openweathermap.org/data/2.5/forecast?q=Taipei&lang=zh_tw&units=metric&appid=5daacbe580881c700f1612c435ecad18")
       .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) throw Throwable("Unexpected code $response")

        for ((name, value) in response.headers) {
            println("$name: $value")
        }

        val responseStr = response.body!!.string()
        println(responseStr)

        val csvFileName = "ISO"+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE).replace(":","") +".csv"
//        val csvFileName = "ISO"+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replace(":","") +".txt"
        val csvDirPath = Paths.get("csv" )
        println(csvDirPath.toUri())
        if(!Files.isDirectory(csvDirPath))Files.createDirectory(csvDirPath)
        println("Dir created...")

        val targetFile = Paths.get(csvDirPath.toString(),File.separator,csvFileName).toFile()

        var openWeatherJson = JSONObject.parseObject(responseStr, OpenWeatherJson::class.java)
        println("openWeatherJson")
        println(openWeatherJson)

        targetFile.printWriter().use { out ->
            out.println(
                "dt"+","+
                "main_temp"+","+
                "main_feels_like"+","+
                "main_temp_min"+","+
                "main_temp_max"+","+
                "main_pressure"+","+
                "main_sea_level"+","+
                "main_grnd_level"+","+
                "main_humidity"+","+
                "main_temp_kf"+","+
                "weather_id"+","+
                "weather_main"+","+
                "weather_description"+","+
                "weather_icon"+","+
                "clouds_all"+","+
                "wind_speed"+","+
                "wind_deg"+","+
                "sys_pod"+","+
                "dt_txt"
            )
            openWeatherJson.list.forEach {
                out.println(
                    "${it.dt}," +
                    "${it.main?.temp}," +
                    "${it.main?.feelsLike}," +
                    "${it.main?.tempMin}," +
                    "${it.main?.tempMax}," +
                    "${it.main?.pressure}," +
                    "${it.main?.seaLevel}," +
                    "${it.main?.grndLevel}," +
                    "${it.main?.humidity}," +
                    "${it.main?.tempKf}," +
                    "${it.weather?.get(0)?.id}," +
                    "${it.weather?.get(0)?.main}," +
                    "${it.weather?.get(0)?.description}," +
                    "${it.weather?.get(0)?.icon}," +
                    "${it.clouds?.all}," +
                    "${it.wind?.speed}," +
                    "${it.wind?.deg}," +
                    "${it.sys?.pod}," +
                    "${it.dt_txt}"
                )
            }
        }

        println("Writed to file")

    }
}