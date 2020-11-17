--- 1. The titles of all movies directed by Steven Spielberg.
SELECT title
FROM Movie
WHERE director = 'Steven Spielberg';


--- 2. All years that have a movie that received a rating of 4 or 5, and sort them in increasing order.
SELECT DISTINCT year
FROM Movie, Rating
WHERE Movie.mID = Rating.mID and stars > 3
ORDER by year;


--- 3. Titles of all movies that have no ratings.
SELECT title
FROM Movie
WHERE mID not in (SELECT mID FROM Rating);


--- 4. The names of all reviewers who have ratings with a NULL value for the date.
SELECT name
FROM Reviewer, Rating
WHERE Reviewer.rID = Rating.rID and ratingDate IS NULL;


--- 5. The ratings data in a more readable format: reviewer name, movie title, stars, and ratingDate.
------ Sorted first by reviewer name, then by movie title, and lastly by number of stars.
SELECT name, title, stars, ratingDate
FROM Movie NATURAL JOIN Rating NATURAL JOIN Reviewer
ORDER BY name, title, stars;


--- 6. For all cases where the same reviewer rated the same movie twice and gave it a higher rating the second time,
------ return the reviewer's name and the title of the movie.
SELECT name, title
FROM Movie, Reviewer, Rating R1, Rating R2
WHERE R1.rID = Reviewer.rID
	AND R1.mID = Movie.mID
	AND R1.rID = R2.rID
	AND R1.mID = R2.mID
	AND R1.ratingDate > R2.ratingDate
	AND R1.stars > R2.stars;
	
SELECT name, title
FROM Movie
	INNER JOIN Rating R1 USING (mID)
	INNER JOIN Rating R2 USING (mID, rID)
	INNER JOIN Reviewer USING (rID)
WHERE R1.ratingDate > R2.ratingDate
	AND R1.stars > R2.stars;
	
	
--- 7. For each movie that has at least one rating, find the highest number of stars that movie received.
------ Return the movie title and number of stars. Sort by movie title.
SELECT title, MAX(stars)
FROM Movie NATURAL JOIN Rating
GROUP BY title
ORDER BY title;


--- 8. For each movie, return the title and the 'rating spread', that is,
------ the difference between highest and lowest ratings given to that movie.
------ Sort by rating spread from highest to lowest, then by movie title.
SELECT title, (MAX(stars) - MIN(stars)) Gap
FROM Movie NATURAL JOIN Rating
GROUP BY title
ORDER by Gap DESC, title;


--- 9. Find the difference between the average rating of movies released before 1980
------ and the average rating of movies released after 1980. (Make sure to calculate the average rating for each movie,
------ then the average of those averages for movies before 1980 and movies after.
------ Don't just calculate the overall average rating before and after 1980.)
SELECT AVG(RatingsBefore1980.avg) - AVG(RatingsAfter1980.avg)
FROM (SELECT AVG(stars) as avg
	  FROM Movie NATURAL JOIN Rating
	  WHERE year < 1980
	  GROUP by mID) RatingsBefore1980,
	(SELECT AVG(stars) as avg
	  FROM Movie NATURAL JOIN Rating
	  WHERE year > 1980
	  GROUP by mID) RatingsAfter1980;
