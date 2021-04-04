CREATE DATABASE user_accounts;

CREATE TABLE account_info(account_id SERIAL, first_name VARCHAR(30), last_name VARCHAR(30),
	email VARCHAR(30), primary_phone INTEGER
);

ALTER TABLE account_info ADD COLUMN account_balance NUMERIC (11,2);

ALTER TABLE account_info PRIMARY KEY (account_id);

CREATE TABLE credentials(
	id SERIAL,
	username VARCHAR(15), 
	userpass VARCHAR(15), 
	acct_ref_id SERIAL,
	PRIMARY KEY (id),
	CONSTRAINT id_fk
		FOREIGN KEY (acct_ref_id)
			REFERENCES account_info(account_id)
);

ALTER TABLE account_info ADD COLUMN bank_id VARCHAR(20);

ALTER TABLE account_info DROP CONSTRAINT account_id;

DROP DATABASE user_accounts;