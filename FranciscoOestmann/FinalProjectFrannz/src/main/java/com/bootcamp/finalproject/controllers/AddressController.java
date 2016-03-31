package com.bootcamp.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.finalproject.entities.Address;
import com.bootcamp.finalproject.entities.User;
import com.bootcamp.finalproject.repositories.AddressRepository;
import com.bootcamp.finalproject.repositories.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
@Api(value = "User Addresses")
public class AddressController {
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	UserRepository userRepo;
	
	User user;
	
	Address address;
	
	

	/**
	 * Sets Addresses for a given user.
	 * 
	 * @param addressType
	 * @param userName
	 * @param street
	 * @param number
	 * @param city
	 * @param country
	 *@param postalCode
	 */
	@ApiOperation(value = "Adds an Address",response = List.class, notes = "Add Address for a given user.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Adrress added..", response=String.class),
		@ApiResponse(code = 400, message = "Failed to add address.", response=String.class)
	})
	@RequestMapping(value = "/addaddress", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addAddresses(
			@RequestParam(value="Username") String userName,
			@RequestParam(value="Address Type") String addressType,
			@RequestParam(value="Street") String street,
			@RequestParam(value="Number") int number,
			@RequestParam(value="City") String city,
			@RequestParam(value="Country") String country,
			@RequestParam(value="Postal Code") int postalCode
			){
		user = userRepo.findByUserName(userName);
		address = new Address(user, addressType, street, number, city, country, postalCode);
		addressRepo.save(address);
	
	}
	
	
	/**
	 *
	 */
	@ApiOperation(value = "Removes an Address", notes = "Removes an Address from the repository. It takes the Username to identify the correct Address to be deleted.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Address removed.", response=String.class),
		@ApiResponse(code = 400, message = "Address not found.", response=String.class)
	})
	@RequestMapping(method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void removeAddress(
			@RequestParam(value="Username") String userName,
			@RequestParam(value="Address Type") String addressType
			){
		
		addressRepo.delete(addressRepo.findByUserAndAddressType(user, addressType));

	}
	
	@ApiOperation(value = "Shows a list of Addresses.", notes = "Shows a list of Addresses for a given user.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Address removed.", response=String.class),
		@ApiResponse(code = 400, message = "Address not found.", response=String.class)
	})
	@RequestMapping(value = "/showaddresslist", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Address> showAddressList(
			@RequestParam(value="Username") String userName){
		
		user = userRepo.findByUserName(userName);
		
		return addressRepo.findByUser(user);

	}
}
