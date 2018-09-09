-- 2018.9.9
/*
https://leetcode.com/problems/rising-temperature/description/
*/

SELECT 
    w1.Id
FROM 
    Weather w1, 
    (
        SELECT 
            DATE_ADD(RecordDate, INTERVAL 1 DAY) AS NextDate,
            Temperature
        FROM
            Weather
    ) w2
WHERE 
    w1.RecordDate = w2.NextDate AND 
    w1.Temperature > w2.Temperature