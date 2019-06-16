SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`
(
  `blockhash`  char(64) NOT NULL,
  `confirmations` int NOT NULL,
  `strippedsize` int NOT NULL,
  `size`       int,
  `weight`     int,
  `height`     int NOT NULL,
  `version`    int,
  `merkleroot`  char(64) NOT NULL,
  `time`       timestamp NOT NULL,
  `nonce`    int,
  `difficulty` int,
  `chainwork`   char(64) NOT NULL,
  `txsize`     int,
  `next_block` char(64),
  `prev_block` char(64),
  PRIMARY KEY (`blockhash`),
  index `idx_height` (`height`),
  index `idx_time` (`time`),
  index `idx_chainwork` (`chainwork`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



