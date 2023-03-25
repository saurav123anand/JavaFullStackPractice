-- SQL Queries and Subqueries
-- Q1. Write a SQL query to display maximum Salary from employee table
-- select max(salary) from employee;

-- Q2. Write a SQL query to display employee name who is taking maximum salary 
-- select name from employee where salary=(select max(salary) from employee);

-- Q3. Write a SQL query to display second highest Salary from employee table
-- select max(salary) from employee where salary<>(select max(salary) from employee); -- <> is used for not equal to 

-- Q4. Write a SQL query to display employee name who is taking second highest salary 
-- select name from employee where salary =(select max(salary) from employee where salary<>(select max(salary) from employee));

-- Q5. Write a query to display all the dept names along with the no. of employees working in that
-- select dept,count(*) from employee group by dept;
-- or we can write
-- select dept,count(dept) from employee group by dept; 
	
-- Q6. Write a SQL query to display all the dept names where number of employees are less that 2
-- select dept from employee group by dept having count(*) <2;
-- If you want to find the name also 
-- select name from employee where dept in (select dept from employee group by dept having count(*) <2);

-- Q7. Write a SQL query to display highest salary department wise and name of employee who is taking that salary
-- select name from employee where salary in(select max(salary) from employee group by dept);

-- in/not in
-- Q8. Write a SQL query to find the employee whose address is either Delhi or chandigarh or pune
-- select * from emp where address in ('Delhi','Chandigarh','pune');
-- select * from emp where address not in ('Delhi','Chandigarh','pune');

-- Q9. Write a SQL query to find the name of employees who are working on a project
-- select ename from emp where eid in(select distinct eid from project);

-- exists/not exists--> used for corelated query(in corelated query outer query runs first)
-- Q10. write a SQL query to find the details of the employee who is working on at least one project
select * from emp where exists (select eid from project where emp.eid=project.eid);

 