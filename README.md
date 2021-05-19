# Zoyo Rooms

## About
    This project serves the purpose of hosting a Hotel room booking site.

    Each Hotel has a different types of rooms with different capacity. 
    This application helps user to search hotels by city, dates, and facilities like WIFI, restaurant available,
    air conditioning, meals included etc.    

## Built With
    The project has been developed in SpringBoot using Maven as the build tool.

## Getting Started
    Clone the project in the local repository by using the below command.
        git clone git@gitlab.crio.do:cohort_oops_racing_cars_may2021/subhamyadav2700-racing-car.git

## REST API Url Endpoints with tasks
    With the correct request to the API endpoint a user gets a response for the following tasks:-
    ## Get List of all Hotels (GET)##: http://localhost:8080/zoyorooms/getAllHotels
    Add a Hotel to the database (POST): http://localhost:8080/zoyorooms/add/hotel
    Update a Hotel information (PUT):http://localhost:8080/zoyorooms/update/hotel/{hotelId}
    Delete a Hotel information (PUT):http://localhost:8080/zoyorooms/delete/hotel/{hotelId}
    Show reviews for a Hotel (GET): http://localhost:8080/zoyorooms/showReviews/{hotelId}
    Add a User to the database (POST): http://localhost:8080/zoyorooms/add/user
    
    
    
    
    
## Assumptions
    - A Car is unique to a particular team.
    - A Car has a unique Part List.
