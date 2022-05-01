#### 问题一

**问题：** 在实现异步通信的时候，使用HttpClient的时候会报下面的错误

![](/image/1.png)

**问题描述：** 使用了httpClient相关类的库项目时：如Android-async-http时，会出现有一些类找不到的错误，或者找不到HttpClient类。

**问题原因：** android 6.0 （api 23）SDK，不再提供org.apache.http.*(只保留几个类)。

**问题解决：** 在相应的，module下的build.gradle中加入代码

```java
android{
   useLibrary 'org.apache.http.legacy'
}
```

![](/image/2.png)

#### 问题二

**问题：** 在Android Studio中不能输入中文

![](/image/3.png)

**问题原因：** Android Studio的模拟器的CPU架构是x86的，并不支持一般ARM的软件。

**问题解决：** 下载X86的输入法apk进行安装

![](/image/4.png)

![](/image/5.png)

问题三

**问题：** 使用Android Studio自带的模拟器播放声音的时候，播放不出来声音，总是莎莎的电流声。

**问题解决：** 下载了mumu模拟器，使用mumu模拟器作为Android Studio的模拟机，解决了声音播放的问题。