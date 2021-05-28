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


/*
1. get employee first_name, last_name through emp_log checking that the day/month/year for entryTime and exitTime is same for each row
*/



/*
2. delete data from emp_log where the entryTime and exitTime is not on the same day, or exitTime is before entryTime
*/ 



/*
3. if there are multiple log entries available for the same day for a given employee, how do you go about keeping just 1 row for the set, the row with the maximum time difference (exitTime - entryTime), while deleting the remaining
*/



/*
4. which employee has stayed in office the longest, use emp_log table
sum up the hours from multiple days for the same employee
*/



