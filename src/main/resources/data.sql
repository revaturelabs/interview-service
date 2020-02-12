INSERT INTO public.skills(skill_title) VALUES ('Java');
INSERT INTO public.skills(skill_title) VALUES ('Angular');
INSERT INTO public.skills(skill_title) VALUES ('React');
INSERT INTO public.skills(skill_title) VALUES ('SQL');
INSERT INTO public.skills(skill_title) VALUES ('Spring');
INSERT INTO public.skills(skill_title) VALUES ('JavaScript');
INSERT INTO public.skills(skill_title) VALUES ('Bootstrap');
INSERT INTO public.skills(skill_title) VALUES ('Hibernate');

INSERT INTO public.profiles(profile_description, 
profile_email_address, profile_first_name, profile_last_name, profile_location) 
VALUES ('Excellent candidate', 'msmith@gmail.com', 'Melinda', 'Smith', 'New York City');
INSERT INTO public.profiles
(profile_description, profile_email_address, profile_first_name, profile_last_name, profile_location)
VALUES('Second interview pending', 'rsanchez@hotmail.com', 'Rick', 'Sanchez', 'St. Paul');
INSERT INTO public.profiles
(profile_description, profile_email_address, profile_first_name, profile_last_name, profile_location)
VALUES('Requires background check', 'hsimpson@gmail.com', 'Homer', 'Simpson', 'Springfield');
INSERT INTO public.profiles
(profile_description, profile_email_address, profile_first_name, profile_last_name, profile_location)
VALUES('Fantastic candidate', 'unicorns@sprinkles.com', 'Lisa', 'Simpson', 'Springfield');
INSERT INTO public.profiles
(profile_description, profile_email_address, profile_first_name, profile_last_name, profile_location)
VALUES('Pending screening', 'looneytunes@gmail.com', 'Bugs', 'Bunny', 'Tampa');
INSERT INTO public.profiles
(profile_description, profile_email_address, profile_first_name, profile_last_name, profile_location)
VALUES('Will not be asked to return', 'bsimps@gmail.com', 'Bart', 'Simpson', 'Springfield');

INSERT INTO public.jobs
(job_description, job_is_filled, job_location, job_title, filled_by_profile_id)
VALUES('conducts market analysis', true, 'Springfield', 'Business Analayst', 1);
INSERT INTO public.jobs
(job_description, job_is_filled, job_location, job_title, filled_by_profile_id)
VALUES('develops robust, secure enterprise-level applications', true, 'Tampa', 'Java Fullstack Developer', 2);
INSERT INTO public.jobs
(job_description, job_is_filled, job_location, job_title, filled_by_profile_id)
VALUES('designs and develops engaging user-interfaces', false, 'New York City', 'Frontend Developer', 0);
INSERT INTO public.jobs
(job_description, job_is_filled, job_location, job_title, filled_by_profile_id)
VALUES('analyzes and maintains SQL databases', false, 'Miami', 'SQL Specialist', 0);
INSERT INTO public.jobs
(job_description, job_is_filled, job_location, job_title, filled_by_profile_id)
VALUES('responsible for Java specific backend programming', false, 'Boise', 'Java Backend Developer', 0);

INSERT INTO public.interviews
(interview_date, interview_is_complete, interview_job, interview_profile)
VALUES('2020-01-11', true, 1, 1);
INSERT INTO public.interviews
(interview_date, interview_is_complete, interview_job, interview_profile)
VALUES('2020-02-05', false, 8, 3);
INSERT INTO public.interviews
(interview_date, interview_is_complete, interview_job, interview_profile)
VALUES('2020-01-20', false, 8, 4);

INSERT INTO public.profile_skills
(profile_id, skill_id)
VALUES(1, 1);
INSERT INTO public.profile_skills
(profile_id, skill_id)
VALUES(1, 2);
INSERT INTO public.profile_skills
(profile_id, skill_id)
VALUES(3, 4);
INSERT INTO public.profile_skills
(profile_id, skill_id)
VALUES(5, 4);
INSERT INTO public.profile_skills
(profile_id, skill_id)
VALUES(5, 1);

INSERT INTO public.interview_interviewer
(interviewer, "text", fk_interview)
VALUES('Johnathan Sheep', 'Business Analyst Interview', 3);
INSERT INTO public.interview_interviewer
(interviewer, "text", fk_interview)
VALUES('William Smith', 'Java Fullstack interview', 8);

INSERT INTO public."comments"
("date", "text", interview_interviewer)
VALUES('2020-02-05', 'Great interview', 3);

INSERT INTO public."comments"
("date", "text", interview_interviewer)
VALUES('2020-02-11', 'Good grasp of Java Core but needs improvement in Angular', 8);

INSERT INTO public.job_skills
(job_id, skill_id)
VALUES(8, 1);

INSERT INTO public.job_skills
(job_id, skill_id)
VALUES(8, 2);

INSERT INTO public.job_skills
(job_id, skill_id)
VALUES(1, 4);

INSERT INTO public.job_skills
(job_id, skill_id)
VALUES(1, 1);

INSERT INTO public.job_skills
(job_id, skill_id)
VALUES(8, 7);

INSERT INTO public.job_skills
(job_id, skill_id)
VALUES(8, 8);











