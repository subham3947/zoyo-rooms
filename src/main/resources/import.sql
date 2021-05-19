insert into hotel(hotel_id, city, hotel_name, star)values (1234,'Ethnotel','Kolkata',3);
insert into hotel(hotel_id, city, hotel_name, star)values (5678,'Hotel Vishal','Hyderabad',4);
insert into hotel(hotel_id, city, hotel_name, star)values (9101,'Skyline','Bengaluru',2);


insert into facility(HOTEL_ID,AC,MEALS,RESTAURANT,WIFI)values (1234,true,true,true,true);
insert into facility(HOTEL_ID,AC,MEALS,RESTAURANT,WIFI)values (5678,true,true,true,true);
insert into facility(HOTEL_ID,AC,MEALS,RESTAURANT,WIFI)values (9101,true,true,false,false);

insert into user(USER_ID,USER_NAME,GENDER,CITY)values (12,'Manas','M','Kolkata');
insert into user(USER_ID,USER_NAME,GENDER,CITY)values (21,'Manasi','F','Chandigarh');

insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (45,1234,9,'Nice rooms. Clean bedsheets.',12);
insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (42,9101,7,'Pathetic rooms. Stale food.',21);
insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (47,5678,5,'Pathetic room service. Smelly rooms.',21);

insert into ROOM(ROOM_ID,AVAILABILITY,CAPACITY,HOTEL_ID,PRICE)values (65, true, 1, 1234, 650);
insert into ROOM(ROOM_ID,AVAILABILITY,CAPACITY,HOTEL_ID,PRICE)values (66, true, 2, 1234, 850);
insert into ROOM(ROOM_ID,AVAILABILITY,CAPACITY,HOTEL_ID,PRICE)values (67, true, 4, 1234, 1250);
insert into ROOM(ROOM_ID,AVAILABILITY,CAPACITY,HOTEL_ID,PRICE)values (68, true, 1, 9101, 600);