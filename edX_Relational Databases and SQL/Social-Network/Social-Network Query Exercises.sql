--- 1. The names of all students who are friends with someone named Gabriel.
SELECT name
FROM Highschooler, Friend
WHERE ID = ID1
	AND ID2 IN (SELECT ID FROM Highschooler
			    WHERE name = 'Gabriel');

SELECT H1.name as FriendsOfaGabriel
FROM Highschooler H1
	JOIN Friend ON H1.ID = Friend.ID1
	JOIN Highschooler H2 ON H2.ID = Friend.ID2
WHERE H2.name = 'Gabriel';


--- 2. For every student who likes someone 2 or more grades younger than themselves,
------ return that student's name and grade, and the name and grade of the student they like.
SELECT H1.name, H1.grade, H2.name, H2.grade
FROM Highschooler H1
	JOIN Likes ON H1.ID = Likes.ID1
	JOIN Highschooler H2 ON H2.ID = Likes.ID2
WHERE H1.grade - H2.grade > 1;

SELECT H.name, H.grade, L.name, L.grade
FROM Highschooler H, Highschooler L, Likes
WHERE H.ID = ID1
	AND L.ID = ID2
	AND ID2 IN(SELECT ID FROM Highschooler
			   WHERE H.grade - L.grade > 1);


--- 3. For every pair of students who both like each other,
------ return the name and grade of both students.
------ Include each pair only once, with the two names in alphabetical order.
SELECT H1.name, H1.grade, H2.name, H2.grade
FROM Highschooler H1
	JOIN Likes L1 ON H1.ID = L1.ID1
	JOIN Highschooler H2 ON H2.ID = L1.ID2
WHERE EXISTS (SELECT ID1 FROM Likes L2
			  WHERE L2.ID1 = H2.ID
			  	AND L2.ID2 = H1.ID)
	  AND H1.name < H2.name;

SELECT H1.name, H1.grade, H2.name, H2.grade
FROM Highschooler H1, Highschooler H2, Likes L1, Likes L2
WHERE H1.ID = L1.ID1 AND H2.ID = L1.ID2
  AND H1.ID = L2.ID2 AND H2.ID = L2.ID1
  AND H1.name < H2.name;
 
 
--- 4. Find all students who do not appear in the Likes table (as a student who likes or is liked)
------ and return their names and grades. Sort by grade, then by name within each grade.
SELECT name, grade
FROM Highschooler
WHERE ID NOT IN (SELECT ID1 FROM Likes)
  AND ID NOT IN (SELECT ID2 FROM Likes)
ORDER BY grade, name;


--- 5. For every situation where student A likes student B, but we have no information about whom B likes
------ (that is, B does not appear as an ID1 in the Likes table), return A and B's names and grades.
SELECT A.name, A.grade, B.name, B.grade
FROM Highschooler A, Highschooler B, Likes
WHERE A.ID = Likes.ID1 AND B.ID = Likes.ID2
  AND B.ID NOT IN(SELECT ID1 FROM Likes);
  
  
--- 6. Find names and grades of students who only have friends in the same grade
------ Return the result sorted by grade, then by name within each grade.
SELECT DISTINCT H1.name, H1.grade
FROM Highschooler H1, Highschooler H2, Friend
WHERE H1.ID = Friend.ID1 AND H2.ID = Friend.ID2
  AND H1.grade = H2.grade
  AND H1.ID NOT IN(SELECT H1.ID FROM Highschooler, Friend
				    WHERE H1.ID = Friend.ID1 AND ID = Friend.ID2
				  	  AND H1.grade <> grade)
ORDER BY H1.grade, H1.name;

SELECT This.name, This.grade
FROM Highschooler This
WHERE This.ID IN(SELECT This.ID FROM Highschooler Other, Friend
		   		  WHERE This.ID = Friend.ID1 AND Other.ID = Friend.ID2
		   	 	    AND This.grade = Other.grade)
  AND This.ID NOT IN(SELECT This.ID FROM Highschooler Other, Friend
				  	  WHERE This.ID = Friend.ID1 AND Other.ID = Friend.ID2
				   		AND This.grade <> Other.grade)
ORDER BY This.grade, This.name;


--- 7. For each student A who likes a student B where the two are not friends,
------ find if they have a friend C in common (who can introduce them!).
------ For all such trios, return the name and grade of A, B, and C.
SELECT DISTINCT A.name, A.grade, B.name, B.grade, C.name, C.grade
FROM Highschooler A, Highschooler B, Highschooler C,
	 Friend FriendA, Friend FriendB,
	 Likes
Where A.ID = Likes.ID1 AND B.ID = Likes.ID2
  AND B.ID NOT IN(SELECT ID2 FROM Friend WHERE A.ID = Friend.ID1)
  AND A.ID = FriendA.ID1 AND C.ID = FriendA.ID2
  AND B.ID = FriendB.ID1 AND C.ID = FriendB.ID2;
  
  
--- 8. Find the difference between the number of students in the school and the number of different first names.
SELECT COUNT(*) - COUNT(DISTINCT name)
FROM Highschooler;


--- 9. Find the name and grade of all students who are liked by more than one other student.
SELECT name, grade
FROM Highschooler
WHERE ID IN (SELECT ID2
			   FROM Likes
			  GROUP BY ID2
			 HAVING COUNT(*) > 1);

/* The following query is the simplest, but Postgres does not allow attributes in the SELECT clause
   that are not in the GROUP BY clause */
-- SELECT name, grade
-- FROM Highschooler JOIN Likes ON ID = ID2
-- GROUP BY ID2
-- HAVING COUNT(*) > 1;