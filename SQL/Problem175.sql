-- 2018.9.9
/*
https://leetcode.com/problems/combine-two-tables/description/
*/

SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address
ON Person.PersonId = Address.PersonId