```shell
DB_TYPE=MySQL
DATABASE=sbtest_mysql
TABLES=1
HOST=10.16.9.16
PORT=3306
PASSWORD="sphereEx@2021"
TABLE_SIZE=40000000
TIME=120
THREADS=200


sysbench oltp_read_only --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off cleanup
sysbench oltp_read_only --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off prepare

echo echo $[$(date +%s%N)/1000000] | tee time.log

#sysbench oltp_read_only --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off run | tee oltp_read_only.${DB_TYPE}.txt
sysbench oltp_point_select --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off run | tee oltp_point_select.${DB_TYPE}.txt
sysbench oltp_read_write --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off run | tee oltp_read_write.${DB_TYPE}.txt
# sysbench oltp_write_only --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off run | tee oltp_write_only.${DB_TYPE}.txt
# sysbench oltp_update_index --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off run | tee oltp_update_index.${DB_TYPE}.txt
# sysbench oltp_update_non_index --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off run | tee oltp_update_non_index.${DB_TYPE}.txt
# sysbench oltp_delete --mysql-host=${HOST} --mysql-port=${PORT} --mysql-user=root --mysql-password=${PASSWORD} --mysql-db=${DATABASE} --tables=${TABLES} --table-size=${TABLE_SIZE} --report-interval=5 --time=${TIME} --threads=${THREADS} --max-requests=0 --percentile=99 --mysql-ignore-errors="all" --range_selects=off --rand-type=uniform --auto_inc=off run | tee oltp_delete.${DB_TYPE}.txt

echo echo $[$(date +%s%N)/1000000] | tee -a time.log
```
