-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: localhost
-- Létrehozás ideje: 2023. Jún 09. 20:33
-- Kiszolgáló verziója: 10.4.28-MariaDB
-- PHP verzió: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `webshop_pakesz`
--
CREATE DATABASE IF NOT EXISTS `webshop_pakesz` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `webshop_pakesz`;

DELIMITER $$
--
-- Eljárások
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `regisztracio` (IN `nicknameIN` VARCHAR(100) CHARSET utf8, IN `emailIN` VARCHAR(100) CHARSET utf8, IN `pwIN` VARCHAR(100) CHARSET utf8, IN `adminIN` BOOLEAN)   INSERT INTO `user` 
VALUES (NULL, nicknameIN, emailIN, pwIN, adminIN, "123456789", "Elek", "Chat", 1, NULL, NOW())$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Address`
--

CREATE TABLE `Address` (
  `id` int(11) NOT NULL,
  `Country` varchar(100) DEFAULT NULL,
  `zip` char(10) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `script` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Basket`
--

CREATE TABLE `Basket` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `priceOF` int(10) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `deleteTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Category`
--

CREATE TABLE `Category` (
  `id` int(11) NOT NULL,
  `value` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Cupon`
--

CREATE TABLE `Cupon` (
  `id` int(11) NOT NULL,
  `code` char(12) DEFAULT NULL,
  `valideTime` date DEFAULT NULL,
  `expireTime` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Order`
--

CREATE TABLE `Order` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `uploadTime` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `finalPrice` int(10) DEFAULT NULL,
  `AddressID` int(11) DEFAULT NULL,
  `Changer` int(11) DEFAULT NULL,
  `ChangeTime` date DEFAULT NULL,
  `CuponID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `orderProduct`
--

CREATE TABLE `orderProduct` (
  `id` int(11) NOT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `priceOF` int(10) DEFAULT NULL,
  `OrderID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Product`
--

CREATE TABLE `Product` (
  `id` int(11) NOT NULL,
  `price` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `categoryID` int(11) DEFAULT NULL,
  `kep` varchar(100) DEFAULT NULL,
  `script` varchar(100) DEFAULT NULL,
  `priceOF` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ProductChange`
--

CREATE TABLE `ProductChange` (
  `id` int(11) NOT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `newprice` int(10) DEFAULT NULL,
  `newname` varchar(100) DEFAULT NULL,
  `newcategoryID` int(11) DEFAULT NULL,
  `newkep` varchar(100) DEFAULT NULL,
  `newscript` varchar(100) DEFAULT NULL,
  `newpriceOF` int(10) DEFAULT NULL,
  `oldprice` int(10) DEFAULT NULL,
  `oldname` varchar(100) DEFAULT NULL,
  `oldcategoryID` int(11) DEFAULT NULL,
  `oldkep` varchar(100) DEFAULT NULL,
  `oldscript` varchar(100) DEFAULT NULL,
  `oldpriceOF` int(10) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `changeAt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ProductTypes`
--

CREATE TABLE `ProductTypes` (
  `id` int(11) NOT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `TypeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `Type`
--

CREATE TABLE `Type` (
  `id` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  `phoneNum` char(9) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  `last_login` date DEFAULT NULL,
  `signTime` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`id`, `nickname`, `email`, `password`, `isAdmin`, `phoneNum`, `fname`, `lname`, `isActive`, `last_login`, `signTime`) VALUES
(1, 'Felhsznalónév', 'proba@gmail.com', 'aDmin123!', 1, '123', 'a', 'b', 1, NULL, '2023-05-17'),
(10, 'John', 'john99@gmail.com', 'ASDasd123', 0, '123456789', 'Elek', 'Chat', 1, NULL, '2023-06-09');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `userAddresses`
--

CREATE TABLE `userAddresses` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `AddressID` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `uploadDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `Address`
--
ALTER TABLE `Address`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `Basket`
--
ALTER TABLE `Basket`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `Cupon`
--
ALTER TABLE `Cupon`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `Order`
--
ALTER TABLE `Order`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `orderProduct`
--
ALTER TABLE `orderProduct`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `Product`
--
ALTER TABLE `Product`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `ProductChange`
--
ALTER TABLE `ProductChange`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `ProductTypes`
--
ALTER TABLE `ProductTypes`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `Type`
--
ALTER TABLE `Type`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `userAddresses`
--
ALTER TABLE `userAddresses`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `Address`
--
ALTER TABLE `Address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `Basket`
--
ALTER TABLE `Basket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `Category`
--
ALTER TABLE `Category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `Cupon`
--
ALTER TABLE `Cupon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `Order`
--
ALTER TABLE `Order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `orderProduct`
--
ALTER TABLE `orderProduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `Product`
--
ALTER TABLE `Product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `ProductChange`
--
ALTER TABLE `ProductChange`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `ProductTypes`
--
ALTER TABLE `ProductTypes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `Type`
--
ALTER TABLE `Type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT a táblához `userAddresses`
--
ALTER TABLE `userAddresses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
