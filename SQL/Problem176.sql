-- 2018.9.9
/*
https://leetcode.com/problems/second-highest-salary/description/
*/

SELECT (
    SELECT 
        DISTINCT Salary   
    FROM 
        Employee
    ORDER BY 
        Salary DESC
    LIMIT 
        1, 1
) AS SecondHighestSalary