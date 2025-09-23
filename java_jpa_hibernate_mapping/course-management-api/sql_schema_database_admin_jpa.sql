-- SQLite schema aligned with the JPA mappings

CREATE TABLE IF NOT EXISTS teachers (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  firstName TEXT NOT NULL,
  lastName  TEXT NOT NULL,
  email     TEXT UNIQUE
);

CREATE TABLE IF NOT EXISTS courses (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title   TEXT NOT NULL,
  credits INTEGER NOT NULL,
  teacher_id INTEGER,
  CONSTRAINT fk_course_teacher
    FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);

CREATE TABLE IF NOT EXISTS course_materials (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  url TEXT NOT NULL,
  course_id INTEGER UNIQUE,
  CONSTRAINT fk_material_course
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE IF NOT EXISTS students (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  firstName TEXT NOT NULL,
  lastName  TEXT NOT NULL,
  email     TEXT NOT NULL UNIQUE,
  street    TEXT,
  city      TEXT,
  zipCode   TEXT
);

CREATE TABLE IF NOT EXISTS phones (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  number TEXT NOT NULL,
  type   TEXT,
  student_id INTEGER,
  CONSTRAINT fk_phone_student
    FOREIGN KEY (student_id) REFERENCES students(id)
);

CREATE TABLE IF NOT EXISTS student_courses (
  student_id INTEGER NOT NULL,
  course_id  INTEGER NOT NULL,
  PRIMARY KEY (student_id, course_id),
  CONSTRAINT fk_sc_student FOREIGN KEY (student_id) REFERENCES students(id),
  CONSTRAINT fk_sc_course  FOREIGN KEY (course_id)  REFERENCES courses(id)
);
