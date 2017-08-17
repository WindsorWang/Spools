@set JAVA_TOOL_OPTIONS=-Dfile.encoding=GBK
@echo 选择工程将要运行的环境，输入序号后按回车键结束：
@echo.
@echo #######################################################################
@echo ##                       1. 开发环境                                 ##
@echo ##                       2. 测试环境                                 ##
@echo ##                       3. 预发布环境                               ##
@echo ##                       4. 生产环境                                 ##
@echo #######################################################################
@echo.

@set env=""

:input
@set /p input=请输入序号：
@if %input%==1 (
    @set env=d
) else if %input%==2 (
    @set env=t
) else if %input%==3 (
    @set env=pre
) else if %input%==4 (
    @set env=p
) else (
    @echo 非法的输入！请重试！
    @echo.
    goto input
)

@echo.
@echo 正在打包，请稍等……
@echo.
@set GRADLE_OPTS=-Xmx512m -XX:MaxPermSize=128m
@set JAVA_HOME=C:\Programs\Java\jdk1.8.0_131
@call gradle  -x test --stacktrace --refresh-dependencies -Penv=%env% clean build 

@echo.
@if %ERRORLEVEL%==0 (
    @echo 工程构建完毕！
    @echo.
    @echo 工程打包完毕！请在当前目录下查找war包！
) else (
    @echo 工程构建失败！
)

@echo.
@echo 按任意键退出…… & pause>nul
