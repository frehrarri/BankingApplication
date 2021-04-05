CREATE DATABASE user_accounts;

CREATE TABLE account_info(account_id SERIAL, 
	first_name VARCHAR(30), 
	last_name VARCHAR(30),
	email VARCHAR(30) UNIQUE, 
	primary_phone INTEGER UNIQUE,
	bank_id VARCHAR(20) UNIQUE,
	account_balance NUMERIC (11,2),
	PRIMARY KEY (account_id)
);


CREATE TABLE credentials(
	id SERIAL,
	username VARCHAR(15) UNIQUE, 
	userpass VARCHAR(15), 
	acct_ref_id SERIAL,
	PRIMARY KEY (id),
	CONSTRAINT id_fk
		FOREIGN KEY (acct_ref_id)
			REFERENCES account_info(account_id)
);
