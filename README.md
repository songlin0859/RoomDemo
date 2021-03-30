# RoomDemo

[Room 持久性库](https://developer.android.google.cn/topic/libraries/architecture/room?hl=zh_cn&authuser=0)
[使用 Room 将数据保存到本地数据库](https://developer.android.google.cn/training/data-storage/room?authuser=0&hl=zh_cn)

1. 将以下依赖项添加到应用的 build.gradle 文件：
```groovy
dependencies {
  def room_version = "2.2.6"

  implementation "androidx.room:room-runtime:$room_version"
  kapt "androidx.room:room-compiler:$room_version"

  // optional - Kotlin Extensions and Coroutines support for Room
  implementation "androidx.room:room-ktx:$room_version"

  // optional - Test helpers
  testImplementation "androidx.room:room-testing:$room_version"
}

```