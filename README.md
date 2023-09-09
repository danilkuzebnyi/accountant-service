# Accountant service

## Description
This project is written in Java.</br>
The purpose of this application is to calculate efficiently fees for particular services(transactions) provided
to the client.

Each ***transaction*** represents an interaction between the client and the accountant. Transaction has its own type.</br>
Each ***fee*** is a service that the accountant can provide to clients. Fee has the name of the service and the amount
(the sum that the client pays for this service).</br>
The client can order both 1 service and several services. So 1 transaction has 1 or more fees.</br>
The amount that the client has to pay to the accountant is the sum of all fees 
that the client has ordered from the accountant.
Also, this total fee can be changed depending on the type of transaction.

The calculation algorithm differs depending on the type of transaction.</br>

**There are 3 types of calculation algorithms:**
1. [AdditionCalculationAlgorithm](/src/main/java/com/example/accountant/utils/AdditionCalculationAlgorithm.java) - 
add specific amount to total amount (is used for home visits).
2. [MultiplicationCalculationAlgorithm](/src/main/java/com/example/accountant/utils/MultiplicationCalculationAlgorithm.java) - 
multiplies the total amount by the specified commission (is used for off hours of the accountant).
3. [ThirdFeeFreeCalculationAlgorithm](/src/main/java/com/example/accountant/utils/ThirdFeeFreeCalculationAlgorithm.java) - 
type of discount. When the client ordered 3 fees or more, the fee with the minimum amount will be free.
   
*All the main methods of the application are covered with tests
that confirm the correct operation of the functionality.*