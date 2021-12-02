-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 22 Mai 2017 à 02:53
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `login`
--

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(8) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `sexe` varchar(50) NOT NULL,
  `statut` varchar(50) NOT NULL,
  `num_tele` int(8) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `cin` int(8) NOT NULL,
  `pwd` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `sexe`, `statut`, `num_tele`, `mail`, `cin`, `pwd`) VALUES
(8, 'tunis', 'yahiaoui', 'homme', 'Employer', 52210522, 'ahh@sq.ds', 85115655, 'azertyui'),
(9, 'sondes', 'kaabechi', 'homme', 'etudiant', 23568974, 'Sondes@sondes.sl', 7895, 'sondes');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(2, '123', '123'),
(3, 'baymen', 'baymen');

-- --------------------------------------------------------

--
-- Structure de la table `user_acc`
--

CREATE TABLE `user_acc` (
  `id` int(10) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `mail` varchar(250) NOT NULL,
  `pwd` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_acc`
--

INSERT INTO `user_acc` (`id`, `nom`, `mail`, `pwd`) VALUES
(3, 'Ahmed', 'ahmeddada2009@live.com', '123456'),
(5, 'Othmen', 'othmen.zarga@gmail.com', '123123'),
(12, 'tunis', 'ahh@sq.ds', 'azertyui'),
(13, 'tunis', 'ahh@sq.ds', 'azertyui'),
(14, 'sondes', 'Sondes@sondes.sl', 'sondes'),
(15, 'tunis', 'ahh@sq.ds', 'azertyui');

-- --------------------------------------------------------

--
-- Structure de la table `zone`
--

CREATE TABLE `zone` (
  `id` int(11) NOT NULL,
  `altitude` double NOT NULL,
  `longitude` double NOT NULL,
  `nom` varchar(20) NOT NULL,
  `radius1` int(10) NOT NULL,
  `radius2` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `zone`
--

INSERT INTO `zone` (`id`, `altitude`, `longitude`, `nom`, `radius1`, `radius2`) VALUES
(27, 36.80973, 10.15237, 'Tunis', 20000, 30000),
(28, 36.8318461, 10.2111016, 'Lac', 900, 1000),
(29, 36.8281174, 9.8912185, '', 600, 1000),
(30, 35.824119, 10.608314, '', 1000, 6000),
(31, 35.775337, 10.628189, '', 1000, 6000),
(32, 35.770692, 10.823624, '', 1000, 3000),
(33, 36.407696, 10.144525, '', 5000, 10000),
(34, 36.167614, 8.708507, '', 3000, 5000);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_acc`
--
ALTER TABLE `user_acc`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `zone`
--
ALTER TABLE `zone`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `user_acc`
--
ALTER TABLE `user_acc`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `zone`
--
ALTER TABLE `zone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
