#saas-delivery-trackingapp

##Table of contents
- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)

##Features
- User can login and add Customers and Delivery Partners data to the application
- Customers can add Shipment details by adding the source and target locations
- User can assign the shipments created by the customer to the delivery partner
- Delivery partner can update the status of the shipments

##Reuirements
- JDK17
- Maven
##Setup
To get started with the application, follow these steps:

1. **Clone the repository**:

    ```bash
    git clone git@github.com:ManoharBandlamudi17/saas-delivery-trackingapp.git
    ```

2. **Navigate to the project directory**:

    ```bash
    cd your-repo
    ```

3. **Build the project** using Maven

    Maven:

    ```bash
    mvn clean install
    ```
## Running the Application

Once the project is built, you can run the application:

- **Using Maven**:

    ```bash
    mvn spring-boot:run
    ```
The application should now be running on `http://localhost:8081` by default.

## Configuration

You can configure the application by modifying the `application.yml` file in the `src/main/resources` directory. Customize settings such as server port, database connections, and other configurations as needed.

## API Documentation
1. For the user to login
Post Request
localhost:8081/api/user/authenticate/
Request body
{
    "userName" : "test",
    "password" : "test"
}
Response : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

This JWT token is being added in the header of the requests with Authorization as Bearer Token
3. To Add the customer
   POST Request
   localhost:8081/api/customer/addCustomer/
   Request body
   {
    "name": "Jood",
    "password": "test"
  }
  Response

  {
    "id": "1",
    "name": "Jood",
    "password": "test"
  }
5. For the customer to add the shipment details
   POST Request
   localhost:8081/api/customer/addShipmentDetails/
   Request body
   {
    "shipmentName": "Shoes",
    "doorNo": "12-1",
    "street": "avunue street",
    "city": "Hyderabad",
    "state": "Telangana",
    "country": "India",
    "zip": "500001",
    "contactNumber": "5555585585",
    "shipmentStatus": ""   
  }
  Response
      {
    "shipmentId": "1",
    "shipmentName": "Shoes",
    "shipmentStatus": "SHIPMENT_COLLECTED",
    "addressId": "1",
    "doorNo": "12-1",
    "street": "avunue street",
    "city": "Hyderabad",
    "state": "Telangana",
    "country": "India",
    "zip": "500001",
    "contactNumber": "5555585585"
  }
6. To add the delivery partner
   POST Request
     localhost:8081/api/customer/addDeliveryPartner/
   Request body
   {
    "deliveryPartnerName": "XYZ packers and movers",
    "deliveryPartnerContactNumber": "1222321112"
  }
7. To assign the delivery partner
   PUT Request
   localhost:8081/api/customer/assignDeliveryPartner/{ShipmentDetailsId}/{deliveryPartnerId}
   
7.For the delivery partner to see the shipments assigned to him
  GET Reqest
  localhost:8081/api/customer/getShipments/{deliveryPartnerId}
  Response
  {
   [ "shipmentId": "1",
    "shipmentName": "Shoes",
    "shipmentStatus": "SHIPMENT_COLLECTED",
    "addressId": "1",
    "doorNo": "12-1",
    "street": "avunue street",
    "city": "Hyderabad",
    "state": "Telangana",
    "country": "India",
    "zip": "500001",
    "contactNumber": "5555585585"]
  }
8.For the delivery partner to update the status of the shipment
  PUT Request
  localhost:8081/api/customer/updateDeiveryStatus/{shipmentDetailsId}/{status}
  Response 
  {
    "shipmentId": "1",
    "shipmentName": "Shoes",
    "shipmentStatus": "SHIPMENT_COLLECTED",
    "addressId": "1",
    "doorNo": "12-1",
    "street": "avunue street",
    "city": "Hyderabad",
    "state": "Telangana",
    "country": "India",
    "zip": "500001",
    "contactNumber": "5555585585"
  }

The Docker file is provided to create the docker image.
