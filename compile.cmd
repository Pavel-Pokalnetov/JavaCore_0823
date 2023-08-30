::@echo off
@echo change CHCP to UTF-8
@CHCP 65001
@CLS
@echo ========================================
@echo Сборка документации
javadoc.exe -locale ru-RU -protected -splitindex -encoding utf8 -d C:\Users\RedX\Desktop\EDU\JavaCore_0823\Docs  src\main\java\lesson1\main\*.java src\main\java\lesson1\work\*.java

@echo ========================================
@echo Компиляция классов
javac.exe --source-path .\src\main\java -d out .\src\main\java\lesson1\main\*

@echo ========================================
@echo Упаковка JAR
cd out
del /f /q *.jar
jar.exe -c -f DemoCalcDocker.jar -e lesson1.main.DemoCalcDocker .\lesson1\main\DemoCalcDocker.class  .\lesson1\work\*.class
cd ..

@echo ========================================
@echo Сборка Docker образа
@echo.

docker buildx b --tag "demo-calc" .

@echo ========================================
@echo Тестовый запуск контейнера из образа
@echo.
docker run --rm demo-calc
@echo.
pause
