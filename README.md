# 坚决抵制不负责任的教学培养方案，抵制本末倒置的课程设计，抵制不利于培养学生思维能力的低质量课程！

# 这个简陋的项目适合什么人？

HITSZ 大三就读生，为了完成数据库系统课程的实验四，但**几乎没有前后端开发的基础**。

期望在**后端**使用 **`Java` 语言**进行开发，对 `Java` 语言较为熟悉。

>   如果倾向于使用 `Python` 语言，建议移步 [hewei2001/campus-canteen-ordering](https://github.com/hewei2001/campus-canteen-ordering.git)。

期望使用 **WEB 前端**开发。

>   当然也可以不使用 WEB 前端，而使用 `Java Swing`、`Android` 等客户端。

# 这个项目用了哪些技术？该怎么学？

本项目没有使用高大上的前后端开发框架，使用的都是**基础开发技术**，

>   至于为什么不使用开发框架，在[接下来的问题](#为什么我要使用如此丑陋的原生html组件)中有讲。

如果你***前后端开发零基础***，那么学习该项目涉及到的技术，一定对你的**开发能力**有重要帮助。因为这些都是**基础技术**，*是绝不会轻易过时的，学习其他更高级的框架必须要建立在这些基础之上*。

具体涉及到的**前后端技术和学习资源**如下：

-   计算机网络通信：

    -   `HTTP` 协议：计算机网络应用层的一种通信协议。遵循这个协议，**浏览器**可以向**服务器**发送 **`HTTP` 请求**，既可以**向服务器发送数据**，又可以**从服务器中获取数据**，并以**网页**的形式展示给用户。

        >   常用的**浏览器**有：Chrome, Edge, Firefox, Safari, ...... 。

    -   `Tomcat` 服务器：一种 WEB 应用服务器，可以运行遵循 `Jakarta Servlet` 规范的 **`Java` 服务端应用程序**，可以驱动 **WEB 前端页面**。浏览器向 `Tomcat` 服务器发送 `HTTP` 请求，就可以获取其上的 WEB 前端页面，并调用到 `Java` 服务端应用程序，为用户呈现出一个个网页。

        >   接下来会介绍什么是 `Jakarta Servlet` 和 WEB 前端页面

-   后端：

    -   `Java` 语言基础：应该在 HITSZ 大二下学期学过了。
    -   `JDBC`：使用 `Java` 语言连接数据库的规范。本质是一个类库，使用其中的类，可以**操作数据库**，进行**增删改查**等操作。
    -   `Jakarta Servlet`：一套 `Java` 服务端应用的开发规范。本质是一个类库，使用其中的类，可以开发出服务端应用程序，这些程序能运行在 `Tomcat` 服务器上，为前端提供一操作数据库等服务。

-   前端：

    -   `HTML JavaScript CSS`：前端 WEB 开发的三大基础语言。
        -   `HTML` 用于***确定网页整体结构、骨架***。
        -   `JavaScript` 用于***书写网页内蕴含的交互逻辑***。
        -   `CSS` 用于***装饰网页细节，让页面更美观***。
    -   `AJAX`：一种**前后端异步通信**技术，前端页面可以向后端服务器发送 **`AJAX` 请求**，从而获取少量数据，对页面进行**局部更新**，而不是全局重新加载页面。

-   学习资源：

    -   `HTML JavaScript CSS`：[【老杜最新HTML+CSS+JavaScript基础到精通视频教程全套完整版】](https://www.bilibili.com/video/BV18p4y1B7JR/?share_source=copy_web&vd_source=680b4fce60843e338596195a7d3c88a4)

        -   P1——P15、P18——P30
        -   P33——P45
        -   P47——P109、P112——P115

    -   `AJAX`：[【动力节点最新Ajax教程-快速搞定ajax】](https://www.bilibili.com/video/BV1cR4y1P7B1/?p=3&share_source=copy_web&vd_source=680b4fce60843e338596195a7d3c88a4)

        -   P1——P13

    -   `JDBC`：[【动力节点老杜2020最新版JDBC零基础教程-IDEA版】](https://www.bilibili.com/video/BV17V411v7SL/?share_source=copy_web&vd_source=680b4fce60843e338596195a7d3c88a4)

        -   P1——P9、P12——P15

    -   `Java Servlet` 、 `Tomcat` 服务器和 `HTTP` 协议：[【动力节点最新JavaWeb视频教程,javaweb零基础入门到精通IDEA版】](https://www.bilibili.com/video/BV1Z3411C7NZ/?share_source=copy_web&vd_source=680b4fce60843e338596195a7d3c88a4)

        -   P1——P11

        -   P15——P26

        -   P32、P34——P35

        -   P43——P49

    -   [SunDocker 个人博客](https://sundocker.gitee.io/)：在个人博客中对以上知识均有清晰的整理

        >   个人博客还在搭建中，许多知识尚未整理，敬请期待 ...... 。

    >   注意，上面列出的不代表都要看完，看到掌握了**这项技术大致框架**的程度即可，不着急填充框架内的细节知识，能上手开发了就快速去做 lab4 的项目，不要浪费时间在不一定能用到的细节知识上

# 为什么我要使用如此丑陋的原生HTML组件？

我并不是不会 `CSS` 框架，也不是不会装饰 WEB 页面，

>   可以参考我的另一个项目 [wisdom-world](https://github.com/SunDocker/wisdom-world-app.git)，前端使用了 `Vue` 框架和 `ElementUI` 框架
>
>   在线访问：http://47.113.188.89:8080

而是因为这门课叫**数据库系统**，这个实验的重点是***数据库从概念层面到逻辑层面，再到物理层面的设计***，而不是前端UI设计。

我认为，***在前端方面内卷，把页面设计得十分高大上，对于这个实验是没有任何意义的***，很多时候无意义的内卷就是这么来的！

要卷请去卷数据库的设计，**去把数据库设计得更加低冗余、高效率**，这才是有意义的事，是符合数据库课程的！

# 项目预览

在线访问：http://47.113.188.89:8082/camvol/

 
