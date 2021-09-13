SELECT balance FROM accounts JOIN users ON accounts.user_id = users.user_id WHERE username = 'user';

SELECT * FROM users;

SELECT transfer_type_id, transfer_type_desc FROM transfer_types WHERE transfer_type_desc = 'Send';

SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?

SELECT * FROM user_accounts;

UPDATE accounts SET balance = 5 WHERE account_id = 2001;


SELECT account_id, user_id, balance FROM accounts WHERE account_id = 1001;

SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount
FROM transfers
JOIN accounts ON accounts.account_id = transfers.account_from OR accounts.account_id = transfers.account_to
WHERE user_id = 1004;

