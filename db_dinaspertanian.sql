-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 26 Des 2018 pada 10.05
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
-- Struktur dari tabel `bantuan`
--

CREATE TABLE `bantuan` (
  `id` bigint(20) NOT NULL,
  `deskripsi` longtext,
  `nama_bantuan` varchar(255) DEFAULT NULL,
  `proposal` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `id_kelompok` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `bantuan`
--

INSERT INTO `bantuan` (`id`, `deskripsi`, `nama_bantuan`, `proposal`, `status`, `tanggal`, `version`, `id_kelompok`) VALUES
(85, 'Qwerty', 'Coke', 'TCPServer.java', '2', '2018-12-19', 2, 68),
(86, 'sdvsd', 'sdvsv', 'TCPServer.class', '0', '2018-12-19', 1, 68);

-- --------------------------------------------------------

--
-- Struktur dari tabel `berita`
--

CREATE TABLE `berita` (
  `id` bigint(20) NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `isi` longtext,
  `judul` varchar(255) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `berita`
--

INSERT INTO `berita` (`id`, `foto`, `id_user`, `isi`, `judul`, `tanggal`, `version`) VALUES
(59, '33171470_1537599144170404_r.jpeg', 68, 'Taipei Economic and Trade Office (TETO) yang berkolaborasi dengan Taiwan Technical Mission (TTM) mengadakan seminar pertanian dengan tema \"42 Tahun Kerja Sama Pertanian Taiwan dan Indonesia\" dari tanggal 5 hingga 8 Desember 2018.\r\n\r\nSeminar pertanian yang diikuti oleh 100 orang Taiwan dan Indonesia ini merupakan bagian dari kebijakan New Southbound Policy yang telah dijalankan oleh pemerintah Taiwan.\r\n\r\nDiharapkan, dengan adanya seminar ini dapat meningkatkan wawasan, pengetahuan dan kerja sama dalam bidang pertanian antara kedua negara, demikian keterangan pers yang diterima oleh Liputan6.com dari TETO yang berada di Jakarta pada Jumat (7/12/2018).', 'Indonesia dan Taiwan Perkuat', '2018-12-06', 7),
(62, 'hairy_sphere-wallpaper-3554x1999.jpg', 68, 'Program kedaulatan pangan dan produktivitas pangan memang mampu meningkatkan kuantitas jumlah produksi. Namun, tidak mengalami peningkatan pada aspek nilai produksi. Hal ini dapat kita lihat bahwa peningkatan produksi tidak berbanding lurus dengan penurunan angka kelaparan dan gizi buruk. FAO menyatakan bahwa pada 2016 setidaknya 10,7% atau sekitar 815 juta orang di dunia mengalami gizi buruk. Demikian pula UNICEF, WHO, dan World Bank yang mengatakan bahwa pada 2017 ada sekitar 150 juta anak balita di dunia ini mengalami stunting. \r\n\r\nMasyarakat yang mengalami kelaparan dan stunting tersebut mayoritas dari negara berkembang dan mereka dari keluarga miskin di perdesaan yang notabene dari keluarga petani gurem dan buruh tani. Permasalahan tersebut menunjukkan bahwa konsep pembangunan pertanian khususnya pertanian pangan masih memunculkan paradoks. ', 'Kedaulatan Pangan dan Paradoks Pembangunan Pertanian', '2018-12-10', 3),
(74, 'incomplete.jpg', 68, 'Berita natal', 'Perayaan natal sekolah minggu di Desa Sitoluama cukup meriah', '2018-12-13', 2),
(118, 'apple_magic_mouse_2_colorful_lighting-wallpaper-3554x1999.jpg', 68, 'As straightforward as it might be in a RDBMS, when it comes to JPA, the one-to-many database association can be represented either through a @ManyToOne or a @OneToMany association since the OOP association can be either unidirectional or bidirectional.\r\n\r\nThe @ManyToOne annotation allows you to map the Foreign Key column in the child entity mapping so that the child has an entity object reference to its parent entity. This is the most natural way of mapping a database one-to-many database association, and, usually, the most efficient alternative too.\r\n\r\nFor convenience, to take advantage of the entity state transitions and the dirty checking mechanism, many developers choose to map the child entities as a collection in the parent object, and, for this purpose, JPA offers the @OneToMany annotation.\r\n\r\nAs I explained in my book, many times, you are better off replacing collections with a query, which is much more flexible in terms of fetching performance. However, there are times when mapping a collection is the right thing to do, and then you have two choices:', 'The best way to map a @OneToMany', '2018-12-22', 1),
(121, 'Screenshot from 2018-12-10 17-04-00.png', 68, 'Default Options\r\nWe can also change these default values for each Doughnut type that is created, this object is available at Chart.defaults.doughnut. Pie charts also have a clone of these defaults available to change at Chart.defaults.pie, with the only difference being cutoutPercentage being set to 0.\r\n\r\nData Structure\r\nFor a pie chart, datasets need to contain an array of data points. The data points should be a number, Chart.js will total all of the numbers and calculate the relative proportion of each.\r\n\r\nYou also need to specify an array of labels so that tooltips appear correctly', 'Integrating Chart JS Library With Java', '2018-12-24', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `harga_komoditi`
--

CREATE TABLE `harga_komoditi` (
  `id` bigint(20) NOT NULL,
  `harga` int(11) DEFAULT NULL,
  `tanggal` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `id_komoditi` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `harga_komoditi`
--

INSERT INTO `harga_komoditi` (`id`, `harga`, `tanggal`, `version`, `id_komoditi`) VALUES
(108, 1000000, '2018-12-24 01:06:04', 0, 87),
(109, 1235000000, '2018-12-24 01:12:17', 0, 87),
(110, 15000, '2018-12-24 01:14:44', 0, 89),
(115, 22000, '2018-12-24 01:37:29', 0, 113),
(116, 22, '2018-12-24 01:38:42', 0, 112),
(117, 11000, '2018-12-24 01:38:48', 0, 111);

-- --------------------------------------------------------

--
-- Struktur dari tabel `hasil_pertanian`
--

CREATE TABLE `hasil_pertanian` (
  `id` bigint(20) NOT NULL,
  `jumlah_hasil_panen` int(11) DEFAULT NULL,
  `luas_lahan` int(11) DEFAULT NULL,
  `id_kelompok` bigint(20) DEFAULT NULL,
  `id_komoditi` bigint(20) DEFAULT NULL,
  `bulan` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `hasil_pertanian`
--

INSERT INTO `hasil_pertanian` (`id`, `jumlah_hasil_panen`, `luas_lahan`, `id_kelompok`, `id_komoditi`, `bulan`, `version`) VALUES
(90, 600, 300, 68, 87, '2018-01-19 00:00:00', 2),
(92, 1000, 1000, 124, 111, '2018-02-21 00:00:00', 1),
(93, 890, 500, 68, 89, '2018-03-22 00:00:00', 0),
(123, 1500, 11, 68, 87, '2018-04-27 00:00:00', 0),
(124, 700, 11, 68, 87, '2018-05-27 00:00:00', 0),
(125, 345, 11, 124, 112, '2018-06-26 00:00:00', 1),
(126, 444, 11, 68, 87, '2018-07-27 00:00:00', 0),
(127, 500, 11, 61, 87, '2018-08-27 00:00:00', 0),
(128, 580, 11, 64, 89, '2018-09-27 00:00:00', 0),
(129, 790, 11, 44, 89, '2018-10-27 00:00:00', 0),
(130, 900, 11, 55, 87, '2018-11-27 00:00:00', 0),
(131, 698, 11, 124, 113, '2018-12-26 00:00:00', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(125),
(125);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kecamatan`
--

CREATE TABLE `kecamatan` (
  `id` bigint(20) NOT NULL,
  `nama_kecamatan` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `kecamatan`
--

INSERT INTO `kecamatan` (`id`, `nama_kecamatan`, `version`) VALUES
(63, 'Laguboti', 1),
(64, 'Balige', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelompok_tani`
--

CREATE TABLE `kelompok_tani` (
  `id_kecamatan` bigint(20) DEFAULT NULL,
  `id_kelurahan` bigint(20) DEFAULT NULL,
  `jumlah_anggota` int(11) DEFAULT NULL,
  `luas_darat` int(11) DEFAULT NULL,
  `luas_sawah` int(11) DEFAULT NULL,
  `nama_kelompok` varchar(255) DEFAULT NULL,
  `no_telepon` varchar(255) DEFAULT NULL,
  `proposal` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `kelompok_tani`
--

INSERT INTO `kelompok_tani` (`id_kecamatan`, `id_kelurahan`, `jumlah_anggota`, `luas_darat`, `luas_sawah`, `nama_kelompok`, `no_telepon`, `proposal`, `status`, `version`, `user_id`) VALUES
(64, 65, 90, 2500, 23, 'Maju bersama', '082272220000', 'wolf.jpg', '1', 3, 68),
(63, 65, 150, 21, 23, 'Martani Hita', '0909', 'Untitled-1.xml', '2', 3, 124);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelompok_tani_bantuan_kelompok`
--

CREATE TABLE `kelompok_tani_bantuan_kelompok` (
  `kelompok_tani_user_id` bigint(20) NOT NULL,
  `bantuan_kelompok_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelompok_tani_hasil_pertanian_kelompok`
--

CREATE TABLE `kelompok_tani_hasil_pertanian_kelompok` (
  `kelompok_tani_user_id` bigint(20) NOT NULL,
  `hasil_pertanian_kelompok_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelompok_tani_laporan_kelompok`
--

CREATE TABLE `kelompok_tani_laporan_kelompok` (
  `kelompok_tani_user_id` bigint(20) NOT NULL,
  `laporan_kelompok_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelurahan`
--

CREATE TABLE `kelurahan` (
  `id` bigint(20) NOT NULL,
  `id_kecamatan` bigint(20) DEFAULT NULL,
  `nama_kelurahan` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `kelurahan`
--

INSERT INTO `kelurahan` (`id`, `id_kecamatan`, `nama_kelurahan`, `version`) VALUES
(65, 64, 'Sitoluama', 1),
(66, 63, 'Pintu Bosi', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `komentar_berita`
--

CREATE TABLE `komentar_berita` (
  `id` int(11) NOT NULL,
  `id_berita` bigint(20) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `isi` longtext,
  `waktu` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `komentar_berita`
--

INSERT INTO `komentar_berita` (`id`, `id_berita`, `id_user`, `isi`, `waktu`) VALUES
(39, 34, 10, 'koko', '2018-12-13 15:53:53'),
(40, 34, 10, 'Box', '2018-12-13 16:57:30'),
(41, 34, 10, 'cie', '2018-12-13 17:04:46'),
(43, 42, 10, 'yeay!', '2018-12-13 17:09:44'),
(45, 42, 44, 'Baru join, salam kenal @Emrycho', '2018-12-13 23:24:55'),
(46, 42, 44, 'halo? apakah thread ini masih aktif?', '2018-12-13 23:28:28'),
(47, 42, 10, 'tentu saja :D \r\nsama-sama pak @Andy J', '2018-12-13 23:29:37'),
(48, 42, 10, 'dohar!', '2018-12-14 00:58:01'),
(49, 42, 44, 'thanks @Emrycho', '2018-12-14 03:55:29'),
(52, 50, 44, 'jejak', '2018-12-14 06:39:56'),
(53, 50, 44, 'cool', '2018-12-14 06:42:45'),
(54, 50, 44, 'merry xmas', '2018-12-14 06:43:06'),
(55, 50, 44, 'hehe', '2018-12-14 06:43:11'),
(56, 50, 44, 'trus?', '2018-12-14 06:43:19'),
(57, 50, 44, 'jo', '2018-12-14 06:44:08'),
(58, 42, 44, 'jangan spam lagi ya!', '2018-12-14 06:44:40'),
(70, 59, 68, 'lontong', '2018-12-16 10:34:59'),
(71, 59, 68, 'seriusan nih?', '2018-12-16 13:14:52'),
(72, 59, 68, 'gua ga yakin kayakny', '2018-12-16 13:15:17'),
(73, 62, 68, 'cool', '2018-12-16 13:22:53'),
(75, 74, 68, 'semoga bermanfaat :D', '2018-12-16 13:48:08'),
(76, 74, 68, 'wow', '2018-12-17 03:47:32'),
(77, 74, 68, 'oke', '2018-12-17 03:47:40'),
(119, 74, 69, 'mantap bos', '2018-12-24 09:54:54'),
(120, 74, 69, 'iya ga?', '2018-12-24 09:55:04');

-- --------------------------------------------------------

--
-- Struktur dari tabel `komoditi`
--

CREATE TABLE `komoditi` (
  `id` bigint(20) NOT NULL,
  `deskripsi` longtext,
  `foto` varchar(255) DEFAULT NULL,
  `lama_panen` varchar(255) DEFAULT NULL,
  `nama_komoditi` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `komoditi`
--

INSERT INTO `komoditi` (`id`, `deskripsi`, `foto`, `lama_panen`, `nama_komoditi`, `version`) VALUES
(87, 'Cabai merupakan komoditi terbanyak dari daerah ini.', 'lamborghini_terzo_millenio_4k_render_by_alireza_pourjabbar-wallpaper-3554x1999.jpg', '2-3 bulan', 'Cabai', 1),
(89, 'Jangung merupakan sumber pendapatan terbesar kedua setelah caiba', 'wolf.jpg', '6 minggu', 'Jagung', 0),
(111, 'Apa aja', 'incomplete.jpg', '3 tahun', 'Kopi', 0),
(112, 'Apa', 'wolf.jpg', '6 bulan', 'Nenas', 0),
(113, 'Apa', 'wolf.jpg', '1 tahun', 'Alpukat', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `komoditi_harga_komoditi`
--

CREATE TABLE `komoditi_harga_komoditi` (
  `komoditi_id` bigint(20) NOT NULL,
  `harga_komoditi_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur dari tabel `komoditi_hasil_pertanian`
--

CREATE TABLE `komoditi_hasil_pertanian` (
  `komoditi_id` bigint(20) NOT NULL,
  `hasil_pertanian_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan_kelompok`
--

CREATE TABLE `laporan_kelompok` (
  `id` bigint(20) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `laporan` varchar(255) DEFAULT NULL,
  `nama_laporan` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `id_kelompok` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `laporan_kelompok`
--

INSERT INTO `laporan_kelompok` (`id`, `deskripsi`, `laporan`, `nama_laporan`, `status`, `tanggal`, `version`, `id_kelompok`) VALUES
(81, 'Qwerty', 'ibKU_Rych.pdf', 'Laporan Bulan Desember 2018', '1', '2018-12-17', 2, 68),
(82, 'Go', 'Untitled-1.xml', 'Laporan Bulan November 2018', '0', '2018-12-19', 1, 68),
(83, 'sdjh', 'TCPServer.java', 'Laporan Bulan Oktober 2018', '0', '2018-12-10', 2, 68);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengumuman`
--

CREATE TABLE `pengumuman` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `isi` longtext,
  `judul` varchar(255) DEFAULT NULL,
  `lampiran` varchar(255) DEFAULT NULL,
  `tanggal` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `pengumuman`
--

INSERT INTO `pengumuman` (`id`, `id_user`, `isi`, `judul`, `lampiran`, `tanggal`, `version`) VALUES
(1, 68, 'As straightforward as it might be in a RDBMS, when it comes to JPA, the one-to-many database association can be represented either through a @ManyToOne or a @OneToMany association since the OOP association can be either unidirectional or bidirectional.\r\n\r\nThe @ManyToOne annotation allows you to map the Foreign Key column in the child entity mapping so that the child has an entity object reference to its parent entity. This is the most natural way of mapping a database one-to-many database association, and, usually, the most efficient alternative too.\r\n\r\nFor convenience, to take advantage of the entity state transitions and the dirty checking mechanism, many developers choose to map the child entities as a collection in the parent object, and, for this purpose, JPA offers the @OneToMany annotation.\r\n\r\nAs I explained in my book, many times, you are better off replacing collections with a query, which is much more flexible in terms of fetching performance. However, there are times when mapping a collection is the right thing to do, and then you have two choices:', 'Layanan Dinas Pertanian saat libur natal berlangsung', 'lamborghini_terzo_millenio_4k_render_by_alireza_pourjabbar-wallpaper-3554x1999.jpg', '2018-12-24 02:13:39', 0),
(2, 68, 'As straightforward as it might be in a RDBMS, when it comes to JPA, the one-to-many database association can be represented either through a @ManyToOne or a @OneToMany association since the OOP association can be either unidirectional or bidirectional.\r\n\r\nThe @ManyToOne annotation allows you to map the Foreign Key column in the child entity mapping so that the child has an entity object reference to its parent entity. This is the most natural way of mapping a database one-to-many database association, and, usually, the most efficient alternative too.\r\n\r\nFor convenience, to take advantage of the entity state transitions and the dirty checking mechanism, many developers choose to map the child entities as a collection in the parent object, and, for this purpose, JPA offers the @OneToMany annotation.\r\n\r\nAs I explained in my book, many times, you are better off replacing collections with a query, which is much more flexible in terms of fetching performance. However, there are times when mapping a collection is the right thing to do, and then you have two choices:', 'Menteri dinas pertanian menyatakan selamat Natal bagi seluruh masyarakat Indonesia', 'Screenshot from 2018-12-06 09-47-23.png', '2018-12-24 02:14:11', 0),
(3, 68, 'As straightforward as it might be in a RDBMS, when it comes to JPA, the one-to-many database association can be represented either through a @ManyToOne or a @OneToMany association since the OOP association can be either unidirectional or bidirectional.\r\n\r\nThe @ManyToOne annotation allows you to map the Foreign Key column in the child entity mapping so that the child has an entity object reference to its parent entity. This is the most natural way of mapping a database one-to-many database association, and, usually, the most efficient alternative too.\r\n\r\nFor convenience, to take advantage of the entity state transitions and the dirty checking mechanism, many developers choose to map the child entities as a collection in the parent object, and, for this purpose, JPA offers the @OneToMany annotation.\r\n\r\nAs I explained in my book, many times, you are better off replacing collections with a query, which is much more flexible in terms of fetching performance. However, there are times when mapping a collection is the right thing to do, and then you have two choices:', 'Dinas Pertanian melakukan penyuluhan di desa Sitoluama', 'cowboys.jpeg', '2018-12-24 02:14:26', 0),
(4, 68, 'As straightforward as it might be in a RDBMS, when it comes to JPA, the one-to-many database association can be represented either through a @ManyToOne or a @OneToMany association since the OOP association can be either unidirectional or bidirectional.\r\n\r\nThe @ManyToOne annotation allows you to map the Foreign Key column in the child entity mapping so that the child has an entity object reference to its parent entity. This is the most natural way of mapping a database one-to-many database association, and, usually, the most efficient alternative too.\r\n\r\nFor convenience, to take advantage of the entity state transitions and the dirty checking mechanism, many developers choose to map the child entities as a collection in the parent object, and, for this purpose, JPA offers the @OneToMany annotation.\r\n\r\nAs I explained in my book, many times, you are better off replacing collections with a query, which is much more flexible in terms of fetching performance. However, there are times when mapping a collection is the right thing to do, and then you have two choices:', 'Kunjungan Bupati bersama Rombongan ke desa sitoluama', 'hairy_sphere-wallpaper-3554x1999.jpg', '2018-12-24 02:14:38', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'KETUA');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` int(11) NOT NULL,
  `alamat_desa` varchar(255) DEFAULT NULL,
  `alamat_dusun` varchar(255) DEFAULT NULL,
  `alamat_kecamatan` varchar(255) DEFAULT NULL,
  `alamat_rt_rw` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `nama_belakang` varchar(255) DEFAULT NULL,
  `nama_depan` varchar(255) DEFAULT NULL,
  `nik` bigint(20) DEFAULT NULL,
  `nohp` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `tempat_lahir` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `active`, `alamat_desa`, `alamat_dusun`, `alamat_kecamatan`, `alamat_rt_rw`, `email`, `jenis_kelamin`, `nama_belakang`, `nama_depan`, `nik`, `nohp`, `password`, `tanggal_lahir`, `tempat_lahir`, `username`) VALUES
(68, 1, 'Tapian Nauli', 'Tano Lapang', 'Sipoholon', '-/-', 'emricho1412@gmail.com', 'Laki-laki', 'Simanungkalit', 'Emrycho C J', 1231231, '082272683290', '$2a$10$2KDqT3VE72AP069DLN.2ruqY44QaviYG.uF8jbZrhfC3DWN9ro1ue', '1998-12-13', 'Jambi', 'emrycho'),
(124, 1, 'Stockiz', 'Firzh', 'Hoiperz', '1/2', 'matt.white@gmail.com', 'Laki-laki', 'Zuck', 'Matt', 2324324, '0932232', '$2a$10$akovUaYzKtLej6sBehn.AO3AN3iAP33xihuHdNhxTK.HhQiId2OC.', '1990-11-11', 'Kizech', 'matt_white');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(68, 1),
(69, 2),
(122, 1),
(123, 1),
(124, 2);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bantuan`
--
ALTER TABLE `bantuan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKirfa67y4w7xfig7e6ajmkmstw` (`id_kelompok`);

--
-- Indeks untuk tabel `berita`
--
ALTER TABLE `berita`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `harga_komoditi`
--
ALTER TABLE `harga_komoditi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmanbf8u2xa8k4cg3cr4c156vs` (`id_komoditi`);

--
-- Indeks untuk tabel `hasil_pertanian`
--
ALTER TABLE `hasil_pertanian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmyskyfv0x5puuenm0frjnb9kb` (`id_kelompok`),
  ADD KEY `FKhu3p1xwexqirx1wlijnd71e93` (`id_komoditi`);

--
-- Indeks untuk tabel `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `kelompok_tani`
--
ALTER TABLE `kelompok_tani`
  ADD PRIMARY KEY (`user_id`);

--
-- Indeks untuk tabel `kelompok_tani_bantuan_kelompok`
--
ALTER TABLE `kelompok_tani_bantuan_kelompok`
  ADD PRIMARY KEY (`kelompok_tani_user_id`,`bantuan_kelompok_id`),
  ADD UNIQUE KEY `UK_9wr4jfxhbc1ouc17mf4bok61i` (`bantuan_kelompok_id`);

--
-- Indeks untuk tabel `kelompok_tani_hasil_pertanian_kelompok`
--
ALTER TABLE `kelompok_tani_hasil_pertanian_kelompok`
  ADD PRIMARY KEY (`kelompok_tani_user_id`,`hasil_pertanian_kelompok_id`),
  ADD UNIQUE KEY `UK_88bev8xq5ktjyknxjlk2tcy3t` (`hasil_pertanian_kelompok_id`);

--
-- Indeks untuk tabel `kelompok_tani_laporan_kelompok`
--
ALTER TABLE `kelompok_tani_laporan_kelompok`
  ADD PRIMARY KEY (`kelompok_tani_user_id`,`laporan_kelompok_id`),
  ADD UNIQUE KEY `UK_rrb8792d7bcfnogcm47hoy9l2` (`laporan_kelompok_id`);

--
-- Indeks untuk tabel `kelurahan`
--
ALTER TABLE `kelurahan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `komentar_berita`
--
ALTER TABLE `komentar_berita`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `komoditi`
--
ALTER TABLE `komoditi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `komoditi_harga_komoditi`
--
ALTER TABLE `komoditi_harga_komoditi`
  ADD PRIMARY KEY (`komoditi_id`,`harga_komoditi_id`),
  ADD UNIQUE KEY `UK_on2erth2ccjlb1a3yhoqem347` (`harga_komoditi_id`);

--
-- Indeks untuk tabel `komoditi_hasil_pertanian`
--
ALTER TABLE `komoditi_hasil_pertanian`
  ADD PRIMARY KEY (`komoditi_id`,`hasil_pertanian_id`),
  ADD UNIQUE KEY `UK_q0s0j3jufew50oe1xvjmvlukc` (`hasil_pertanian_id`);

--
-- Indeks untuk tabel `laporan_kelompok`
--
ALTER TABLE `laporan_kelompok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKislq9ieqad97ea7ca480q00eb` (`id_kelompok`);

--
-- Indeks untuk tabel `pengumuman`
--
ALTER TABLE `pengumuman`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indeks untuk tabel `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pengumuman`
--
ALTER TABLE `pengumuman`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
