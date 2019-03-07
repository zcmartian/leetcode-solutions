--
-- @lc app=leetcode id=196 lang=mysql
--
-- [196] Delete Duplicate Emails
--
-- https://leetcode.com/problems/delete-duplicate-emails/description/
--
-- database
-- Easy (30.78%)
-- Total Accepted:    63.5K
-- Total Submissions: 206.4K
-- Testcase Example:  '{"headers": {"Person": ["Id", "Email"]}, "rows": {"Person": [[1, "john@example.com"], [2, "bob@example.com"], [3, "john@example.com"]]}}'
--
-- Write a SQL query to delete all duplicate email entries in a table named
-- Person, keeping only unique emails based on its smallest Id.
-- 
-- 
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Id is the primary key column for this table.
-- 
-- 
-- For example, after running your query, the above Person table should have
-- the following rows:
-- 
-- 
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
-- 
-- 
-- Note:
-- 
-- Your output is the whole Person table after executing your sql. Use delete
-- statement.
-- 
--
# Write your MySQL query statement below
DELETE P1
FROM Person p1
JOIN Person p2 on p1.Email = p2.Email
AND p1.ID > p2.ID
