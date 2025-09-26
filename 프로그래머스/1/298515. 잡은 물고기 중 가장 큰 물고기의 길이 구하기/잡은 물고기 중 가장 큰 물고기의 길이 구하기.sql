SELECT CONCAT(FORMAT(length, 2), 'cm') AS max_length
FROM fish_info
ORDER BY length DESC LIMIT 1;