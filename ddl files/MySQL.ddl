-- Generated by Oracle SQL Developer Data Modeler 18.1.0.082.1035
--   at:        2018-05-27 17:49:34 EEST
--   site:      Oracle Database 12c
--   type:      Oracle Database 12c



CREATE TABLE car (
    car_id                  VARCHAR(5) NOT NULL,
    car_type                VARCHAR(10),
    seats                   INTEGER(11),
    doors                   INTEGER(11),
    conv   				    VARCHAR(5),
    fuel_type               VARCHAR(10),
    price                	DOUBLE,
    shop_id             	VARCHAR(10),
    rnt 					INTEGER(11)
);

ALTER TABLE car ADD CONSTRAINT car_pk PRIMARY KEY ( car_id );

CREATE TABLE customer (
    lisence_id   		  VARCHAR(5) NOT NULL,
    first_name            VARCHAR(50),
    last_name             VARCHAR(50),
    email                 VARCHAR(50),
    home_phone        	  VARCHAR(50),
    mobile_phone          VARCHAR(50)
);

ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( lisence_id );

CREATE TABLE rent (
    rent_id                       INTEGER(11) NOT NULL,
    pickup_place                  VARCHAR(50),
    pickup_date_time              VARCHAR(50),
    return_place                  VARCHAR(50),
    return_date_time              VARCHAR(50),
    car_id                        VARCHAR(5),
    customer_id                   VARCHAR(5)    
);

ALTER TABLE rent_data ADD CONSTRAINT rent_data_pk PRIMARY KEY ( rent_id );

CREATE TABLE shop (
    shop_id   VARCHAR(5) NOT NULL,
    town      VARCHAR(50)
);

ALTER TABLE shop ADD CONSTRAINT shop_pk PRIMARY KEY ( shop_id );


-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0