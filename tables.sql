CREATE DATABASE pharmacy_management;

USE pharmacy_management;

CREATE TABLE delivery_men (username varchar(256), email varchar(256), mobile_number varchar(20), address varchar(256), aadhar_number varchar(256), added_by varchar(256), pharmacy_name varchar(256));

CREATE TABLE invoices (id int, username  varchar(256), pharm_name  varchar(256), branch int, amount  varchar(15), quantity  varchar(20), invoice_date date);

CREATE TABLE managers ( username varchar(256), email varchar(256), branch_id int, address varchar(256), pharmacy_name varchar(256));

CREATE TABLE medicines (username  varchar(256), mid  varchar(15), mname  varchar(256), mcompany  varchar(256), quantity  int default 0, expiry_date date, med_mrp varchar(15), med_rate varchar(15), status int default 0, med_added_date TIMESTAMP  default CURRENT_TIMESTAMP, added_by varchar(256));

CREATE TABLE pharmacists (username varchar(256), email varchar(256), mobile_number varchar(256), pharmacy_name varchar(256),address varchar(256), aadhar_number varchar(256), added_by varchar(256));

CREATE TABLE reports (id int, username varchar(256), pharmacy_name varchar(256), report_title varchar(256), report_subject varchar(256), report_desc varchar(256), reported_date date);

CREATE TABLE users (username varchar(256), password varchar(256), status int default 1, role int, role_desc varchar(256), last_accessed int default 1, email varchar(256), pharmacy_name varchar(256), branch_id int, mobile_number varchar(20), have_access_to varchar(256), subscription_pack varchar(256) default 'none', date_of_subscription date);

CREATE TABLE approved_items (mid varchar(256), username varchar(256), medname varchar(256), quantity int, price varchar(256), pharmacy_name varchar(256), delivery_man varchar(256) default 'NOT_ALLOCATED', is_delivered int default 0);

CREATE TABLE cartitems (mid varchar(256), username varchar(256), medname varchar(256), quantity int, price int, pharm_name varchar(256), is_ordered int default 0);

TRUNCATE approved_items;
TRUNCATE cartitems;
TRUNCATE delivery_men;
TRUNCATE invoices;
TRUNCATE managers;
TRUNCATE medicines;
TRUNCATE pharmacists;
TRUNCATE reports;
TRUNCATE users;

drop table approved_items;
drop table cartitems;
drop table delivery_men;
drop table invoices;
drop table managers;
drop table medicines;
drop table pharmacists;
drop table reports;
drop table users;
