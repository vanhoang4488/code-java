-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 01, 2022 lúc 04:12 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `carsaomai`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cars`
--

CREATE TABLE `cars` (
  `STT` int(4) NOT NULL,
  `CarID` char(8) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `CarName` char(100) NOT NULL,
  `Rate` decimal(2,1) NOT NULL DEFAULT 5.0,
  `Description` text DEFAULT NULL,
  `Price` int(8) NOT NULL,
  `Quantily` int(5) NOT NULL,
  `ImageUrl` varchar(200) NOT NULL DEFAULT '../Servlet/image/minh_hoa.png',
  `updateDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cars`
--

INSERT INTO `cars` (`STT`, `CarID`, `CarName`, `Rate`, `Description`, `Price`, `Quantily`, `ImageUrl`, `updateDate`) VALUES
(1, 'CRID1', 'Xe 1', '5.0', 'Xe chất lượng cao', 100000, 10, '../Servlet/image/mercedes-benz-vehicles-concept-cars-vision-avtr-11.jpg', '2022-02-01 14:51:24'),
(2, 'CRID2', 'xe 2', '5.0', 'Xe bố của ngon luôn :))', 9999, 1, '../Servlet/image/11cnxh_PWLV.jpg', '2022-02-01 15:05:58'),
(3, 'CRID3', 'xe 3', '5.0', 'Xe chất lượng cao', 72727, 100, '../Servlet/image/minh_hoa.png', '2022-02-01 10:33:44'),
(4, 'CRID4', 'xe pha-ke', '5.0', 'xe pha-ke nhưng vẫn bán giá đắt vì tao thích.', 999999999, 1000, '../Servlet/image/minh_hoa.png', '2022-02-01 14:48:53'),
(5, 'CRID5', 'xe 5', '5.0', 'Không mua thì phí\r\n.\r\n.\r\n.\r\n.\r\n.\r\n.\r\nMua thì ngu.', 222222, 1, '../Servlet/image/minh_hoa.png', '2022-02-01 10:33:44');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `login`
--

CREATE TABLE `login` (
  `LogName` char(50) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `Password` char(16) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `MemberID` char(8) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `Registration` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `login`
--

INSERT INTO `login` (`LogName`, `Password`, `MemberID`, `Registration`) VALUES
('17020769', 'hoangie2k62', 'CMI6', '2022-01-30 17:04:18'),
('hoangie2k62', '17020769', 'CMI1', '2022-01-28 01:40:06'),
('meomun', 'chan', 'CMI2', '2022-01-28 01:40:06'),
('NoLongSure', 'hoangie2k62', 'CMI7', '2022-01-31 14:57:46'),
('notalknoshare', 'hoangie2k62', 'CMI3', '2022-01-30 14:40:04'),
('VanHoang', '11111111111111', 'CMI4', '2022-01-30 14:37:30'),
('wholaughs', 'damocles', 'CMI5', '2022-01-30 14:42:47');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `members`
--

CREATE TABLE `members` (
  `STT` int(8) NOT NULL,
  `MemberID` char(8) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `FirstName` char(30) NOT NULL,
  `LastName` char(30) NOT NULL,
  `Age` int(3) NOT NULL,
  `Gender` char(10) NOT NULL,
  `Address` text NOT NULL,
  `City` char(50) NOT NULL,
  `Pin` int(7) NOT NULL,
  `Email` char(100) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `Phone` int(10) NOT NULL,
  `Salary` bigint(18) NOT NULL,
  `RegisterDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `members`
--

INSERT INTO `members` (`STT`, `MemberID`, `FirstName`, `LastName`, `Age`, `Gender`, `Address`, `City`, `Pin`, `Email`, `Phone`, `Salary`, `RegisterDate`) VALUES
(1, 'CMI1', 'nguyễn', 'hoàng', 23, 'Nam', 'Đông Đô - Hưng Hà', 'Thái Bình', 7101999, 'hoangie2k62@gmail.com', 898064727, 2147483647, '2022-01-30 14:06:37'),
(3, 'CMI3', 'nguyễn', 'hoàng', 22, 'Nam', 'Đông Đô - Hưng Hà', 'thai binh', 9451301, 'hoangie2k62@gmail.com', 898064727, 11111111111111, '2022-01-30 14:37:30'),
(4, 'CMI4', 'nguyễn', 'hoàng', 22, 'Nam', 'Đông Đô - Hưng Hà', 'thai binh', 9451301, 'hoangie2k62@gmail.com', 898064727, 11111111111111, '2022-01-30 14:40:04'),
(5, 'CMI2', 'nguyến', 'hoàng', 22, 'Nam', 'Đông Đô - Hưng Hà', 'Thái Bình', 7101999, 'hoangie2k62@gmail.com', 898064727, 99999999999, '2022-02-01 09:45:57'),
(5, 'CMI5', 'nguyến', 'hoàng', 22, 'Nam', 'Đông Đô - Hưng Hà', 'Thái Bình', 7101999, 'hoangie2k62@gmail.com', 898064727, 99999999999, '2022-02-01 09:42:42'),
(6, 'CMI6', 'nguyễn', 'hoàng', 22, 'Nam', 'Đông Đô - Hưng Hà', 'Thái Bình', 9451302, 'hoangie2k62@gmail.com', 898064727, 99999999999, '2022-01-30 17:04:18'),
(7, 'CMI7', 'nguyễn', 'hoàng', 22, 'Nam', 'Đông Đô - Hưng Hà', 'Thái Bình', 9451309, 'hoangie2k62@gmail.com', 898064727, 999999999999, '2022-01-31 14:57:46');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`STT`,`CarID`);

--
-- Chỉ mục cho bảng `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`LogName`),
  ADD UNIQUE KEY `MemberID` (`MemberID`);

--
-- Chỉ mục cho bảng `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`STT`,`MemberID`),
  ADD KEY `MemberID` (`MemberID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cars`
--
ALTER TABLE `cars`
  MODIFY `STT` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `members`
--
ALTER TABLE `members`
  MODIFY `STT` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `members_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `login` (`MemberID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
