-- 2018.9.9
/*
https://leetcode.com/problems/employees-earning-more-than-their-managers/description/
*/

SELECT e1.Name Employee
FROM Employee e1, Employee e2
WHERE e1.ManagerId = e2.Id AND e1.Salary > e2.Salary