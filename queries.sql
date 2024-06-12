--Part 1
--SQL TASK: At this point, you will have one table, job.
--In queries.sql under “Part 1”, list the columns and their data types in the table as a SQL comment.

-- Columns in the job table:
-- id: int, not null, primary key
-- employer: varchar(255), nullable
-- name: varchar(255), nullable
-- skills: varchar(255), nullable



--Part 2: Query to list the names of the employers in St. Louis City

SELECT name FROM employer WHERE location = "St. Louis City";



--Part 3

--Part 4
