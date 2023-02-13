-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-02-2023 a las 13:15:29
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `personasyoficios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_oficio`
--

CREATE TABLE `categoria_oficio` (
  `ID_CATEGORIA` int(3) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria_oficio`
--

INSERT INTO `categoria_oficio` (`ID_CATEGORIA`, `DESCRIPCION`) VALUES
(1, 'Medicina'),
(2, 'Informática'),
(3, 'Enseñanza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficios`
--

CREATE TABLE `oficios` (
  `ID_OFICIO` int(3) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL,
  `SUELDO` double NOT NULL,
  `ID_CATEGORIA` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oficios`
--

INSERT INTO `oficios` (`ID_OFICIO`, `DESCRIPCION`, `SUELDO`, `ID_CATEGORIA`) VALUES
(1, 'Programador', 23.8, 2),
(2, 'Profe Mates', 15.78, 3),
(3, 'Oftalmologo', 28.78, 1),
(4, 'Pediatra', 18.64, 1),
(5, 'Profe Lengua', 17.78, 3),
(6, 'Creador Videojuegos', 20.05, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `ID_PERSONA` int(3) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `GMAIL` varchar(25) NOT NULL,
  `EDAD` int(3) NOT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `ID_OFICIO` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`ID_PERSONA`, `NOMBRE`, `GMAIL`, `EDAD`, `FECHA_NACIMIENTO`, `ID_OFICIO`) VALUES
(1, 'Jesús', 'jesus@hotmail.es', 23, '1997-08-23', 4),
(2, 'Manuel', 'manu@gmail.es', 56, '1968-04-24', 6),
(3, 'David', 'david@gmail.com', 22, '2000-03-18', 1),
(4, 'Federico', 'fede@gnome.org', 44, '1978-08-16', 1),
(5, 'Maria', 'mari@gmail.com', 28, '1994-05-06', 5),
(6, 'Jorge', 'jorgito@hotmail.org', 34, '1984-09-05', 6),
(7, 'Daniel', 'dani@zone.edu', 67, '1954-09-12', 3),
(8, 'Lucas', 'luca@gmail.es', 41, '1979-05-28', 5),
(9, 'Fabio', 'fabio@amazon.es', 29, '1991-12-08', 1),
(11, 'Antonio', 'antony@hotmail.es', 38, '1983-08-23', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria_oficio`
--
ALTER TABLE `categoria_oficio`
  ADD PRIMARY KEY (`ID_CATEGORIA`);

--
-- Indices de la tabla `oficios`
--
ALTER TABLE `oficios`
  ADD PRIMARY KEY (`ID_OFICIO`),
  ADD KEY `ID_CATEGORIA` (`ID_CATEGORIA`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`ID_PERSONA`),
  ADD KEY `ID_OFICIO` (`ID_OFICIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria_oficio`
--
ALTER TABLE `categoria_oficio`
  MODIFY `ID_CATEGORIA` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `oficios`
--
ALTER TABLE `oficios`
  MODIFY `ID_OFICIO` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `ID_PERSONA` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `oficios`
--
ALTER TABLE `oficios`
  ADD CONSTRAINT `oficios_ibfk_1` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria_oficio` (`ID_CATEGORIA`);

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`ID_OFICIO`) REFERENCES `oficios` (`ID_OFICIO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
