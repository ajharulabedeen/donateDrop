-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2020 at 01:55 AM
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
-- Database: `donate_drop_new`
--

-- --------------------------------------------------------

--
-- Structure for view `donner_to_agent_request_review`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `donner_to_agent_request_review`  AS  select `donner_to_agent_request_review_1`.`profile_id` AS `profile_id`,`donner_to_agent_request_review_1`.`name` AS `name`,`donner_to_agent_request_review_1`.`gender` AS `gender`,`donner_to_agent_request_review_1`.`profession` AS `profession`,`donner_to_agent_request_review_1`.`user_id` AS `user_id`,`donner_to_agent_request_review_1`.`address_permanent` AS `address_permanent`,`donner_to_agent_request_review_1`.`address_present` AS `address_present`,`donner_to_agent_request_review_1`.`request_id` AS `request_id`,`donner_to_agent_request_review_1`.`request_date` AS `request_date`,`donner_to_agent_request_review_1`.`accept_date` AS `accept_date`,`donner_to_agent_request_review_1`.`reject_date` AS `reject_date`,`donner_to_agent_request_review_1`.`remove_date` AS `remove_date`,`donner_to_agent_request_review_1`.`status` AS `status`,`donner_to_agent_request_review_1`.`note_donner` AS `note_donner`,`donner_to_agent_request_review_1`.`note_agent` AS `note_agent`,`donner_to_agent_request_review_1`.`note_agent_personal` AS `note_agent_personal`,`donner_to_agent_request_review_1`.`present_id` AS `present_id`,`donner_to_agent_request_review_1`.`present_div` AS `present_div`,`donner_to_agent_request_review_1`.`present_dist` AS `present_dist`,`donner_to_agent_request_review_1`.`present_upz` AS `present_upz`,`donner_to_agent_request_review_1`.`present_union` AS `present_union`,`donner_to_agent_request_review_1`.`present_street` AS `present_street`,`donner_to_agent_request_review_1`.`username` AS `username`,`address`.`id` AS `permanent_id`,`address`.`division` AS `permanent_div`,`address`.`district` AS `permanent_dist`,`address`.`upzilla` AS `permanent_upz`,`address`.`union_ward` AS `permanent_union`,`address`.`street_address` AS `permanent_street` from (`donner_to_agent_request_review_1` join `address`) where (`donner_to_agent_request_review_1`.`address_permanent` = `address`.`id`) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
