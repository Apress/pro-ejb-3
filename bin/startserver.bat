call ../config/setenv

call ../glassfish/lib/ant/bin/ant -f ../config/common.xml start_db
call ../glassfish/lib/ant/bin/ant -f ../config/common.xml start_server

pause
