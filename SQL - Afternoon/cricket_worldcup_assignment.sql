create database cricket_worldcup;
use cricket_worldcup;

-- 1. Create sample data in all the tables. -- 

 create table teams(
	t_id varchar(3),
    team_name varchar(20),
	total_runs int,
	total_wickets int,
	matches_played int,
	primary key (t_id)
 );
 
 -- Inserted Default/initial values to the table 
insert into teams(t_id, team_name) values ('IND' ,'India');
insert into teams(t_id, team_name) values ('AUS' ,'Australia');
insert into teams(t_id, team_name) values ('ENG' ,'England');
insert into teams(t_id, team_name) values ('NZ' ,'New Zealand');
insert into teams(t_id, team_name) values ('RSA' ,'South Africa');
 
SELECT * FROM teams order by total_runs desc;
 
UPDATE teams SET total_runs=987, total_wickets=22, matches_played = 4 WHERE t_id="IND";
UPDATE teams SET total_runs=871, total_wickets=30, matches_played = 4 WHERE t_id="AUS";
UPDATE teams SET total_runs=812, total_wickets=21, matches_played = 4 WHERE t_id="ENG";
UPDATE teams SET total_runs=953, total_wickets=19, matches_played = 4 WHERE t_id="NZ";
UPDATE teams SET total_runs=854, total_wickets=23, matches_played = 4 WHERE t_id="RSA";

 
create table points_table(
	t_id varchar(3),
    team_rank int unique not null,
    matches_played int,
    matches_won int,
    matches_lost int,
    primary key(t_id),
    foreign key(t_id) references teams(t_id)
);

INSERT INTO points_table VALUES('IND', 1, 4, 3, 1);
INSERT INTO points_table VALUES('NZ', 2, 4, 3, 1);
INSERT INTO points_table VALUES('RSA', 3, 4, 3, 1);
INSERT INTO points_table VALUES('ENG', 4, 4, 1, 3);
INSERT INTO points_table VALUES('AUS', 5, 4, 0, 4);

SELECT * FROM points_table ORDER BY team_rank;

create table worldcup_timetable(
	match_id int not null auto_increment,
    match_date date,
    t1_id varchar(3),
    t2_id varchar(3),
    winning_t_id varchar(3),
    t1_score int,
    t2_score int,
    primary key(match_id)
);

INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-10', 'IND', 'AUS', 205, 173, 'IND');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-11', 'NZ', 'ENG', 241, 201, 'NZ');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-12', 'IND', 'RSA', 262, 243, 'IND');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-13', 'AUS', 'NZ', 217, 250, 'NZ');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-14', 'ENG', 'RSA', 220, 222, 'RSA');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-15', 'IND', 'NZ', 183, 262, 'NZ');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-16', 'AUS', 'ENG', 233, 234, 'ENG');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-17', 'RSA', 'NZ', 210, 200, 'RSA');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-18', 'IND', 'ENG', 325, 157, 'IND');
INSERT INTO worldcup_timetable (match_date, t1_id, t2_id, t1_score, t2_score, winning_t_id) VALUES ('2021-01-19', 'AUS', 'RSA', 179, 248, 'RSA');

SELECT * FROM worldcup_timetable;

CREATE TABLE player(
	p_id int,
    t_id varchar(3),
    p_name varchar(50),
    matches_played int,
    runs_scored int,
    wickets_taken int,
    primary key(p_id),
    foreign key(t_id) references teams(t_id)
);

insert into player values(18, 'IND', 'Virat Kohli', 4, 237, 0);
insert into player values(45, 'IND', 'Rohit Sharma', 4, 251, 0);
insert into player values(93, 'IND', 'Jasprit Bumrah', 4, 10, 5);
insert into player values(8, 'ENG', 'Stuart Broad', 4, 27, 4);
insert into player values(17, 'ENG', 'Jos Buttler', 4, 214, 0);
insert into player values(55, 'ENG', 'Ben Stokes', 4, 197, 4);
insert into player values(49, 'AUS', 'Steve Smith', 4, 206, 1);
insert into player values(4, 'AUS', 'Pat Cummins', 4, 39, 5);
insert into player values(5, 'AUS', 'David Warner', 4, 249, 0);
insert into player values(16, 'NZ', 'Kane Williamson', 4, 255, 0);
insert into player values(36, 'NZ', 'Trent Boult', 4, 20, 6);
insert into player values(87, 'NZ', 'Tim Siefert', 4, 192, 0);
insert into player values(79, 'RSA', 'AB de Villiers', 4, 245, 0);
insert into player values(171, 'RSA', 'Kagiso Rabada', 4, 21, 5);
insert into player values(123, 'RSA', 'Quinton de Kock', 4, 219, 0);

SELECT * FROM player WHERE t_id = 'ENG';

-- 1. Fetch the top 5 batsmen who scored the maximum runs. -- 
SELECT * FROM player ORDER BY runs_scored DESC LIMIT 5;

-- 2. Fetch the top 5 bowlers who has taken the maximum wickets. --
SELECT * FROM player ORDER BY wickets_taken DESC LIMIT 5;

-- 3. Fetch the average score scored by each team considering the matches played. --
SELECT t_id AS TEAM, total_runs/matches_played AS AVERAGE
FROM teams
GROUP BY team_name
ORDER BY AVERAGE DESC;

-- 4. Increase the scores of each batsmen in the team, which has the least average computed in above step, by 10 runs. --
SELECT *, total_runs/matches_played AS AVERAGE
FROM teams
WHERE total_runs/matches_played <= ALL (SELECT total_runs/matches_played
										FROM teams);

UPDATE player SET runs_scored = runs_scored + 10
WHERE t_id = (SELECT t_id 
			  FROM teams
			  WHERE total_runs/matches_played <= ALL (SELECT total_runs/matches_played
													  FROM teams));
                                                      
-- 5. Create a procedure which takes country as the input and gives the highest score of the country up to date, as output --
DELIMITER $$

DROP PROCEDURE IF EXISTS HighestScore$$
CREATE PROCEDURE HighestScore(country VARCHAR(3), OUT highest INT)
BEGIN
    SELECT  MAX(IF(t1_id = country, t1_score, t2_score)) INTO highest FROM worldcup_timetable WHERE match_id IN (SELECT match_id FROM worldcup_timetable WHERE t1_id = country OR t2_id = country);

END$$

DELIMITER ;

CALL highestScore('IND', @highest);
SELECT @highest AS HighestScore;