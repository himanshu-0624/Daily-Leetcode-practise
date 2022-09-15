# Write your MySQL query statement below
select Users.name , CASE 
                     when t.distance is null then 0
                    else 
                    t.distance end as travelled_distance from
Users left JOIN (select sum(distance) as distance , user_id from Rides group by Rides.user_id) as t 
ON Users.id = t.user_id
Order by t.distance DESC , Users.name ASC;
