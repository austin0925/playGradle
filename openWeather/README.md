# project
* gradle 專案
* 初始化: `gradle build`
* 包裝: `gradle shadowJar`
* 執行: `java -jar ./build/libs/openWeather.jar`
* 可以透過supervisorctl 進行設定啟動

# lib
* java1.8
* gradle 6.2.2
* kotlin 1.x
* okhttp 4.4.1
    
# unit test
* 雖然有看到spek，但是如果以習慣的tool來看使用junit5就可以。
* [ ] gradle test
* [ ] unit test single run
    
# todo
* file path is not clear.
