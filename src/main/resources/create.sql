
DROP TABLE IF EXISTS PUBLIC."CUSTOMER_TBL" ;
DROP TABLE IF EXISTS PUBLIC."CUSTOMER_INFO_TBL" ;

CREATE TABLE PUBLIC."CUSTOMER_TBL" (
	GUID VARCHAR(100) NOT NULL,
	NAME VARCHAR(100) NOT NULL,
	AGE INTEGER NOT NULL,
	PRIMARY KEY(GUID)
);

CREATE TABLE PUBLIC."CUSTOMER_INFO_TBL" (
	CUSTOMER_ID VARCHAR(100) NOT NULL,
	KEY VARCHAR(100) NOT NULL,
	VAL VARCHAR(100) NOT NULL
);

ALTER TABLE PUBLIC."CUSTOMER_INFO_TBL"  ADD PRIMARY KEY (CUSTOMER_ID, KEY);

INSERT INTO PUBLIC."CUSTOMER_TBL"
(GUID, NAME, AGE)
VALUES('any_guid', 'alex', '26');

INSERT INTO PUBLIC."CUSTOMER_INFO_TBL"
(CUSTOMER_ID, KEY, VAL)
VALUES('any_guid', 'COUNTRY', 'PH');
INSERT INTO PUBLIC."CUSTOMER_INFO_TBL"
(CUSTOMER_ID, KEY, VAL)
VALUES('any_guid', 'CITY', 'MANILA');