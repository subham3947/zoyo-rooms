insert into hotel(hotel_id, hotel_name,city, star)values (1234,'Ethnotel','Kolkata',3);
insert into hotel(hotel_id, hotel_name,city, star)values (5678,'Hotel Vishal','Hyderabad',4);
insert into hotel(hotel_id, hotel_name,city, star)values (9101,'Skyline','Bengaluru',2);


insert into facility(HOTEL_ID,AC,MEALS,RESTAURANT,WIFI)values (1234,true,true,true,true);
insert into facility(HOTEL_ID,AC,MEALS,RESTAURANT,WIFI)values (5678,true,true,true,true);
insert into facility(HOTEL_ID,AC,MEALS,RESTAURANT,WIFI)values (9101,true,true,false,false);

insert into user(USER_ID,USER_NAME,GENDER,CITY)values (12,'Manas','M','Kolkata');
insert into user(USER_ID,USER_NAME,GENDER,CITY)values (21,'Manasi','F','Chandigarh');
insert into user(USER_ID,USER_NAME,GENDER,CITY)values (34,'Saaba','F','Delhi');
insert into user(USER_ID,USER_NAME,GENDER,CITY)values (19,'Manoj','M','Bhopal');
insert into user(USER_ID,USER_NAME,GENDER,CITY)values (43,'Prateek','M','Rishikesh');

insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (45,1234,9,'Nice rooms. Clean bedsheets.',12);
insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (43,1234,8,'Ok rooms. Average room service.',34);
insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (44,1234,8,'Spacious rooms but reception takes time.',19);
insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (42,9101,7,'Pathetic rooms. Stale food.',21);
insert into REVIEW(REVIEW_ID,HOTEL_ID,RATING,REVIEW,USER_ID)values (47,5678,5,'Pathetic room service. Smelly rooms.',21);

insert into ROOM(ROOM_ID,CAPACITY,HOTEL_ID,PRICE)values (65,  1, 1234, 650);
insert into ROOM(ROOM_ID,CAPACITY,HOTEL_ID,PRICE)values (66,  2, 1234, 850);
insert into ROOM(ROOM_ID,CAPACITY,HOTEL_ID,PRICE)values (67,  4, 1234, 1250);
insert into ROOM(ROOM_ID,CAPACITY,HOTEL_ID,PRICE)values (68,  1, 9101, 600);
insert into ROOM(ROOM_ID,CAPACITY,HOTEL_ID,PRICE)values (69,  2, 5678, 600);

insert into RESERVATION(RESERVATION_ID,HOTEL_ID,CHECK_IN,CHECK_OUT,ROOM_ID,USER_ID)values (5634,1234,'2021-05-12','2021-05-14',65,34);
insert into RESERVATION(RESERVATION_ID,HOTEL_ID,CHECK_IN,CHECK_OUT,ROOM_ID,USER_ID)values (5635,5678,'2021-05-12','2021-05-15',69,19);
insert into RESERVATION(RESERVATION_ID,HOTEL_ID,CHECK_IN,CHECK_OUT,ROOM_ID,USER_ID)values (5636,1234,'2099-05-16','2099-05-18',66,12);
insert into RESERVATION(RESERVATION_ID,HOTEL_ID,CHECK_IN,CHECK_OUT,ROOM_ID,USER_ID)values (5637,1234,'2099-05-10','2099-05-16',67,21);
insert into RESERVATION(RESERVATION_ID,HOTEL_ID,CHECK_IN,CHECK_OUT,ROOM_ID,USER_ID)values (5638,9101,'2021-05-12','2021-05-14',68,43);
