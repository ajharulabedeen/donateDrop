-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2020 at 05:03 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `drop_new`
--

-- --------------------------------------------------------

--
-- Structure for view `agent_request_review`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `agent_request_review`  AS  
select `profilebasic`.`profile_id` AS `profile_id`,
`profilebasic`.`available` AS `available`,
`profilebasic`.`birth_date` AS `birth_date`,
`profilebasic`.`blood_Group` AS `blood_Group`,
`profilebasic`.`care_of` AS `care_of`,
`profilebasic`.`email` AS `email`,
`profilebasic`.`gender` AS `gender`,
`profilebasic`.`marital_status` AS `marital_status`,
`profilebasic`.`name` AS `name`,
`profilebasic`.`profession` AS `profession`,
`profilebasic`.`religion` AS `religion`,
`profilebasic`.`user_id` AS `user_id`,
`agent_request`.`id` AS `id`,
`agent_request`.`accept_date` AS `accept_date`,
`agent_request`.`freeze_date` AS `freeze_date`,
`agent_request`.`note_admin` AS `note_admin`,
`agent_request`.`note_applicant` AS `note_applicant`,
`agent_request`.`note_personal` AS `note_personal`,
`agent_request`.`reject_date` AS `reject_date`,
`agent_request`.`request_date` AS `request_date`,
`agent_request`.`status` AS `status`,
`user`.`USERNAME` AS `USERNAME` 
from 
( (`agent_request` join `profilebasic`) join `user`) 
where 
(`agent_request`.`user_id` = `profilebasic`.`user_id`) ;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
