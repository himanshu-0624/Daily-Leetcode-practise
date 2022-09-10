# Write your MySQL query statement below

select employee_id from Employees 
where employee_id NOT IN(select employee_id from Salaries)
UNION
select employee_id from  Salaries
where employee_id NOT IN(select employee_id from Employees)
ORDER BY employee_id 

