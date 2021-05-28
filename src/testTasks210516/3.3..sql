/*
You have the following schema.
You can also use commands like `show tables` and `desc employees`

employees                             projects
+---------------+---------+           +---------------+---------+
| id            | int     |<----+  +->| id            | int     |
| first_name    | varchar |     |  |  | title         | varchar |
| last_name     | varchar |     |  |  | start_date    | date    |
| salary        | int     |     |  |  | end_date      | date    |
| department_id | int     |--+  |  |  | budget        | int     |
+---------------+---------+  |  |  |  +---------------+---------+
                             |  |  |
departments                  |  |  |  employees_projects
+---------------+---------+  |  |  |  +---------------+---------+
| id            | int     |<-+  |  +--| project_id    | int     |
| name          | varchar |     +-----| employee_id   | int     |
+---------------+---------+     |     +---------------+---------+
                                |         
                                |       emp_log              
                                |       +-------------+-----------+
                                +-------| employee_id | int       |
                                        | entryTime   | timestamp |
                                        | exitTime    | timestamp |
                                        +-------------+-----------+
*/

--Adaptation for ORACLE

/*
1. get employee first_name, last_name through emp_log checking that the day/month/year for entryTime and exitTime is same for each row
*/
SELECT e.first_name, e.last_name
  FROM employees e,
       emp_log el
  WHERE e.id = el.employee_id
        AND TRUNC(t.entrytime) = TRUNC(t.exittime);


/*
2. delete data from emp_log where the entryTime and exitTime is not on the same day, or exitTime is before entryTime
*/
DELETE emp_log
  WHERE TRUNC(entrytime) != TRUNC(exittime)
        OR entrytime > exittime;
COMMIT;


/*
3. if there are multiple log entries available for the same day for a given employee, how do you go about keeping just 1 row for the set, the row with the maximum time difference (exitTime - entryTime), while deleting the remaining
*/
 MERGE INTO emp_log el USING
 (SELECT el.*,
       MAX(exittime) OVER (PARTITION BY employee_id, TRUNC(entrytime)) mx,
       ROW_NUMBER() OVER (PARTITION BY employee_id, TRUNC(entrytime) ORDER BY exittime) rn,
       COUNT(*) OVER (PARTITION BY employee_id, TRUNC(entrytime)) cn
  FROM emp_log el) vw
  ON (el.employee_id = vw.employee_id AND el.entrytime = vw.entrytime)
  WHEN MATCHED THEN UPDATE SET el.exittime = vw.mx
                      WHERE vw.cn > 1
                    DELETE WHERE rn > 1;
COMMIT;




/*
4. which employee has stayed in office the longest, use emp_log table
sum up the hours from multiple days for the same employee
*/
SELECT employee_id, hours
  FROM (SELECT employee_id, sum(interval) hours
          FROM (SELECT employee_id, TRUNC(entrytime) et,
                   (cast(exittime as date) - cast(entrytime as date))*24 interval
                  FROM emp_log  )
          GROUP BY employee_id
          ORDER BY 2 DESC)
  WHERE rownum = 1;

