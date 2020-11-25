--- 1. Add the reviewer Roger Ebert to your database, with an rID of 209.
INSERT INTO Reviewer VALUES(209, 'Roger Ebert');

-- Restore the database:
DELETE FROM Reviewer
WHERE rID = 209;


--- 2. For all movies that have an average rating of 4 stars or higher, add 25 to the release year.
------ (Update the existing tuples; don't insert new tuples.)
UPDATE Movie
SET year = year + 25
WHERE Movie.mID in (SELECT Movie.mID
					  FROM Movie NATURAL JOIN Rating
				     GROUP BY Movie.mID
				    HAVING AVG(stars) >= 4);

-- Restore the database:
UPDATE Movie SET year = 1937 WHERE mID = 106;
UPDATE Movie SET year = 2009 WHERE mID = 107;


--- 3. Remove all ratings where the movie's year is before 1970 or after 2000,
------ and the rating is fewer than 4 stars.
DELETE FROM Rating
WHERE mID IN(SELECT mID FROM Movie NATURAL JOIN Rating
			  WHERE year < 1970 OR year > 2000)
  AND stars < 4;

drop table if exists Rating;
create table Rating(rID int, mID int, stars int, ratingDate date);
insert into Rating values(201, 101, 2, '2011-01-22');
insert into Rating values(201, 101, 4, '2011-01-27');
insert into Rating values(202, 106, 4, null);
insert into Rating values(203, 103, 2, '2011-01-20');
insert into Rating values(203, 108, 4, '2011-01-12');
insert into Rating values(203, 108, 2, '2011-01-30');
insert into Rating values(204, 101, 3, '2011-01-09');
insert into Rating values(205, 103, 3, '2011-01-27');
insert into Rating values(205, 104, 2, '2011-01-22');
insert into Rating values(205, 108, 4, null);
insert into Rating values(206, 107, 3, '2011-01-15');
insert into Rating values(206, 106, 5, '2011-01-19');
insert into Rating values(207, 107, 5, '2011-01-20');
insert into Rating values(208, 104, 3, '2011-01-02');