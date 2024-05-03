package com.saas.tagntrack.controller;

import com.saas.tagntrack.dto.CustomerDTO;
import com.saas.tagntrack.dto.ShipmentDetailsDTO;
import com.saas.tagntrack.service.CustomerService;
import com.saas.tagntrack.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ShipmentService shipmentService;

    @POST
    @Path("/addCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerDTO customerDTO){
        customerDTO = customerService.addCustomer(customerDTO);
        return Response.status(Response.Status.CREATED)
                .entity(customerDTO)
                .build();
    }

    @POST
    @Path("/addShipmentDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addShipmentDetails(ShipmentDetailsDTO shipmentDetailsDTO) {
        shipmentDetailsDTO = shipmentService.addNewShipmentDetails(shipmentDetailsDTO);
        return Response.ok(shipmentDetailsDTO).build();
    }
}
