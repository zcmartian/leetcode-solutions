--
-- @lc app=leetcode id=180 lang=mysql
--
-- [180] Consecutive Numbers
--
-- https://leetcode.com/problems/consecutive-numbers/description/
--
-- database
-- Medium (32.50%)
-- Total Accepted:    48.6K
-- Total Submissions: 149.7K
-- Testcase Example:  '{"headers": {"Logs": ["Id", "Num"]}, "rows": {"Logs": [[1, 1], [2, 1], [3, 1], [4, 2], [5, 1], [6, 2], [7, 2]]}}'
--
-- Write a SQL query to find all numbers that appear at least three times
-- consecutively.
-- 
-- 
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  |  1  |
-- | 2  |  1  |
-- | 3  |  1  |
-- | 4  |  2  |
-- | 5  |  1  |
-- | 6  |  2  |
-- | 7  |  2  |
-- +----+-----+
-- 
-- 
-- For example, given the above Logs table, 1 is the only number that appears
-- consecutively for at least three times.
-- 
-- 
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- 
-- 
--
# Write your MySQL query statement below
select distinct l1.num as ConsecutiveNums
from logs l1 join logs l2 on l1.ID+1 = l2.ID 
join logs l3 on l2.ID+1 = l3.ID
where l1.num = l2.num and l1.num = l3.num
