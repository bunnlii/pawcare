-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 08, 2025 at 05:04 PM
-- Server version: 8.0.39
-- PHP Version: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pawcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` int NOT NULL,
  `customer_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pet_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `service_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `appointment_date` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `service_id` bigint DEFAULT NULL,
  `provider_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `customer_name`, `pet_name`, `service_type`, `appointment_date`, `customer_id`, `service_id`, `provider_id`) VALUES
(1, 'Yasmine Chiboub', 'Sam', 'Veterinary Care', '2025-04-22', NULL, NULL, NULL),
(2, 'Tj willams', 'anna', 'Grooming', '2025-04-26', NULL, NULL, NULL),
(3, 'tyler hall', 'lola', 'Pet Sitting', '2025-05-24', NULL, NULL, NULL),
(4, 'sarah diaz', 'sigma', 'Pet Walking', '2025-04-26', NULL, NULL, NULL),
(5, 'rose ', 'teach', 'Grooming', '2025-04-26', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` bigint NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `address`, `email`, `name`, `phone`, `password`) VALUES
(1, '123 Your-Mama rd', 'ymchiboub@gmail.com', 'Yasmine Chiboub', '1232156', NULL),
(2, '1', '1@gmail.com', NULL, '1', '1'),
(3, 'st', 'yas@gmail.com', NULL, '123456', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `pet`
--

CREATE TABLE `pet` (
  `id` bigint NOT NULL,
  `age` int NOT NULL,
  `breed` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `provider`
--

CREATE TABLE `provider` (
  `providerID` int NOT NULL,
  `bio` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statisticsid` int DEFAULT NULL,
  `provider_id` int DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `provider` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provider`
--

INSERT INTO `provider` (`providerID`, `bio`, `email`, `name`, `password`, `username`, `statisticsid`, `provider_id`, `role`, `provider`) VALUES
(11, '1', '1111@aksdjnad.com', '1', '$2a$10$jbMageHFZtmaySRtsMC2eOfH6Y/fzLm5s5tDXGpHDZonBoL.oogq.', '1111', NULL, NULL, 'ROLE_PROVIDER', NULL),
(12, 'I am a dog walker', 'Linda@gmail.com', 'Linda', '$2a$10$EUqm2iXbgPracFETa3dxB.bQio1rbh0CDoplR.9yOqqTJg3rV2TX6', 'LindaWalker', NULL, NULL, 'ROLE_PROVIDER', NULL),
(13, 'I am a vet', 'JenCat@gmail.com', 'Jennifer', '$2a$10$I1SgNrk3NP6l2QBQ2BA5..OjDDXlYHOYHVknwqusf7BMSqSKwPI3m', 'JenCat', NULL, NULL, 'ROLE_PROVIDER', NULL),
(14, 'Bob the Builder who will pet sit', 'BOB@gmail.com', 'Bob', '$2a$10$1cv1JrFsm.1K7ESh4B9Njuu6psXxzms9CT0VddNsWpiCko..Flvzu', 'BOBBUILDs', NULL, NULL, 'ROLE_PROVIDER', NULL),
(15, 'meow', 'Meow@gmail.com', 'Cat', '$2a$10$aUmekVPJ9UsLShk0Cv5yKOwTYga9eFT8bQGHP2i5MV9IrxxhlDggu', 'CATMeow', NULL, NULL, 'ROLE_PROVIDER', NULL),
(16, 'q', 'q@gmail.com', 'q', '$2a$10$NrJpJQTuq2p3xMSoXOlRKeStJb7rTMl/QXuMGEU09vW4AbqsUZiOG', '11', NULL, NULL, 'ROLE_PROVIDER', NULL),
(17, 'cat sitter', 'cat@gmail.com', 'cat', '$2a$10$Y55w3K00FmGXlnMekt2vdect1VWaWtZwvg0KhgQdPJApeDR22jL/2', 'cathello', NULL, NULL, 'ROLE_PROVIDER', NULL),
(18, 'I am a dog walker and I can dog sit', 'Libby@gmail.com', 'Libby', '$2a$10$oR6dyeIMounrsor/IU62MOwNLhHlP6nz4sw8OKhMaDUWsUxCnqRea', 'LibbyWalks', NULL, NULL, 'ROLE_PROVIDER', NULL),
(19, 'I am a dog walker and I can dog sit', 'Libby@gmail.com', 'Libby', '$2a$10$lIje9OER4DpXuyC3dt7EZOS5RBo6ICfBm0hn8j445dno22PJaYacy', 'LibbyWalkss', NULL, NULL, 'ROLE_PROVIDER', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `reviewid` bigint NOT NULL,
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rating` int NOT NULL,
  `customer_id` bigint DEFAULT NULL,
  `service_id` bigint DEFAULT NULL,
  `reviewresponse` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `providerid` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `reviewid` int NOT NULL,
  `review_msg` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `review_rating` int NOT NULL,
  `review_response` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `providerid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `serviceid` bigint NOT NULL,
  `price` double NOT NULL,
  `serviceType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `providerid` int DEFAULT NULL,
  `location` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `provider_id` int DEFAULT NULL,
  `service_type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`serviceid`, `price`, `serviceType`, `providerid`, `location`, `details`, `provider_id`, `service_type`) VALUES
(18, 2, NULL, 17, 'cat street', 'i watch cats', NULL, 'Cat sitter'),
(19, 18, NULL, 19, '12345 St. McMan', 'I watch dogs of all breed', NULL, 'Dog Sitter'),
(20, 123, NULL, 12, '123', '123', NULL, 'Dog Walking');

-- --------------------------------------------------------

--
-- Table structure for table `statistics`
--

CREATE TABLE `statistics` (
  `statisticsid` int NOT NULL,
  `avg_rating` double NOT NULL,
  `num_customer` int NOT NULL,
  `total_service` int NOT NULL,
  `providerid` int NOT NULL,
  `provider_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8md4njs5a5njp63yv11k9sajw` (`customer_id`),
  ADD KEY `FK23e9le2b1rhbdoa4dnavhibo7` (`service_id`),
  ADD KEY `FK125uern3l4kdyo6qm25n62i5x` (`provider_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt742r2fu4c3i9sn6a8kv0k746` (`customer_id`);

--
-- Indexes for table `provider`
--
ALTER TABLE `provider`
  ADD PRIMARY KEY (`providerID`),
  ADD UNIQUE KEY `UKfgy7cjr3hksfyq6tg5syi06o4` (`provider_id`),
  ADD KEY `statisticsid` (`statisticsid`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`reviewid`),
  ADD KEY `FKgce54o0p6uugoc2tev4awewly` (`customer_id`),
  ADD KEY `FKgwdirtrjebp7388pfmhblp1k1` (`service_id`),
  ADD KEY `providerid` (`providerid`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`reviewid`),
  ADD KEY `FK7qgf9lte3etfy57ydjvcu7xd4` (`providerid`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceid`),
  ADD KEY `providerid` (`providerid`),
  ADD KEY `FKehke8cumaxaf41p47f9ppx129` (`provider_id`);

--
-- Indexes for table `statistics`
--
ALTER TABLE `statistics`
  ADD PRIMARY KEY (`statisticsid`),
  ADD UNIQUE KEY `UKi58lxdn6imhfrd32j2o7o14am` (`provider_id`),
  ADD KEY `providerid` (`providerid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pet`
--
ALTER TABLE `pet`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `provider`
--
ALTER TABLE `provider`
  MODIFY `providerID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `reviewid` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `reviewid` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `serviceid` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `statistics`
--
ALTER TABLE `statistics`
  MODIFY `statisticsid` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `FK125uern3l4kdyo6qm25n62i5x` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`providerID`),
  ADD CONSTRAINT `FK23e9le2b1rhbdoa4dnavhibo7` FOREIGN KEY (`service_id`) REFERENCES `service` (`serviceid`),
  ADD CONSTRAINT `FK8md4njs5a5njp63yv11k9sajw` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `pet`
--
ALTER TABLE `pet`
  ADD CONSTRAINT `FKt742r2fu4c3i9sn6a8kv0k746` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `provider`
--
ALTER TABLE `provider`
  ADD CONSTRAINT `FKgqg46b7b2ybqe0ha8mq9hg9m4` FOREIGN KEY (`provider_id`) REFERENCES `statistics` (`statisticsid`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FKgce54o0p6uugoc2tev4awewly` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKgwdirtrjebp7388pfmhblp1k1` FOREIGN KEY (`service_id`) REFERENCES `service` (`serviceid`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FK7qgf9lte3etfy57ydjvcu7xd4` FOREIGN KEY (`providerid`) REFERENCES `provider` (`providerID`);

--
-- Constraints for table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `FKehke8cumaxaf41p47f9ppx129` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`providerID`),
  ADD CONSTRAINT `FKoaashkr5c45pw97da9qlhpl9i` FOREIGN KEY (`providerid`) REFERENCES `provider` (`providerID`);

--
-- Constraints for table `statistics`
--
ALTER TABLE `statistics`
  ADD CONSTRAINT `FKp2mf92xppps42b35d5vu0j4qs` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`providerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
