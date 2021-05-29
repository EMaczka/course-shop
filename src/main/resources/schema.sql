CREATE TABLE course
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description MEDIUMTEXT NOT NULL,
    complexity VARCHAR(50),
    course_date VARCHAR(50),
    city VARCHAR(50) NOT NULL,
    scope MEDIUMTEXT NOT NULL,
    price DOUBLE,
    reduction INT,
    participants_number INT,
    duration INT,
    image VARCHAR(255)

);

CREATE TABLE language
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description MEDIUMTEXT NOT NULL
);