# Doctor-Booking


Doctor-Booking using java Spring boot
## Framework

 - Java Spring Boot 
 - JPA
 - H2
 - Hibernate
 - lombok


## API Reference

#### Get all items

```http
  GET /api/v1/doctor/get
```
#### Add Doctors
```http
  POST /api/v1/doctor/add
```


##Sample JSON

{
    "id":1,
   "name": "Alex",
        "specs": "heart specialist",
        "exp": "3"
}


#### Delete Doctors

```http
  Delete /api/v1/doctor/delete
```


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  To Delete Doctor|


## Authors

- [@Yogesh](https://github.com/Yogesh-VasanthaKumar/)


