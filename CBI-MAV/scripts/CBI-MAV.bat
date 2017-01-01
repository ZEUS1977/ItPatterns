set CLASSPATH=./lib/commons-beanutils-1.8.3.jar
set CLASSPATH=%CLASSPATH%;./lib/commons-codec-1.10.jar
set CLASSPATH=%CLASSPATH%;./lib/commons-collections4-4.1.jar
set CLASSPATH=%CLASSPATH%;./lib/commons-lang3-3.1.jar
set CLASSPATH=%CLASSPATH%;./lib/commons-logging-1.2.jar
set CLASSPATH=%CLASSPATH%;./lib/dom4j-1.6.1.jar
set CLASSPATH=%CLASSPATH%;./lib/flatworm-2.0.1.jar
set CLASSPATH=%CLASSPATH%;./lib/junit-4.12.jar
set CLASSPATH=%CLASSPATH%;./lib/log4j-1.2.17.jar
set CLASSPATH=%CLASSPATH%;./lib/poi-3.15.jar
set CLASSPATH=%CLASSPATH%;./lib/poi-examples-3.15.jar
set CLASSPATH=%CLASSPATH%;./lib/poi-excelant-3.15.jar
set CLASSPATH=%CLASSPATH%;./lib/poi-ooxml-3.15.jar
set CLASSPATH=%CLASSPATH%;./lib/poi-ooxml-schemas-3.15.jar
set CLASSPATH=%CLASSPATH%;./lib/poi-scratchpad-3.15.jar
set CLASSPATH=%CLASSPATH%;./lib/stax-api-1.0.1.jar
set CLASSPATH=%CLASSPATH%;./lib/xmlbeans-2.3.0.jar
set CLASSPATH=%CLASSPATH%;./CBI-MAV-1.0.0.jar

java  -cp %CLASSPATH% it.zeussoft.cbiflat.mav.TracciatoClient .\scambiodati\in\input.xls .\resources\flatworm\cbi-mav.xml .\scambiodati\out\output.txt