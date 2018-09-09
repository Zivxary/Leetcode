-- 2018.9.9
/*
https://leetcode.com/problems/customers-who-never-order/description/
*/

SELECT Name AS Customers
FROM Customers
WHERE Customers.Id 
NOT IN (
    SELECT CustomerId 
    FROM Orders
)