select pt_name, pt_no, gend_cd, age, IFNULL(tlno, 'NONE') AS tlno
from patient
where gend_cd='W' and age<=12
order by age desc, pt_name asc;