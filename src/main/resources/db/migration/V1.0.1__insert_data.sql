
INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(1, 'anz-test-user','100001','Account AU','Saving',SYSDATE-20, 'AUD', '300');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(2, 'anz-test-user','100002','Account US','Current',SYSDATE-19, 'USD', '400');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(3, 'anz-test-user','100003','Account IN','Saving',SYSDATE-18, 'IND', '500');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(4, 'anz-test-user','100004','Account AU','Saving',SYSDATE-20, 'AUD', '300');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(5, 'anz-test-user','100005','Account US','Current',SYSDATE-19, 'USD', '400');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(6, 'anz-test-user','100006','Account IN','Saving',SYSDATE-18, 'IND', '500');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(7, 'anz-test-user','100007','Account AU','Saving',SYSDATE-20, 'AUD', '300');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(8, 'anz-test-user','100008','Account US','Current',SYSDATE-19, 'USD', '400');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(9, 'anz-test-user','100009','Account IN','Saving',SYSDATE-18, 'IND', '500');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(10, 'anz-test-user','100010','Account AU','Saving',SYSDATE-20, 'AUD', '300');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(11, 'anz-test-user','100011','Account US','Current',SYSDATE-19, 'USD', '400');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(12, 'anz-test-user','100012','Account IN','Saving',SYSDATE-18, 'IND', '500');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(13, 'anz-test-user','100013','Account AU','Saving',SYSDATE-20, 'AUD', '300');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(14, 'anz-test-user','100014','Account US','Current',SYSDATE-19, 'USD', '400');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(15, 'anz-test-user','100015','Account IN','Saving',SYSDATE-18, 'IND', '500');


INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(1, 1,SYSDATE-19,'AUD',450,null,'Debit', '10001001');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(2, 1,SYSDATE-18,'AUD',null,100,'Credit', '10001002');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(3, 1,SYSDATE-17,'AUD',null,50,'Credit', '10001003');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(4, 1,SYSDATE-19,'AUD',450,null,'Debit', '10001004');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(5, 1,SYSDATE-18,'AUD',null,100,'Credit', '10001005');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(6, 1,SYSDATE-17,'AUD',null,50,'Credit', '10001006');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(7, 1,SYSDATE-19,'AUD',450,null,'Debit', '10001007');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(8, 1,SYSDATE-18,'AUD',null,100,'Credit', '10001008');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(9, 1,SYSDATE-17,'AUD',null,50,'Credit', '10001009');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(10, 1,SYSDATE-19,'AUD',450,null,'Debit', '10001010');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(11, 1,SYSDATE-18,'AUD',null,100,'Credit', '10001011');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(12, 1,SYSDATE-17,'AUD',null,50,'Credit', '10001012');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(13, 1,SYSDATE-19,'AUD',450,null,'Debit', '10001013');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(14, 1,SYSDATE-18,'AUD',null,100,'Credit', '10001014');

INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(15, 1,SYSDATE-17,'AUD',null,50,'Credit', '10001015');