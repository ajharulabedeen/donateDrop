127.0.0.1/drop_new/postcomment/		http://localhost/phpmyadmin/db_sql.php?db=drop_new
 Showing rows 0 -  8 (9 total, Query took 0.0107 seconds.)

SELECT
    postcomment.*,
    profilebasic.name,
    profilebasic.email,
    profilebasic.gender,
    profilebasic.profession
FROM
    postcomment,
    profilebasic
WHERE
    post_id = 21392 AND postcomment.comment_user_id = profilebasic.user_id


comment_id	comment_details	comment_date	comment_user_id	post_id	name	email	gender	profession
21393	Gone by hiring Uber, poor guy wanted to pay but fo...	43993	11167	21392	Soiad Zaid Rehan	user3@gmail.com	Female	Laywer
21394	Went by Palitina Motor Cycle.	43997	11167	21392	Soiad Zaid Rehan	user3@gmail.com	Female	Laywer
21409	Updated Comment!	43854	11173	21392	Ahhmed Zia Afnan	user4@gmail.com	Male	Farmer
21401	Updated Comment!	43866	11373	21392	BiBi Ajeebah Amelia	user34@gmail.com	Male	Farmer
21410	Updated Comment!	44034	12051	21392	Pddar Ameera A'ishah	user138@gmail.com	Male	Karpentor
21412	Updated Comment!	43931	12405	21392	Mst Wadid Zayan	user193@gmail.com	Female	Engineer
21408	Updated Comment!	44011	12502	21392	Seikh Saadia Afnan	user208@gmail.com	Male	Freelancer
21404	Updated Comment!	43958	12569	21392	Eng Jabbar Maryam	user218@gmail.com	Male	CEOE
21403	Updated Comment!	44049	12842	21392	Lion Man Amelia	user259@gmail.com	Female	Plumber

---------------------------------------
SELECT
    *
FROM
    `post`
WHERE
    hospital_address LIKE "%k%" AND post_user_id = 12417 AND
    (
        need_date BETWEEN '2020-01-1' AND '2020-05-18'
    )
ORDER BY
    quantity
DESC
-----------------------
SELECT * FROM `post` WHERE need_date BETWEEN '2020-05-1' AND '2020-05-18' ORDER BY need_date ASC
-----------------------
SELECT * FROM `post` WHERE ( need_date BETWEEN '2020-05-10' AND '2020-05-18' )
-----------------------
SELECT
    *
FROM
    `post`
WHERE
    (
        CAST(need_date AS DATETIME) BETWEEN CAST('2020-05-10' AS DATETIME) AND CAST('2020-05-18' AS DATETIME)
    )
----------------------------------
SELECT
    *
FROM
    `post`
WHERE
    hospital_address LIKE "%khulna%" AND post_user_id = 12417 ORDER BY need_date DESC

-----------------------------
SELECT post_id,comment_user_id, count(post_id) FROM `postcomment`  GROUP BY post_id
ORDER BY count(post_id)  DESC

post_id	comment_user_id	count(post_id)   	
21392	11167	9	
21352	12250	5	
20550	11970	5	
20263	11945	5	
20050	12126	5	
20237	11613	5	
21211	11403	5	
20864	12068	5	
20363	12417	5	
20399	12090	5	
20925	12438	5	
20532	11606	5	
20566	11619	5	
20312	12146	5	
19977	12098	5	
21169	12139	5	
21112	12463	5	
20880	12034	4	
20940	11940	4	
20467	12293	4	
20770	11935	4	
20545	12174	4	
20577	12392	4	
21237	12250	4	
20385	11924	4
---
SELECT * FROM `post` WHERE `post_id`=20618 AND `post_user_id`=12417
----
SELECT post_user_id, COUNT(post_user_id) FROM `post` GROUP BY post_user_id ORDER BY COUNT(post_user_id) DESC
post_user_id	COUNT(post_user_id)   	
12417			6	
11835			5	
11801			5	
11677			4	
11613			4	
12230			4	
12098			4	
-----------------------------
SELECT DATEDIFF('2007-12-31 10:02:00','2007-12-3 12:01:01')
result : 28
--------------
SELECT * FROM `profilebasic` WHERE (CAST(birth_date AS DATETIME) BETWEEN CAST('2020-05-10' AS DATETIME) AND CAST('2020-05-18' AS DATETIME))
#working sql
(1, '0', '2020-05-16', 'A+', 'Khan Atiar Rahman and Dr Mahbub, Dumuria Khulna.', 'Mail@mail.com', 'Male', 'NO', '>>>>Khan Ajharul Abedeen', 'Freelance/Remote', 'Private', '16'),
(9, '0', '20-05-16', 'A+', 'Khan Atiar Rahman.', NULL, 'Male', 'NO', 'Khan Ajharul Abedeen', 'Freelance', NULL, '16'),
