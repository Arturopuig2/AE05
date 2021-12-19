-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 19-12-2021 a las 18:09:18
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `library`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `BooksCSV`
--

CREATE TABLE `BooksCSV` (
  `ID` int(11) NOT NULL,
  `Titulo` varchar(255) DEFAULT NULL,
  `Autor` varchar(255) DEFAULT NULL,
  `Anyo_nacimiento` varchar(255) DEFAULT NULL,
  `Anyo_publicacion` varchar(255) DEFAULT NULL,
  `Editorial` varchar(255) DEFAULT NULL,
  `Numero_de_paginas` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `BooksCSV`
--

INSERT INTO `BooksCSV` (`ID`, `Titulo`, `Autor`, `Anyo_nacimiento`, `Anyo_publicacion`, `Editorial`, `Numero_de_paginas`) VALUES
(1, 'El señor de los anillos', 'J.R.R. Tolkien', '1890', '1950', 'Minotauro', '1392'),
(2, 'El juego de Ender', 'Orson Scott Card', '1951', '1977', 'Ediciones B', '509'),
(3, 'Lazarillo de Tormes', 'Anónimo', '', '1554', 'Clásicos Populares', '150'),
(4, 'Las uvas de la ira', 'John Steinbeck', '1902', '1939', 'Alianza', '619'),
(5, 'Watchmen', 'Alan Moore', '1953', '1980', 'ECC', '416'),
(6, 'La hoguera de las vanidades', 'Tom Wolfe', '1930', '1980', 'Anagrama', '636'),
(7, 'La familia de Pascual Duarte', 'Camilo José Cela', '1916', '1942', 'Destino', '165'),
(8, 'El señor de las moscas', 'William Golding', '1911', '1972', 'Alianza', '236'),
(9, 'La ciudad de los prodigios', 'Eduardo Mendoza', '1943', '1986', 'Seix Barral', '541'),
(10, 'Ensayo sobre la ceguera', 'José Saramago', '1922', '1995', 'Santillana', '439'),
(11, 'Los surcos del azar', 'Paco Roca', '1969', '2013', 'Astiberri', '349'),
(12, 'Ghosts of Spain', 'Giles Tremlett', '1962', '2006', 'Faber & Faber', '468'),
(13, 'Sidi', 'Arturo Pérez Reverte', '1951', '2019', 'Penguin', '369'),
(14, 'Dune', 'Frank Herbert', '1920', '1965', 'Acervo', '741');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `BooksCSV`
--
ALTER TABLE `BooksCSV`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `BooksCSV`
--
ALTER TABLE `BooksCSV`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
