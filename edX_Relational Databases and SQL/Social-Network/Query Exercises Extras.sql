--- 1. For every situation where student A likes student B,
------ but student B likes a different student C,
------ return the names and grades of A, B, and C.
SELECT A.name, A.grade, B.name, B.grade, C.name, C.grade
FROM Highschooler A, Highschooler B, Highschooler C, Likes L1, Likes L2
WHERE A.ID = L1.ID1 AND B.ID = L1.ID2
  AND A.ID NOT IN(SELECT ID2 FROM Highschooler OtherH, Likes OtherL
				   WHERE B.ID = OtherL.ID1 AND OtherH.ID = OtherL.ID2)
  AND B.ID = L2.ID1 AND C.ID = L2.ID2;

SELECT A.name, A.grade, B.name, B.grade, C.name, C.grade
FROM Highschooler A, Highschooler B, Highschooler C, Likes L1, Likes L2
WHERE A.ID = L1.ID1 AND B.ID = L1.ID2
  AND B.ID = L2.ID1 AND C.ID = L2.ID2
  AND C.ID <> A.ID;
  
  
--- 2. Find those students for whom all of their friends are in different grades from themselves.
------ Return the students' names and grades.
SELECT A.name, A.grade
FROM Highschooler A
WHERE A.grade NOT IN(SELECT B.grade FROM Highschooler B, Friend
					  WHERE A.ID = Friend.ID1 AND B.ID = Friend.ID2);


--- 3. What is the average number of friends per student?
------ (Your result should be just one number.)
SELECT 1.0 * COUNT(*)/COUNT(DISTINCT ID1) -- 1.0 is used to avoid integer division
FROM Friend;

SELECT AVG(count)
FROM (SELECT COUNT(*) as count
	    FROM Friend
	   GROUP BY ID1) as Counts;


--- 4. Find the number of students who are either friends with Cassandra
------ or are friends of friends of Cassandra. 
------ Do not count Cassandra, even though technically she is a friend of a friend.
SELECT COUNT(DISTINCT B.ID) + COUNT(DISTINCT C.ID)
FROM Highschooler A, Highschooler B, Highschooler C, Friend F1, Friend F2
WHERE A.name = 'Cassandra'
  AND A.ID = F1.ID1 AND B.ID = F1.ID2
  AND B.ID = F2.ID1 AND C.ID = F2.ID2
  AND C.ID <> A.ID;

SELECT directFriends + friendsOfFriends
FROM
	(SELECT COUNT(*) as directFriends
	 FROM Highschooler A, Highschooler B, Friend
	 WHERE A.name = 'Cassandra'
	   AND A.ID = ID1 AND B.ID = ID2) as DirectFriends,
	(SELECT COUNT(*) as friendsOfFriends
	 FROM Highschooler A, Highschooler B, Highschooler C, Friend F1, Friend F2
	 WHERE A.name = 'Cassandra'
	   AND A.ID = F1.ID1 AND B.ID = F1.ID2
	   AND B.ID = F2.ID1 AND C.ID = F2.ID2
	   AND C.ID <> A.ID) as FriendsOfFriends;


--- 5. Find the name and grade of the student(s) with the greatest number of friends.
SELECT name, grade
FROM Highschooler
WHERE (SELECT COUNT(*)
	     FROM Friend
	    WHERE ID = ID1
	  	GROUP BY ID1)
	  =
	  (SELECT MAX(count) as maxNrOfFriends
		 FROM (SELECT COUNT(*) as count
				 FROM Friend
				GROUP BY ID1) as TotalNrOfFriends);

SELECT DISTINCT name, grade
FROM Highschooler, Friend
WHERE ID IN (SELECT ID1 FROM Friend
			 GROUP BY ID1
		    HAVING COUNT(*) = (SELECT MAX(count) as maxNrOfFriends
								 FROM (SELECT COUNT(*) as count
										 FROM Friend
									    GROUP BY ID1) as TotalNrOfFriends));

/* The following query is the simplest, but Postgres does not allow attributes in the SELECT clause
   that are not in the GROUP BY clause */
-- SELECT name, grade
-- FROM Highschooler JOIN Friend ON ID = ID1
-- GROUP BY ID1
-- HAVING COUNT(*) = (SELECT MAX(count) as maxNrOfFriends
-- 					 FROM (SELECT COUNT(*) as count
-- 							 FROM Friend
-- 							GROUP BY ID1) as TotalNrOfFriends);
