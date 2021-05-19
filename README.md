# Zoyo Rooms

## About
    This project serves the purpose of hosting a Hotel room booking site.

    Each Hotel has a different types of rooms with different capacity. 
    This application helps user to search hotels by city, dates, and facilities like WIFI, restaurant available,
    air conditioning, meals included etc.    

## Built With
    The project has been developed in SpringBoot using Maven as the build tool.

## Getting Started
    1. Clone the project in the local repository by using the below command.
        git clone git@github.com:subham3947/zoyo-rooms.git
    2. The application can be started in two ways:-
        a.) Run the ZoyoRoomsApplication.java file.
        b.) Open the terminal and execute the below command
            java -jar <path_to_the_jar_file>   for instance, java -jar /target/zoyo-rooms-0.0.1-SNAPSHOT.jar 

## Database
    1. This application uses an in-memory H2 database for simplicity.
    2. Everytime the server starts the tables are initialized with some data.
    3. If needed, please add insert queries in Import.sql file under /resources folder.

## REST API Url Endpoints with tasks
    With the correct request to the API endpoint a user gets a response for the following tasks:-
    
    Get List of all Hotels (GET): http://localhost:8080/zoyorooms/getAllHotels
    Add a Hotel to the database (POST): http://localhost:8080/zoyorooms/add/hotel
    Update a Hotel information (PUT):http://localhost:8080/zoyorooms/update/hotel/{hotelId}
    Delete a Hotel information (PUT):http://localhost:8080/zoyorooms/delete/hotel/{hotelId}
    Show reviews for a Hotel (GET): http://localhost:8080/zoyorooms/showReviews/{hotelId}?city=Hyderabad?rating=9?gender=M
    Add a User to the database (POST): http://localhost:8080/zoyorooms/add/user
    Update a User information (PUT):http://localhost:8080/zoyorooms/update/user/{userId}
    Delete a User information (PUT):http://localhost:8080/zoyorooms/delete/user/{userId}
    Add a Review to the database (POST): http://localhost:8080/zoyorooms/add/review
    Delete a Review information (PUT):http://localhost:8080/zoyorooms/delete/review/{reviewId}
    
    Few points to remember:-
    1. Variables enclosed by {} represent the value to be provided within {}.e.g.,http://localhost:8080/zoyorooms/update/hotel/1234
    2. All POST and PUT request must also comprise the RequestBody(use POSTman).
    3. Variables separated by ? are optional filters and can be skipped.
    
    
    
    
    
    
## Assumptions
    - A deletion of a Hotel will result into deletion of all its rooms, reviews, and facilities.
    - A deletion of a User will result into deletion of all reviews provided by the user.
