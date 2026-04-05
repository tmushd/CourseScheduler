CREATE SCHEMA JAVA;
SET SCHEMA JAVA;

CREATE TABLE semester (
    semester VARCHAR(32) NOT NULL PRIMARY KEY
);

CREATE TABLE course (
    courseCode VARCHAR(16) NOT NULL PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE class (
    semester VARCHAR(32) NOT NULL,
    courseCode VARCHAR(16) NOT NULL,
    seats INT NOT NULL,
    PRIMARY KEY (semester, courseCode),
    CONSTRAINT fk_class_semester FOREIGN KEY (semester) REFERENCES semester(semester),
    CONSTRAINT fk_class_course FOREIGN KEY (courseCode) REFERENCES course(courseCode)
);

CREATE TABLE student (
    studentID VARCHAR(16) NOT NULL PRIMARY KEY,
    firstName VARCHAR(64) NOT NULL,
    lastName VARCHAR(64) NOT NULL
);

CREATE TABLE schedule (
    semester VARCHAR(32) NOT NULL,
    courseCode VARCHAR(16) NOT NULL,
    studentID VARCHAR(16) NOT NULL,
    status CHAR(1) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY (semester, courseCode, studentID),
    CONSTRAINT fk_schedule_class FOREIGN KEY (semester, courseCode) REFERENCES class(semester, courseCode),
    CONSTRAINT fk_schedule_student FOREIGN KEY (studentID) REFERENCES student(studentID),
    CONSTRAINT chk_schedule_status CHECK (status IN ('s', 'w'))
);

CREATE INDEX idx_schedule_status ON schedule (semester, courseCode, status, timestamp);
CREATE INDEX idx_schedule_student ON schedule (semester, studentID);
