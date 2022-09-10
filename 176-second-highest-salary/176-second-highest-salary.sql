# Write your MySQL query statement below

Select Max(salary) As SecondHighestSalary  from Employee
where salary Not In (Select Max(salary) from Employee);
