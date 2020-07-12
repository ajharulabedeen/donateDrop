SELECT
    COUNT(*)
FROM
    agent_request_review,
    phonenumber
WHERE
    agent_request_review.profile_id = phonenumber.profile_id AND phonenumber.number LIKE '%%' AND `agent_request_review`.`status` = 'ACCEPT'
-------------------------------------------
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
