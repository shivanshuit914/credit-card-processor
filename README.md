# Credit card API

```shell script
# To run tests
./mvnw test

# To run project uses 8085 port
./mvnw spring-boot:run
```

#### API endpoints

```
# add card
POST http://localhost:8085/credit-card
{
  "name":"shianshu",
  "number": "13404354353534544",
  "balance": 0
}

# list cards
GET http://localhost:8085/credit-card
```