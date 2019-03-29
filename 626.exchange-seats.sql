--
-- @lc app=leetcode id=626 lang=mysql
--
-- [626] Exchange Seats
--
-- https://leetcode.com/problems/exchange-seats/description/
--
-- database
-- Medium (53.29%)
-- Total Accepted:    20.6K
-- Total Submissions: 38.7K
-- Testcase Example:  '{"headers": {"seat": ["id","student"]}, "rows": {"seat": [[1,"Abbot"],[2,"Doris"],[3,"Emerson"],[4,"Green"],[5,"Jeames"]]}}'
--
-- Mary is a teacher in a middle school and she has a table seat storing
-- students' names and their corresponding seat ids.
-- The column id is continuous increment.
-- 
-- 
-- Mary wants to change seats for the adjacent students.
-- 
-- 
-- Can you write a SQL query to output the result for Mary?
-- 
-- 
-- 
-- 
-- +---------+---------+
-- |    id   | student |
-- +---------+---------+
-- |    1    | Abbot   |
-- |    2    | Doris   |
-- |    3    | Emerson |
-- |    4    | Green   |
-- |    5    | Jeames  |
-- +---------+---------+
-- 
-- For the sample input, the output is:
-- 
-- 
-- 
-- 
-- +---------+---------+
-- |    id   | student |
-- +---------+---------+
-- |    1    | Doris   |
-- |    2    | Abbot   |
-- |    3    | Green   |
-- |    4    | Emerson |
-- |    5    | Jeames  |
-- +---------+---------+
-- 
-- 
-- Note:
-- If the number of students is odd, there is no need to change the last one's
-- seat.
-- 
--
# Write your MySQL query statement below
select
if(id < (select count(*) from seat), if(id mod 2=0, id-1, id+1), if(id mod 2=0, id-1, id)) as id, student
from seat
order by id asc;