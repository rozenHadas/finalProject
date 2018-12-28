
CREATE TABLE agency
(agency_id		INTEGER PRIMARY KEY NOT NULL,
agency_name		VARCHAR NOT NULL,
agency_url		VARCHAR);

CREATE TABLE routes
(route_id		INTEGER NOT NULL,
agency_id		VARCHAR,
route_long_name	VARCHAR,
route_desc		VARCHAR,
route_type		INTEGER,
route_color		INTEGER,
PRIMARY KEY (route_id, route_type));

/*
CREATE TABLE calendar
(service_id		INTEGER PRIMARY KEY,
date_bytes		INTEGER,
short_date		DATE,
end_date		DATE);

CREATE TABLE shape
(shape_id 		INTEGER PRIMARY KEY,
shape_pt_lat_lon	POINT,
shape_dist_traveled	NUMERIC);

CREATE TABLE trips
(trip_id		VARCHAR PRIMARY KEY,
route_id		INTEGER NOT NULL,
service_id		INTEGER NOT NULL,
direction_id	INTEGER,
shape_id		INTEGER,
FOREIGN KEY (route_id) REFERENCES routes (route_id),
FOREIGN KEY (service_id) REFERENCES calendar (service_id),
FOREIGN KEY (shape_id) REFERENCES shape (shape_id));

CREATE TABLE stop
(stop_id		INTEGER PRIMARY KEY,
stop_code		INTEGER,
stop_name		VARCHAR,
stop_desc		VARCHAR,
stop_lat_lon	POINT,
location_type	SMALLINT,
parent_station	INTEGER,
FOREIGN KEY (parent_station) REFERENCES stop (stop_id));

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