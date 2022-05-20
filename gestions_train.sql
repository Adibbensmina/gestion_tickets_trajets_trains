/*!import this data to MYSQL */;
-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 20 mai 2022 à 17:59
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_train`
--

-- --------------------------------------------------------

--
-- Structure de la table `adminstrateur`
--

DROP TABLE IF EXISTS `adminstrateur`;
CREATE TABLE IF NOT EXISTS `adminstrateur` (
  `prenom` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adminstrateur`
--

INSERT INTO `adminstrateur` (`prenom`, `password`) VALUES
('admin', '1234'),
('hamid', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `places`
--

DROP TABLE IF EXISTS `places`;
CREATE TABLE IF NOT EXISTS `places` (
  `nom_place` varchar(50) NOT NULL,
  `count` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `places`
--

INSERT INTO `places` (`nom_place`, `count`, `id`) VALUES
('A1', 1, 1),
('A2', 0, 2),
('A3', 0, 3),
('A4', 0, 4),
('B1', 0, 5),
('B2', 0, 6),
('B3', 0, 7),
('B4', 0, 8),
('C1', 0, 9),
('C2', 0, 10),
('C3', 0, 11),
('C4', 0, 12),
('D1', 0, 13),
('D2', 0, 14),
('D3', 0, 15),
('D4', 0, 16),
('E1', 0, 17),
('E2', 0, 18),
('E3', 0, 19),
('E4', 0, 20);

-- --------------------------------------------------------

--
-- Structure de la table `train`
--

DROP TABLE IF EXISTS `train`;
CREATE TABLE IF NOT EXISTS `train` (
  `nom_train` varchar(220) NOT NULL,
  `source` varchar(220) DEFAULT NULL,
  `destination` varchar(220) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  `temps_depart` time DEFAULT NULL,
  `temps_arrive` time DEFAULT NULL,
  `date` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `train`
--

INSERT INTO `train` (`nom_train`, `source`, `destination`, `prix`, `temps_depart`, `temps_arrive`, `date`) VALUES
('bouraq', 'rabat', 'casablanca', 200, '10:30:00', '11:00:00', '2022-03-02'),
('bouraq', 'rachidia', 'agadir', 600, '10:45:00', '16:00:00', '2022-03-02'),
('bouraq', 'tanger', 'fes', 550, '16:00:00', '18:33:00', '2022-03-02'),
('bouraq', 'rabat', 'casablanca', 444, '18:00:00', '19:00:00', '2022-03-02'),
('bouraq', 'rabat', 'casablanca', 467, '17:44:44', '20:00:00', '2022-03-02'),
('bouraq', 'wajda', 'rabat', 500, '15:00:00', '17:30:00', '2022-03-02');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nom` varchar(225) NOT NULL,
  `prenom` varchar(225) NOT NULL,
  `email` varchar(225) NOT NULL,
  `password` varchar(225) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `nom`, `prenom`, `email`, `password`) VALUES
(1, 'adib', 'bens', 'adib@gmail.com', 'lalala'),
(2, 'fff', 'fff', 'ass@gmail.com', 'adil123'),
(3, 'hamza', 'khh', 'a@gma', 'aaaa88'),
(4, 'youns', 'elidrissi', 'uyiy@gmail.com', 'younes123'),
(5, 'youns', 'elidrissi', 'uyiy@gmail.com', 'gggg'),
(6, 'youns', 'elidrissi', 'uyiy@gmail.com', 'gggg'),
(9, 'hamza', 'gg', 'a@gmail.com', '1234'),
(10, 'lamane', 'john', 'aa@gmail.com', 'aaaa'),
(11, 'kamalo', 'jj', 'az@gmail', '123'),
(12, 'hame', 'poi', 'ad@gmail', '125'),
(23, 'Adib', 'Bensmina', 'adin@gmail.com', '1234'),
(19, 'chouai', 'mohamed', 'ak@gmail', '1234'),
(20, 'lamane', 'johnny', 'aa@gm', '111'),
(21, 'ahmed', 'hamza', 'az@gmail.com', '1234'),
(22, 'ag', 'gg', 'az@gmai', '23');

-- --------------------------------------------------------

--
-- Structure de la table `voyages`
--

DROP TABLE IF EXISTS `voyages`;
CREATE TABLE IF NOT EXISTS `voyages` (
  `nom` varchar(45) NOT NULL,
  `source` varchar(45) DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `nom_train` varchar(45) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  `temps_depart` time NOT NULL,
  `temps_arrive` time NOT NULL,
  `places` varchar(45) DEFAULT NULL,
  `total_prix` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `voyages`
--

INSERT INTO `voyages` (`nom`, `source`, `destination`, `nom_train`, `date`, `temps_depart`, `temps_arrive`, `places`, `total_prix`) VALUES
('bens', 'rabat', 'casablanca', 'bouraq', '2022-03-02', '10:30:00', '11:00:00', '1', '200'),
('bens', 'rabat', 'casablanca', 'bouraq', '2022-03-02', '10:30:00', '11:00:00', '1', '200');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
