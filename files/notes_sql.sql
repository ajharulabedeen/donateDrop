
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
12417	6	
11835	5	
11801	5	
11677	4	
11613	4	
12230	4	
12098	4	
-----------------------------
SELECT DATEDIFF('2007-12-31 10:02:00','2007-12-3 12:01:01')
result : 28
-------------------------------------
SELECT
    *
FROM
    `address`,
    `donner_to_agent_request_review`
WHERE
    donner_to_agent_request_review.profile_id = `address`.`profile_id` 
    AND
    (`address`.`division` LIKE '%khulna%' 
     OR `address`.`district` LIKE '%khulna%' 
     OR `address`.`upzilla` LIKE '%khulna%'
     OR `address`.`union_ward` LIKE '%khulna%')
=================================================
SELECT
    `profilebasic`.*,
    `request_donner_to_agent`.*,
    `user`.`USERNAME`
FROM
    `request_donner_to_agent`,
    `profilebasic`,
    `user`
WHERE
    `request_donner_to_agent`.`user_id_donner` = `profilebasic`.`user_id`
    AND `request_donner_to_agent`.`user_id_donner`=`user`.`ID`
=================================================
SELECT
    *
FROM
    `address`,
    `agent_request_review`
WHERE
    agent_request_review.profile_id = `address`.`profile_id` 
    AND
    (`address`.`division` LIKE '%khulna%' 
     OR `address`.`district` LIKE '%khulna%' 
     OR `address`.`upzilla` LIKE '%khulna%'
     OR `address`.`union_ward` LIKE '%khulna%')
--------------------------------------------
SELECT
    `profilebasic`.*,
    `agent_request`.`agent_request_id`,
    `agent_request`.`accept_date`,
    `agent_request`.`freeze_date`,
    `agent_request`.`note_admin`,
    `agent_request`.`note_applicant`,
    `agent_request`.`note_personal`,
    `agent_request`.`reject_date`,
    `agent_request`.`request_date`,
    `agent_request`.`status`,
    `user`.`USERNAME`
FROM
    `agent_request`,
    `profilebasic`,
    `user`
WHERE
    `agent_request`.`user_id` = `profilebasic`.`user_id`
    AND `agent_request`.`user_id`=`user`.`ID`
--------------------------------------


SELECT * FROM `profilebasic` WHERE (CAST(birth_date AS DATETIME) BETWEEN CAST('2020-05-10' AS DATETIME) AND CAST('2020-05-18' AS DATETIME))
#working sql
(1, '0', '2020-05-16', 'A+', 'Khan Atiar Rahman and Dr Mahbub, Dumuria Khulna.', 'Mail@mail.com', 'Male', 'NO', '>>>>Khan Ajharul Abedeen', 'Freelance/Remote', 'Private', '16'),
(9, '0', '20-05-16', 'A+', 'Khan Atiar Rahman.', NULL, 'Male', 'NO', 'Khan Ajharul Abedeen', 'Freelance', NULL, '16'),


#not in use----------------------------------------------
SELECT
    donner_to_agent_request_review.*
FROM
    donner_to_agent_request_review,
    phonenumber
WHERE
    donner_to_agent_request_review.profile_id = phonenumber.profile_id AND phonenumber.number LIKE '%01%'

//not in use------------------------------------
SELECT
    `profilebasic`.`id` AS `profile_id`,
    `profilebasic`.`name` AS `name`,
    `profilebasic`.`gender` AS `gender`,
    `profilebasic`.`profession` AS `profession`,
    `profilebasic`.`user_id` AS `user_id`,
    `profilebasic`.`address_permanent` AS `address_permanent`,
    `profilebasic`.`address_present` AS `address_present`,
    `request_donner_to_agent`.`id` AS `request_id`,
    `request_donner_to_agent`.`request_date` AS `request_date`,
    `request_donner_to_agent`.`accept_date` AS `accept_date`,
    `request_donner_to_agent`.`reject_date` AS `reject_date`,
    `request_donner_to_agent`.`remove_date` AS `remove_date`,
    `request_donner_to_agent`.`status` AS `status`,
    `request_donner_to_agent`.`note_donner` AS `note_donner`,
    `request_donner_to_agent`.`note_agent` AS `note_agent`,
    `request_donner_to_agent`.`note_agent_personal` AS `note_agent_personal`,
    `address`.`id` AS `present_id`,
    `address`.`division` AS `present_div`,
    `address`.`district` AS `present_dist`,
    `address`.`upzilla` AS `present_upz`,
    `address`.`union_ward` AS `present_union`,
    `address`.`street_address` AS `present_street`,
    `user`.`USERNAME` AS `username`
FROM
    `profilebasic`,
    `request_donner_to_agent`,
    `address`,
    `user`
WHERE
    `profilebasic`.`user_id` = `request_donner_to_agent`.`user_id_donner` 
    AND `profilebasic`.`address_present` = `address`.`id` 
    AND `user`.`ID` = `profilebasic`.`user_id`


//not in use-----------------donner_to_agent_request_review_1
SELECT
    `donner_to_agent_request_review_1`.`profile_id`,
    `donner_to_agent_request_review_1`.`name` ,
    `donner_to_agent_request_review_1`.`gender` ,
    `donner_to_agent_request_review_1`.`profession` ,
    `donner_to_agent_request_review_1`.`user_id` ,
    `donner_to_agent_request_review_1`.`address_permanent` ,
    `donner_to_agent_request_review_1`.`address_present` ,
    `donner_to_agent_request_review_1`.`request_id` ,
    `donner_to_agent_request_review_1`.`request_date` ,
    `donner_to_agent_request_review_1`.`accept_date` ,
    `donner_to_agent_request_review_1`.`reject_date` ,
    `donner_to_agent_request_review_1`.`remove_date` ,
    `donner_to_agent_request_review_1`.`status` ,
    `donner_to_agent_request_review_1`.`note_donner`,
    `donner_to_agent_request_review_1`.`note_agent` ,
    `donner_to_agent_request_review_1`.`note_agent_personal` ,
    `donner_to_agent_request_review_1`.`present_id`,
    `donner_to_agent_request_review_1`.`present_div`,
    `donner_to_agent_request_review_1`.`present_dist`,
    `donner_to_agent_request_review_1`.`present_upz`,
    `donner_to_agent_request_review_1`.`present_union`,
    `donner_to_agent_request_review_1`.`present_street`,
    `donner_to_agent_request_review_1`.`username`,
    `address`.`id` AS `permanent_id`,
    `address`.`division` AS `permanent_div`,
    `address`.`district` AS `permanent_dist`,
    `address`.`upzilla` AS `permanent_upz`,
    `address`.`union_ward` AS `permanent_union`,
    `address`.`street_address` AS `permanent_street`
FROM
    `donner_to_agent_request_review_1`,
    `address`
WHERE
    `donner_to_agent_request_review_1`.`address_permanent` = `address`.`id`


//not in use-----------------------------------------
CREATE VIEW `agent_request_review` AS SELECT
    `agent_request_review_1`.`profile_id` AS `profile_id`,
    `agent_request_review_1`.`name` AS `name`,
    `agent_request_review_1`.`gender` AS `gender`,
    `agent_request_review_1`.`profession` AS `profession`,
    `agent_request_review_1`.`user_id` AS `user_id`,
    `agent_request_review_1`.`address_permanent` AS `address_permanent`,
    `agent_request_review_1`.`address_present` AS `address_present`,
    `agent_request_review_1`.`request_id` AS `request_id`,
    `agent_request_review_1`.`request_date` AS `request_date`,
    `agent_request_review_1`.`accept_date` AS `accept_date`,
    `agent_request_review_1`.`reject_date` AS `reject_date`,
    `agent_request_review_1`.`freeze_date` AS `freeze_date`,
    `agent_request_review_1`.`status` AS `status`,
    `agent_request_review_1`.`note_applicant` AS `note_applicant`,
    `agent_request_review_1`.`note_admin` AS `note_admin`,
    `agent_request_review_1`.`note_personal` AS `note_personal`,
    `agent_request_review_1`.`present_id` AS `present_id`,
    `agent_request_review_1`.`present_div` AS `present_div`,
    `agent_request_review_1`.`present_dist` AS `present_dist`,
    `agent_request_review_1`.`present_upz` AS `present_upz`,
    `agent_request_review_1`.`present_union` AS `present_union`,
    `agent_request_review_1`.`present_street` AS `present_street`,
    `agent_request_review_1`.`username` AS `username`,
    `address`.`id` AS `permanent_id`,
    `address`.`division` AS `permanent_div`,
    `address`.`district` AS `permanent_dist`,
    `address`.`upzilla` AS `permanent_upz`,
    `address`.`union_ward` AS `permanent_union`,
    `address`.`street_address` AS `permanent_street`
FROM
    `agent_request_review_1`,
    `address`
WHERE
    `agent_request_review_1`.`address_permanent` = `address`.`id`

//not in use-----------agent_request_review_1
CREATE VIEW `agent_request_review_1` AS SELECT
    `profilebasic`.`id` AS `profile_id`,
    `profilebasic`.`name` AS `name`,
    `profilebasic`.`gender` AS `gender`,
    `profilebasic`.`profession` AS `profession`,
    `profilebasic`.`user_id` AS `user_id`,
    `profilebasic`.`address_permanent` AS `address_permanent`,
    `profilebasic`.`address_present` AS `address_present`,
    `agent_request`.`id` AS `request_id`,
    `agent_request`.`request_date` AS `request_date`,
    `agent_request`.`accept_date` AS `accept_date`,
    `agent_request`.`reject_date` AS `reject_date`,
    `agent_request`.`freeze_date` AS `freeze_date`,
    `agent_request`.`status` AS `status`,
    `agent_request`.`note_applicant` AS `note_applicant`,
    `agent_request`.`note_admin` AS `note_admin`,
    `agent_request`.`note_personal` AS `note_personal`,
    `address`.`id` AS `present_id`,
    `address`.`division` AS `present_div`,
    `address`.`district` AS `present_dist`,
    `address`.`upzilla` AS `present_upz`,
    `address`.`union_ward` AS `present_union`,
    `address`.`street_address` AS `present_street`,
    `user`.`USERNAME` AS `username`
FROM
    `profilebasic`,
    `agent_request`,
    `address`,
	`user`
WHERE
    `profilebasic`.`user_id` = `agent_request`.`user_id`
    AND `profilebasic`.`address_present` = `address`.`id` 
    AND `user`.`ID` = `profilebasic`.`user_id`