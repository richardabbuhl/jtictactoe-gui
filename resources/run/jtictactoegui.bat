@echo off

if not "%JAVA_HOME%" == "" goto USE_JAVA_HOME

set JAVA=java

echo JAVA_HOME is not set.  Unexpected results may occur.
echo Set JAVA_HOME to the directory of your local JDK to avoid this message.
goto SKIP_JAVA_HOME

:USE_JAVA_HOME

set JAVA=%JAVA_HOME%\bin\java

:SKIP_JAVA_HOME

%JAVA% -cp jtictactuegui.jar com.jmentor.jtictactoegui.tictactest %1 %2 %3 %4 %5 %6
