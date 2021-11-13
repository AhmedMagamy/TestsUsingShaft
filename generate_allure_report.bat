@echo off
set path=C:\Users\ahmed\.m2\repository\allure\allure-2.16.0\bin;C:\Users\ahmed\.jdks\openjdk-17.0.1\bin;%path%
allure serve allure-results
pause
exit