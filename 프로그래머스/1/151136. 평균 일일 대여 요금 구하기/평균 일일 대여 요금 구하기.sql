select round(avg(DAILY_FEE),0) as average_fee
from car_rental_company_car
where car_type='SUV';