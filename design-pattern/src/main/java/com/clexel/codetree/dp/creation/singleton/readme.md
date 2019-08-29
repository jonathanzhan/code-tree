单例模式是设计模式中最简单的模式之一。通常，普通类的构造函数是公有的，外部类可以通过 ` new 构造函数()`来生成多个实例，但是，如果将类的构造函数设置为私有，外部类就无法调用该构造函数，也就无法生成多个实例。这时该类自身必须定义一个静态私有实例，并向外提供一个静态的公有函数用于创建或获取该静态私有实例。
<!-- more -->
### 单例模式的定义与特点

单例(singleton)模式的定义:指一个类只有一个实例,且该类能自行创建这个实例的一种模式，例如，windows中只能打开一个任务管理器,这样可以避免因打开多个任务管理器窗口而造成内存资源的浪费或出现各个窗口显示内容不一致的问题。
在计算机系统中,还有windows的回收站、操作系统中的文件系统、多线程中的线程池、显卡的驱动程序对象、打印机的后台处理服务、应用程序的日志对象、数据库连接池、网站计数器、web应用的配置对象、应用程序中的对话框、系统缓存等常常都被设计成单例
单例模式有三个特点:

* 单例类只有一个实例对象
* 该单例对象必须由单例类自行创建
* 单例类对外提供一个访问该单例的全局访问点

### 单例模式的结构

单例模式的主要角色如下:

* 单例类:包含一个实例且能自行创建这个实例的类
* 访问类：使用单例的类

### 单例模式的实现

#### 饿汉式单例模式

#### 懒汉式单例模式

#### 懒汉式单例模式(线程同步)

#### DLC双重检查 volatile

#### 静态内部类实现

#### 枚举