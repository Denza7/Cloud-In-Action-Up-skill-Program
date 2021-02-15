# Cloud-In-Action-Up-skill-Program
Endpoints:
| Method | Url   | Description | Input parameters|
| :---: | :---: | :---: | :---: |
| GET  | http://ec2-18-225-28-87.us-east-2.compute.amazonaws.com:8761/ | Discovery service UI | - |
|  |  |  ||
| POST  | http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/login | Obtaining a token for further access to services. Еhe token is added to the Header called "Authorization".|"username": "test","password": "test" |
| GET  | http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/currency-converter/from/UAH/to/EUR/quantity/100 | Currency conversion | USD - INR, UAH - EUR, UAH - USD, USD - INR |
| GET |http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/currency-exchange-service/actuator/health| Health check for currency-exchange-service | - |
| GET |http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/currency-exchange-api-gateway-service/health| Health check for exchange-api-gateway-service | - |
| GET |http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/currency-conversion-service/actuator/health| Health check for currency-conversion-service | - |
| GET |http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/exchange-authentication-service/actuator/health| Health check for exchange-authentication-service | - |
| GET |http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/currency-exchange-service/swagger-ui.html| API Documentation for currency-exchange-service| - |
| GET |http://ec2-3-136-26-96.us-east-2.compute.amazonaws.com:8765/currency-conversion-service/swagger-ui.html| API Documentation for currency-exchange-service| - |
