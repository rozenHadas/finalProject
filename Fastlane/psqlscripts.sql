/*
CREATE TABLE agency
(agency_id		INTEGER PRIMARY KEY NOT NULL,
agency_name		VARCHAR NOT NULL,
agency_url		VARCHAR);

CREATE TABLE routes
(route_id		INTEGER PRIMARY KEY NOT NULL,
agency_id		INTEGER,
route_long_name	VARCHAR,
route_desc		VARCHAR,
route_type		VARCHAR,
route_color		INTEGER,
FOREIGN KEY (agency_id) REFERENCES agency (agency_id));


CREATE TABLE calendar
(service_id		INTEGER PRIMARY KEY,
date_bytes		BIT(7),
start_date		DATE,
end_date		DATE);

CREATE TABLE shape
(shape_id 		INTEGER,
shape_pt_lat	DECIMAL,
shape_pt_lot	DECIMAL,
shape_pt_sequence INTEGER,
PRIMARY KEY (shape_id,shape_pt_sequence)
);


CREATE TABLE trips
(route_id		INTEGER NOT NULL,
service_id		INTEGER NOT NULL,
trip_id		VARCHAR PRIMARY KEY,
direction_id	BIT(1),
shape_id		INTEGER,
UNIQUE(shape_id),
FOREIGN KEY (route_id) REFERENCES routes (route_id),
FOREIGN KEY (service_id) REFERENCES calendar (service_id));
*/
/*FOREIGN KEY (shape_id) REFERENCES shape (shape_id));*/


CREATE TABLE stop
(stop_id		INTEGER PRIMARY KEY,
stop_code		INTEGER,
stop_name		VARCHAR,
stop_desc		VARCHAR,
stop_lat		DECIMAL,
stop_lot		DECIMAL,
location_type	SMALLINT,
parent_station	INTEGER NULL,
FOREIGN KEY (parent_station) REFERENCES stop (stop_id));

/*
CREATE TABLE stop_times
(trip_id		VARCHAR,
arrival_time	VARCHAR,
departure_time	TIME,
stop_id			INTEGER, 
stop_sequence	VARCHAR,
pickup_types	SMALLINT,
drop_off_type	SMALLINT,
shape_dist_traveled	NUMERIC,
PRIMARY KEY (trip_id, stop_id, arrival_time),
FOREIGN KEY (trip_id) REFERENCES trips (trip_id),
FOREIGN KEY (stop_id) REFERENCES stop (stop_id));




 


*/