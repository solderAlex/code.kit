## 生成符合自己idea版本的插件

### 1. 打开build.gradle文件

#### 将version修改成自己idea版本
```xml
intellij {
    version '2019.3.5'
    plugins = ['java']
    sameSinceUntilBuild = true
}
```

```xml
group 'com.yy.shophub'
version '2019.3.5'
```

### 2. 在idea编译器右侧Gradle找到

code.kit -> Tasks -> build -> build执行

### 3. 在build/libs找到相应的包