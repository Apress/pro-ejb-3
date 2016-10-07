call ../config/setenv

cd ..
%JAVA_HOME%/bin/java  -Xmx256m -jar glassfish-installer*.jar

cd glassfish
xcopy ..\lib\junit-4.0.jar ..\glassfish\lib\ant\lib
call ../glassfish/lib/ant/bin/ant -f setup.xml

pause
