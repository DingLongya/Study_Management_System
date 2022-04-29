#### 问题一

**问题：**在实现异步通信的时候，使用HttpClient的时候会报下面的错误

![image-20220428165302953](C:\Users\lenono\AppData\Roaming\Typora\typora-user-images\image-20220428165302953.png)

**问题描述：**使用了httpClient相关类的库项目时：如Android-async-http时，会出现有一些类找不到的错误，或者找不到HttpClient类。

**问题原因：**android 6.0 （api 23）SDK，不再提供org.apache.http.*(只保留几个类)。

**问题解决：**在相应的，module下的build.gradle中加入代码

```java
android{
   useLibrary 'org.apache.http.legacy'
}
```

![image-20220428165850217](C:\Users\lenono\AppData\Roaming\Typora\typora-user-images\image-20220428165850217.png)

#### 问题二

**问题：**在Android Studio中不能输入中文

![image-20220429084430819](C:\Users\lenono\AppData\Roaming\Typora\typora-user-images\image-20220429084430819.png)

**问题原因：**Android Studio的模拟器的CPU架构是x86的，并不支持一般ARM的软件。

**问题解决：**下载X86的输入法apk进行安装

![image-20220429084935569](C:\Users\lenono\AppData\Roaming\Typora\typora-user-images\image-20220429084935569.png)

![image-20220429085045709](C:\Users\lenono\AppData\Roaming\Typora\typora-user-images\image-20220429085045709.png)

问题三