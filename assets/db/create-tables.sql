CREATE TABLE `movies` (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100),
	genre_id INTEGER,
	genre VARCHAR(100),
	detail VARCHAR(255),
	watched INTEGER,
	to_watch BINARY
);

CREATE TABLE `likes` (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	movie_id INTEGER,
	liked BINARY
);


CREATE TABLE `issues` (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	creation_date TIMESTAMP,
	reason VARCHAR,
	description VARCHAR
);