# Write your MySQL query statement below
select user_id , MAX(time_stamp) as last_stamp
from Logins
where  YEAR(time_stamp) = 2020
Group by user_id
