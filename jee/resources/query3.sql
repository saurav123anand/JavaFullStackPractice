-- Aggregate functions (Max,Min,Count,sum,Avg)
-- Q1. find the maximum salary from the employee table
-- select max(salary) from employee;
-- select min(salary) from employee;
-- select count(*) from employee; -- will return number of rows 
-- select count(salary) from employee;
-- select count(distinct(salary)) from employee;
-- select sum(salary) from employee
-- select sum(distinct(salary)) from employee;
-- select avg(distinct(salary)) from employee;

-- Corelated subquery
-- Q1. find all employee details who works in a department
-- select * from emp where exists(select * from dept where dept.eid=emp.eid);

-- Difference between nested subquery, correlated subquery and Joins

-- Q2. find the details of the employee who works in a dept
-- using nested subquery
-- select * from emp where eid in(select eid from dept);

-- using correlated subquery
-- select * from emp where exists(select eid from dept where emp.eid=dept.eid);

-- using joins
-- select ename,address from emp,dept where emp.eid=dept.eid;

-- Q3. finf 4th highest salary
-- select * from employee e1 where 3=(select count(distinct salary) from employee e2 where e2.salary>e1.salary);

-- Q4. Write a SQL query to display name of employees who have 'A' as second character in their names
-- select name from employee where name like '_A%';





 



