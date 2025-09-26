select count(user_id) as user from user_info
where joined like "2021%" and age >= 20 && age <=29;
