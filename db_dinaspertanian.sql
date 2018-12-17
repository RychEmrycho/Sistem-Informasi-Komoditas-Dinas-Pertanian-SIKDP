-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 07 Des 2018 pada 02.56
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_dinaspertanian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelompok_tani`
--

CREATE TABLE `kelompok_tani` (
  `id` int(11) NOT NULL,
  `ketua` varchar(255) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `kelurahan_id` int(11) DEFAULT NULL,
  `luas_darat` int(11) DEFAULT NULL,
  `luas_sawah` int(11) DEFAULT NULL,
  `nama_kelompok` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `kelompok_tani`
--

INSERT INTO `kelompok_tani` (`id`, `ketua`, `account_id`, `jumlah`, `kelurahan_id`, `luas_darat`, `luas_sawah`, `nama_kelompok`, `version`) VALUES
(1, 'Oke', NULL, 22, NULL, 32, 32, 'Mantap', 0),
(2, 'Banget', NULL, 32, NULL, 43, 54, 'Gue', 0);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kelompok_tani`
--
ALTER TABLE `kelompok_tani`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `kelompok_tani`
--
ALTER TABLE `kelompok_tani`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
