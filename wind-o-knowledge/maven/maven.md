Windows:
1.搭建本地仓库
1) 配置环境变量
>MAVEN_HOME 值为Maven的解压路径
>在path中配置 %MAVEN_HOME%\bin
>查看安装是否正确：在cmd中通过命令：mvn -v
2) 配置仓库 
>在解压路径的conf中的settings.xml，并配置阿里云镜像
>在<settings>标签中的最后添加本地库的设置：
<localRepository>F:\.m2\repository</localRepository>
