SET SCHEMA JAVA;

INSERT INTO semester (semester) VALUES ('FALL2026');
INSERT INTO semester (semester) VALUES ('SPRING2027');

INSERT INTO course (courseCode, description) VALUES ('CMPSC221', 'Object-Oriented Programming');
INSERT INTO course (courseCode, description) VALUES ('CMPSC360', 'Discrete Mathematics');
INSERT INTO course (courseCode, description) VALUES ('MATH250', 'Matrix Algebra');

INSERT INTO class (semester, courseCode, seats) VALUES ('FALL2026', 'CMPSC221', 2);
INSERT INTO class (semester, courseCode, seats) VALUES ('FALL2026', 'CMPSC360', 2);
INSERT INTO class (semester, courseCode, seats) VALUES ('SPRING2027', 'MATH250', 2);

INSERT INTO student (studentID, firstName, lastName) VALUES ('1001', 'Alex', 'Smith');
INSERT INTO student (studentID, firstName, lastName) VALUES ('1002', 'Jamie', 'Lee');
INSERT INTO student (studentID, firstName, lastName) VALUES ('1003', 'Jordan', 'Kim');

INSERT INTO schedule (semester, courseCode, studentID, status, timestamp) VALUES ('FALL2026', 'CMPSC221', '1001', 's', '2026-08-20 09:00:00');
INSERT INTO schedule (semester, courseCode, studentID, status, timestamp) VALUES ('FALL2026', 'CMPSC221', '1002', 's', '2026-08-20 09:05:00');
INSERT INTO schedule (semester, courseCode, studentID, status, timestamp) VALUES ('FALL2026', 'CMPSC221', '1003', 'w', '2026-08-20 09:10:00');
