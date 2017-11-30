-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
`id` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `commit_created` datetime DEFAULT NULL,
  `user_from` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_to` varchar(255) NOT NULL,
  `commit_updated` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=578 DEFAULT CHARSET=latin1;
