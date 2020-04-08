cd /data/mysql/bin/
./mysqldump --defaults-extra-file=/etc/my.cnf ypzw_test > /data/mysql/bak-mysql/ypzw_test-$(date +%Y%m%d).sql
./mysqldump --defaults-extra-file=/etc/my.cnf ammeter > /data/mysql/bak-mysql/ammeter-$(date +%Y%m%d).sql
./mysqldump --defaults-extra-file=/etc/my.cnf spms > /data/mysql/bak-mysql/spms-$(date +%Y%m%d).sql
./mysqldump --defaults-extra-file=/etc/my.cnf interview > /data/mysql/bak-mysql/interview-$(date +%Y%m%d).sql
./mysqldump --defaults-extra-file=/etc/my.cnf smart-assistant > /data/mysql/bak-mysql/smart-assistant-$(date +%Y%m%d).sql