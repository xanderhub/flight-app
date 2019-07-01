# flight-app
Flights Application Assignment


## Run the app locally:

```
./mvnw spring-boot:run
```


## GET request example:
```
localhost:8080/api/tickets?ticketId=100
```
```
localhost:8080/api/coupons?couponId=123456789&price=100
```
### Response example:
```
{
    "price": 50,
    "msg": "Coupon is valid"
}
```
```
{
    "price": 100,
    "msg": "Coupon is not valid!"
}
```

## Description
The app uses H2 in-memory database as data source.
`FlightAppBootstrap` class populates the tables `tickets` and `coupons` at application start up

For each table there is a coresponding CRUD repository defined as spring-data jpa repository:
`CheckInRepository`, `CouponRepository`, `TicketRepository`

All these repositories are being injected into `FlightService` as dependencies.

Finally there is a controller class `FlightController` which encapsulates the `FlightService`
