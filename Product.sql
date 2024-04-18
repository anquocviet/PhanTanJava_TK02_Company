INSERT INTO positions (position_id, description, name, number, salary)
VALUES 
(1, 'Senior software engineer role responsible for leading development projects and mentoring junior team members.', 'Senior Software Engineer', 3, 80000),
(2, 'Entry-level software developer position focusing on learning and contributing to development projects.', 'Junior Software Developer', 5, 50000),
(3, 'Project manager role overseeing project planning, execution, and delivery.', 'Project Manager', 2, 90000);

INSERT INTO candidates (candidate_id, description, email, full_name, gender, phone, year_of_birthday, position_id)
VALUES 
(1, 'Experienced software engineer with expertise in Java and Python development.', 'john.doe@example.com', 'John Doe', 'Male', '123-456-7890', 1985, 1),
(2, 'Recent graduate with a degree in Computer Science.', 'jane.smith@example.com', 'Jane Smith', 'Female', '987-654-3210', 1998, 2),
(3, 'Senior project manager with over 10 years of experience in leading cross-functional teams.', 'michael.johnson@example.com', 'Michael Johnson', 'Male', '456-789-0123', 1978, 3);

INSERT INTO certificates (certificate_id, issued_date, name, organization, candidate_id)
VALUES 
(1, '2023-05-15', 'Java Programming Certification', 'Java Institute', 1),
(2, '2022-10-20', 'Python Certification', 'Python Academy', 2),
(3, '2024-01-10', 'Project Management Certification', 'PMI Institute', 3);

INSERT INTO experiences (company_name, description, from_date, to_date, position_id, candidate_id)
VALUES 
('ABC Corporation', 'Software Engineer responsible for developing web applications using Java and Spring framework.', '2020-01-01', '2022-05-31', 1, 1),
('XYZ Company', 'Internship as a software developer, working on front-end development using React.js.', '2021-06-01', '2021-12-31', 2, 2),
('DEF Enterprises', 'Project Manager leading a team of developers and overseeing project timelines and deliverables.', '2018-03-15', '2020-02-28', 3, 3);
-- 
-- SELECT c.candidate_id, COUNT(DISTINCT e.company_name) AS distinctCompanyCount
-- FROM candidates c
-- JOIN experience e ON c.candidate_id = e.candidate_id
-- GROUP BY c.candidate_id;
