select DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, "%Y-%m-%d") as hire_ymd
from doctor
where mcdp_cd="CS" or mcdp_cd="gs"
order by hire_ymd desc, dr_name asc;