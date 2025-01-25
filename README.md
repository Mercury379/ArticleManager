# ArticleManager
第一次学习SpringBoot和Vue时课程作业，纯手搓，练习产物，留念作用

### 简介
本文章管理应用系统是一个基于Vue3和SpringBoot的前后端分离系统，同时遵守了MVC模式，将系统划分为视图层、控制层、业务层和持久层，从而使得各层之间的职责更加清晰，提高了代码的可读性和可维护性。
1. 在视图层，本系统使用了Vue3对应的Element Plus进行页面的设计和开发，并采用TypeScript编写静态页面上动作的响应，用axios实现对后端路由的异步请求。
2. 在控制层，本系统使用了SpringBoot框架中本质的SpringMVC的理念通过注解映射路由地址，创建相应的控制器类，通过调用Service层的方法来处理前端的请求和返回数据。
3. 在业务层，本系统创建了Service接口及其ServiceImpl实现类来对Controller传递来的数据的清洗、转换和计算等操作。本系统通过Spring的控制反转和依赖注入来调用持久层Mapper类中的相应方法完成数据处理。
4. 在持久层，本系统使用了MyBatis来与MySQL数据库进行交互。通过持久层框架中的Mapper接口供服务层调用，其中所有的SQL语句均在Mapper.xml中实现。
5. 在工具类中，由于要实现前后端不同端口的交互，需要配置跨域相关的配，同时对于数据库中的每个表均要为其构建其实体类，供所有层使用。

### 安装与运行
JavaProject为java代码，loginpage为前端，npm run serve运行。
