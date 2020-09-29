
CREATE TABLE IF NOT EXISTS permissions (
	id				BIGINT			AUTO_INCREMENT,
	short_name		VARCHAR(24)		NOT NULL,
	description		VARCHAR(128)	NOT NULL,

	CONSTRAINT pk_permissions PRIMARY KEY (id),
	CONSTRAINT uk_permissions UNIQUE KEY (short_name)
);

CREATE TABLE IF NOT EXISTS profiles (
	id				BIGINT			AUTO_INCREMENT,
	short_name		VARCHAR(16)		NOT NULL,
	name			VARCHAR(32)		NOT NULL,
	description		VARCHAR(128)	NOT NULL,
	display_order	INT(03)			NOT NULL DEFAULT 999,

	CONSTRAINT pk_profiles PRIMARY KEY (id),
	CONSTRAINT uk_profiles UNIQUE KEY (short_name)
);

CREATE TABLE IF NOT EXISTS profile_permissions (
	id				BIGINT			AUTO_INCREMENT,
	profile			BIGINT			NOT NULL,
	permission		BIGINT			NOT NULL,

	CONSTRAINT pk_profile_permissions PRIMARY KEY (id),
	CONSTRAINT uk_profile_permissions UNIQUE KEY (profile, permission),
	CONSTRAINT fk_profile_permissions_profile FOREIGN KEY (profile) REFERENCES profiles(id),
	CONSTRAINT fk_profile_permissions_permission FOREIGN KEY (permission) REFERENCES permissions(id),
	INDEX idx_profile_permissions (profile, permission)
);

CREATE TABLE IF NOT EXISTS users (
	id				BIGINT			AUTO_INCREMENT,
	username		VARCHAR(32)		NOT NULL,
	passwrod		VARCHAR(36) 	NOT NULL,
	email			VARCHAR(64) 	NOT NULL,
	lastIp			INT				NULL,
	profile			BIGINT			NULL,

	CONSTRAINT pk_users PRIMARY KEY (id),
	CONSTRAINT uk_users UNIQUE KEY (username),
	CONSTRAINT uk_users_email UNIQUE KEY (email),
	CONSTRAINT fk_users_profile FOREIGN KEY (profile) REFERENCES profiles(id)
);
