--- 1. The names of all reviewers who rated Gone with the Wind.
SELECT DISTINCT name
FROM Movie NATURAL JOIN Rating NATURAL JOIN Reviewer
WHERE title = 'Gone with the Wind';


--- 2. For any rating where the reviewer is the same as the director of the movie,
------ return the reviewer name, movie title, and number of stars.
SELECT name, title, stars
FROM Movie NATURAL JOIN Rating NATURAL JOIN Reviewer
WHERE name = director;


--- 3. A all reviewer names and movie names together in a single list, alphabetized.
SELECT title as name FROM Movie
UNION
SELECT name FROM Reviewer
ORDER BY name;


--- 4. The titles of all movies not reviewed by Chris Jackson.
------ (NOTE: not all movies were rated.)
SELECT title
FROM Movie
EXCEPT
SELECT title
FROM Movie NATURAL JOIN Rating NATURAL JOIN Reviewer
WHERE name = 'Chris Jackson';


--- 5. For all pairs of reviewers such that both reviewers gave a rating to the same movie,
------ return the names of both reviewers. Eliminate duplicates, don't pair reviewers with themselves,
------ and include each pair only once. For each pair, return the names in the pair in alphabetical order.
SELECT DISTINCT J1.name, J2.name
FROM (Rating NATURAL JOIN Reviewer) J1,
	 (Rating NATURAL JOIN Reviewer) J2
WHERE J1.mID = J2.mID
	AND J1.name <> J2.name
	AND J1.name < J2.name
ORDER BY J1.name, J2.name;

SELECT DISTINCT Rev1.name, Rev2.name
FROM Rating R1, Rating R2, Reviewer Rev1, Reviewer Rev2
WHERE R1.mID = R2.mID
	AND R1.rID = Rev1.rID
	AND R2.rID = Rev2.rID
	AND Rev1.name < Rev2.name
ORDER BY Rev1.name, Rev2.name;


--- 6. For each rating that is the lowest (fewest stars) currently in the database,
------ return the reviewer name, movie title, and number of stars.
SELECT name, title, stars
FROM Rating NATURAL JOIN Movie NATURAL JOIN Reviewer
WHERE stars <= ALL(SELECT stars FROM Rating);

SELECT name, title, stars
FROM Rating NATURAL JOIN Movie NATURAL JOIN Reviewer
WHERE stars = (SELECT MIN(stars) FROM Rating);


--- 7. List movie titles and average ratings, from highest-rated to lowest-rated.
------ If two or more movies have the same average rating, list them in alphabetical order.
SELECT title, AVG(stars) as avgRating
FROM Movie NATURAL JOIN Rating
GROUP BY title
ORDER BY avgRating DESC, title;


--- 8. Find the names of all reviewers who have contributed three or more ratings.
------ (As an extra challenge, try writing the query without HAVING or without COUNT.)
SELECT name
FROM Reviewer
WHERE rID in (SELECT R1.rID
			 FROM Rating R1, Rating R2, Rating R3
			 WHERE R1.rID = R2.rID
			   AND R2.rID = R3.rID
			  /* For two rows under consideration to be different, either their dates have to be different,
			  	 or one of them must be NULL,
			  	 or, if the dates are both NULL, then at least one of the other attributes (mID or stars) has to be different*/
			   AND (R1.ratingDate < R2.ratingDate
				   OR (R1.ratingDate IS NULL AND R2.ratingDate IS NOT NULL)
				   OR (R1.ratingDate IS NOT NULL AND R2.ratingDate IS NULL)
				   OR (R1.ratingDate IS NULL AND R2.ratingDate IS NULL AND (R1.stars <> R2.stars OR R1.mID <> R2.mID)))
			   AND (R2.ratingDate < R3.ratingDate
				   OR (R2.ratingDate IS NULL AND R3.ratingDate IS NOT NULL)
				   OR (R2.ratingDate IS NOT NULL AND R3.ratingDate IS NULL)
				   OR (R2.ratingDate IS NULL AND R3.ratingDate IS NULL AND (R2.stars <> R3.stars OR R2.mID <> R3.mID))));

SELECT name
FROM Reviewer NATURAL JOIN Rating
GROUP BY name
HAVING COUNT(*) > 2;


--- 9. Some directors directed more than one movie. For all such directors,
------ return the titles of all movies directed by them, along with the director name.
------ Sort by director name, then movie title.
------ (As an extra challenge, try writing the query both with and without COUNT.)
SELECT M1.title, M1.director
FROM Movie M1, Movie M2
WHERE M1.director = M2.director
  AND M1.title <> M2.title
ORDER BY M1.director, M1.title;

SELECT title, director
FROM Movie
WHERE director IN (SELECT director
					FROM Movie
					GROUP BY director
					HAVING COUNT(*) > 1)
ORDER BY director, title;


--- 10. Find the movie(s) with the highest average rating.
------- Return the movie title(s) and average rating.
------- (Hint: This query is more difficult to write in SQLite than other systems;
------- you might think of it as finding the highest average rating and then choosing the movie(s) with that average rating.)
SELECT title, avgRating
FROM   (SELECT title, AVG(stars) as avgRating
		FROM Movie NATURAL JOIN Rating
		GROUP BY title) as Movies
WHERE avgRating = (SELECT MAX(Movies.avgRating) as maxRating
				  FROM (SELECT title, AVG(stars) as avgRating
						FROM Movie NATURAL JOIN Rating
						GROUP BY title) as Movies);


--- 11. Find the movie(s) with the lowest average rating.
------- Return the movie title(s) and average rating.
------- (Hint: This query may be more difficult to write in SQLite than other systems;
------- you might think of it as finding the lowest average rating and then choosing the movie(s) with that average rating.)
SELECT title, avgRating
FROM   (SELECT title, AVG(stars) as avgRating
		FROM Movie NATURAL JOIN Rating
		GROUP BY title) as Movies
WHERE avgRating = (SELECT MIN(Movies.avgRating) as maxRating
				  FROM (SELECT title, AVG(stars) as avgRating
						FROM Movie NATURAL JOIN Rating
						GROUP BY title) as Movies);
					

--- 12. For each director, return the director's name together with the title(s) of the movie(s)
------- they directed that received the highest rating among all of their movies,
------- and the value of that rating. Ignore movies whose director is NULL.

/* The following query is the simplest, but Postgres does not allow attributes in the SELECT clause
   that are not in the GROUP BY clause */
-- SELECT director, title, MAX(stars) as maxRating
-- FROM Movie NATURAL JOIN Rating
-- WHERE director IS NOT NULL
-- GROUP BY director;

SELECT DISTINCT CommonTable.director, CommonTable.title, CommonTable.stars
FROM (Movie NATURAL JOIN RATING) as CommonTable
	  JOIN
	 (SELECT director, MAX(stars) as maxRating
	  FROM Movie NATURAL JOIN Rating
	  WHERE director IS NOT NULL
	  GROUP BY director) as DirectorMaxRatings
	  ON CommonTable.director = DirectorMaxRatings.director
	  WHERE stars = maxRating;

SELECT *
FROM (SELECT director, title, stars
	  FROM Movie NATURAL JOIN Rating
	  WHERE director IS NOT NULL
	  GROUP BY director, title, stars
	  ORDER BY director, title, stars) as DirectorRatings1
WHERE stars >= ALL (SELECT stars
				    FROM (SELECT director, title, stars
						  FROM Movie NATURAL JOIN Rating
						  WHERE director IS NOT NULL
						  GROUP BY director, title, stars
						  ORDER BY director, title, stars) as DirectorRatings2
					WHERE DirectorRatings1.director = DirectorRatings2.director);