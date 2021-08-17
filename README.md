# OnlinePaymentsApp

## Get Started

1. Download using ```git pull https://github.com/Pratyush-15/OnlinePaymentsApp.git```
2. Install postgreSQL 9 and pgAdmin 4
3. Create new postgreSQL database using pgAdmin 
4. Update ```BankService/src/main/resources/application.properties``` file
5. Resolve Maven dependencies in ```DiscoveryServer```, ```BankService```, ```WalletService``` and ```TransactionService```.
6. Run all four microservices in the same order.
7. In order to access API endpoints, go to ```http://localhost:<port>/swagger-ui.html```

## Micro Services

### BankService

This service is the entry point to new customers. 

Create customer account and add a bank account in order to get access to wallet and transactions.

### WalletService

This service gives access to transactions and bill payments.

### TransactionService

This service keeps a log of all transactions performed.
