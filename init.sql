---- Create the parkingmeter database
CREATE DATABASE parkingmeter;

-- Connect to the parkingmeter database
\c parkingmeter;
CREATE TABLE IF NOT EXISTS tb_driver(
     id BIGSERIAL primary key,
     name VARCHAR(255) not null,
     document VARCHAR(255),
     birth_date date not null,
     mail VARCHAR(255),
     phone VARCHAR(15),
     payment_form VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS tb_vehicle(
     id BIGSERIAL primary key,
     model VARCHAR(255),
     license_plate VARCHAR(20) not null,
     year INT,
     is_parked_per_hour BOOLEAN,
     driver_id BIGINT not null,
     CONSTRAINT fk_vehicle_driver foreign key (driver_id) references tb_driver(id)
);

CREATE TABLE IF NOT EXISTS tb_parking(
   id BIGSERIAL primary key,
   entry_time TIMESTAMP,
   exit_time TIMESTAMP,
   next_notification_date TIMESTAMP,
   value NUMERIC(10, 2),
   parking_type VARCHAR(50) not null,
   vehicle_id BIGINT,
   CONSTRAINT fk_vehicle_id foreign key (vehicle_id) references tb_vehicle(id)
);