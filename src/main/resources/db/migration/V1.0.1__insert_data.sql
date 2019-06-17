
INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(1, 'user1','100001','Account AU','Saving',SYSDATE-20, 'AUD', '300');
INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(11, 1,SYSDATE-19,'AUD',450,null,'Debit', '100010011');
INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(12, 1,SYSDATE-18,'AUD',null,100,'Credit', '100010012');
INSERT INTO TRANSACTION(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number)
VALUES(13, 1,SYSDATE-17,'AUD',null,50,'Credit', '100010013');
INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(2, 'user1','100002','Account US','Current',SYSDATE-19, 'USD', '400');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(3, 'user1','100003','Account IN','Saving',SYSDATE-18, 'IND', '500');


INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(4, 'user2','200001','Account AU','Saving',SYSDATE-17, 'AUD', '500');

INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(5, 'user2','200002','Account IN','Current',SYSDATE-16, 'IND', '900');


INSERT INTO ACCOUNT(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(6, 'user3','300001','Account AU','Saving',SYSDATE-15, 'AUD', '500');


