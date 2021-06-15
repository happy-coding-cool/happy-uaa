DROP TABLE IF EXISTS `oauth_client_details`;
create table oauth_client_details (
      `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
      `client_id` VARCHAR(256) COLLATE utf8mb4_bin NOT NULL COMMENT '应用标识',
      `client_secret` VARCHAR(256) COLLATE utf8mb4_bin NOT NULL COMMENT '应用密钥',
      `resource_ids` VARCHAR(256) COLLATE utf8mb4_bin NULL COMMENT '资源标识',
      `scope` VARCHAR(256) COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '授权范围',
      `authorized_grant_types` VARCHAR(256) COLLATE utf8mb4_bin NOT NULL COMMENT '5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)',
      `web_server_redirect_uri` VARCHAR(256) COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '回调地址',
      `authorities` VARCHAR(256) COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限',
      `access_token_validity` int(11) NULL DEFAULT NULL COMMENT 'access_token有效期',
      `refresh_token_validity` int(11) NULL DEFAULT NULL COMMENT 'refresh_token有效期',
      `additional_information` VARCHAR(4096) COLLATE utf8mb4_bin NULL DEFAULT '{}' COMMENT '{}',
      `autoapprove` VARCHAR(256) COLLATE utf8mb4_bin NOT NULL DEFAULT 'true' COMMENT '是否自动授权 是-true',
      `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
      `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
      `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
      `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
      `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE KEY `uniq_h_client_id` (`client_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT '应用信息';