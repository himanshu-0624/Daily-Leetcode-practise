# Write your MySQL query statement below
select g as customer_number from (select count(order_number) as cnt , customer_number as g  from
Orders
group by customer_number
order by cnt DESC  ) as T

limit 1;

