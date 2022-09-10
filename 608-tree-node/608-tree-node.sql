# Write your MySQL query statement below

select id , 'Root' as type from Tree 
where p_id is null

union

select id , 'Inner' as type from Tree 
where   id IN (SELECT DISTINCT
            p_id
        FROM
            tree
        WHERE
            p_id IS NOT NULL)
        AND p_id IS NOT NULL

union

select id , 'Leaf' as type from Tree 
where id  not in (select p_id from Tree where p_id is not null) AND p_id IS NOT NULL

order by id


