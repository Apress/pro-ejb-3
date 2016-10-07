call ../config/setenv

call ../glassfish/lib/ant/bin/ant -f ../config/common.xml stop_server
call ../glassfish/lib/ant/bin/ant -f ../config/common.xml stop_db

pause
