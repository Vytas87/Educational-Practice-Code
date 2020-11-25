--- 1. It's time for the seniors to graduate. Remove all 12th graders from Highschooler.
DELETE FROM Highschooler
WHERE grade = 12;

-- Restore the database:
insert into Highschooler values (1304, 'Jordan', 12);
insert into Highschooler values (1025, 'John', 12);
insert into Highschooler values (1934, 'Kyle', 12);
insert into Highschooler values (1661, 'Logan', 12);


--- 2. If two students A and B are friends, and A likes B but not vice-versa, remove the Likes tuple.
DELETE FROM Likes
WHERE ID1 IN (SELECT Friend.ID1 FROM Friend, Likes
			 WHERE Friend.ID1 = Likes.ID1 AND Friend.ID2 = Likes.ID2
			   AND Friend.ID2 NOT IN(SELECT ID1 FROM Likes
							  		  WHERE ID2 = Friend.ID1));

DELETE FROM Likes
WHERE ID1 IN (SELECT Likes.ID1
			    FROM Friend INNER JOIN Likes USING(ID1)
			   WHERE Friend.ID2 = Likes.ID2)
  AND ID2 NOT IN (SELECT Likes.ID1
			    	FROM Friend INNER JOIN Likes USING(ID1)
			   	   WHERE Friend.ID2 = Likes.ID2);

DELETE FROM Likes
WHERE ID2 IN (SELECT ID2 FROM Friend
			   WHERE Friend.ID1 = Likes.ID1)
  AND ID2 NOT IN (SELECT L.ID1 FROM Likes L
				   WHERE L.ID2 = Likes.ID1);

-- Restore the database:
insert into Likes values(1911, 1247);
insert into Likes values(1641, 1468);


--- 3. For all cases where A is friends with B, and B is friends with C,
------ add a new friendship for the pair A and C. Do not add duplicate friendships,
------ friendships that already exist, or friendships with oneself.
INSERT INTO Friend
SELECT DISTINCT A.ID, C.ID
FROM Highschooler A, Highschooler B, Highschooler C,
	 Friend F1, Friend F2
WHERE A.ID = F1.ID1 AND B.ID = F1.ID2
  AND B.ID = F2.ID1 AND C.ID = F2.ID2
  AND C.ID NOT IN (SELECT ID2 FROM Friend
				    WHERE Friend.ID1 = A.ID)
  AND A.ID <> C.ID;

INSERT INTO Friend
SELECT DISTINCT F1.ID1, F2.ID2
FROM Friend F1, Friend F2
WHERE F1.ID2 = F2.ID1 AND F1.ID1 <> F2.ID2
  AND F2.ID2 NOT IN (SELECT F3.ID2 FROM Friend F3
					  WHERE F3.ID1 = F1.ID1);

Restore the database:
drop table if exists Friend;
create table Friend(ID1 int, ID2 int);
insert into Friend values (1510, 1381);
insert into Friend values (1510, 1689);
insert into Friend values (1689, 1709);
insert into Friend values (1381, 1247);
insert into Friend values (1709, 1247);
insert into Friend values (1689, 1782);
insert into Friend values (1782, 1468);
insert into Friend values (1782, 1316);
insert into Friend values (1782, 1304);
insert into Friend values (1468, 1101);
insert into Friend values (1468, 1641);
insert into Friend values (1101, 1641);
insert into Friend values (1247, 1911);
insert into Friend values (1247, 1501);
insert into Friend values (1911, 1501);
insert into Friend values (1501, 1934);
insert into Friend values (1316, 1934);
insert into Friend values (1934, 1304);
insert into Friend values (1304, 1661);
insert into Friend values (1661, 1025);
insert into Friend select ID2, ID1 from Friend;