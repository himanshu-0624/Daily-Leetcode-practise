# Write your MySQL query statement below
update Salary 

set

sex = case sex
    When 'm' Then 'f'
    Else 'm'
    End;