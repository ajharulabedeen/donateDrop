-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2020 at 01:02 AM
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
-- Structure for view `agent_request_review_1`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `agent_request_review_1`  AS  select `profilebasic`.`id` AS `profile_id`,`profilebasic`.`name` AS `name`,`profilebasic`.`gender` AS `gender`,`profilebasic`.`profession` AS `profession`,`profilebasic`.`user_id` AS `user_id`,`profilebasic`.`address_permanent` AS `address_permanent`,`profilebasic`.`address_present` AS `address_present`,`agent_request`.`id` AS `request_id`,`agent_request`.`request_date` AS `request_date`,`agent_request`.`accept_date` AS `accept_date`,`agent_request`.`reject_date` AS `reject_date`,`agent_request`.`freeze_date` AS `freeze_date`,`agent_request`.`status` AS `status`,`agent_request`.`note_applicant` AS `note_applicant`,`agent_request`.`note_admin` AS `note_admin`,`agent_request`.`note_personal` AS `note_personal`,`address`.`id` AS `present_id`,`address`.`division` AS `present_div`,`address`.`district` AS `present_dist`,`address`.`upzilla` AS `present_upz`,`address`.`union_ward` AS `present_union`,`address`.`street_address` AS `present_street`,`user`.`USERNAME` AS `username` from (((`profilebasic` join `agent_request`) join `address`) join `user`) where ((`profilebasic`.`user_id` = `agent_request`.`user_id`) and (`profilebasic`.`address_present` = `address`.`id`) and (`user`.`ID` = `profilebasic`.`user_id`)) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
