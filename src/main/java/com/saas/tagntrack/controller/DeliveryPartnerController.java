package com.saas.tagntrack.controller;

import com.saas.tagntrack.dto.DeliveryPartnerDTO;
import com.saas.tagntrack.dto.ShipmentDetailsDTO;
import com.saas.tagntrack.service.DeliveryPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class DeliveryPartnerController {

    @Autowired
    DeliveryPartnerService deliveryPartnerService;

    @GET
    @Path("/getShipments/{deliveryPartnerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShipmentsAssigned(@PathParam("deliveryPartnerId") Long deliveryPartnerId) {
        List<ShipmentDetailsDTO> colShipmentDetailsDTO = deliveryPartnerService.getAllShipmentsAssigned(deliveryPartnerId);
        return Response.ok(colShipmentDetailsDTO).build();
    }

    @PUT
    @Path("/updateDeiveryStatus/{shipmentDetailsId}/{status}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryStatus(@PathParam("shipmentDetailsId") Long shipmentDetailsId,
                                         @PathParam("status") String status) throws Exception {
        ShipmentDetailsDTO shipmentDetailsDTO = deliveryPartnerService.updateShiptmentDeliveryStatus(shipmentDetailsId, status);
        return Response.ok(shipmentDetailsDTO).build();
    }

    @PUT
    @Path("/assignDeliveryPartner/{shipmentDetailsId}/{deliveryPartnerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignDeliveryPartner(@PathParam("shipmentDetailsId") Long shipmentDetailsId,
                                         @PathParam("deliveryPartnerId") Long deliveryPartnerId) throws Exception {
        ShipmentDetailsDTO shipmentDetailsDTO = deliveryPartnerService.assignDeliveryPartnerToShipment(deliveryPartnerId, shipmentDetailsId);
        return Response.ok(shipmentDetailsDTO).build();
    }


    @POST
    @Path("/addDeliveryPartner")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDeliveryPartner(DeliveryPartnerDTO deliveryPartnerDTO) throws Exception {
        deliveryPartnerDTO = deliveryPartnerService.addDeliveryPartner(deliveryPartnerDTO);
        return Response.ok(deliveryPartnerDTO).build();
    }

}
