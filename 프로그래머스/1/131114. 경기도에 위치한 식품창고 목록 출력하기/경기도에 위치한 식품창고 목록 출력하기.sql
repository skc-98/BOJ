select warehouse_id, warehouse_name, address, COALESCE(freezer_yn, 'N') as freezer_n
from food_warehouse 
where address like '경기도%'
order by warehouse_id asc;