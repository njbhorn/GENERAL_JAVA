package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.github.cliftonlabs.json_simple.JsonArray;
//import com.github.cliftonlabs.json_simple.JsonException;
//import com.github.cliftonlabs.json_simple.JsonObject;
//import com.github.cliftonlabs.json_simple.Jsoner;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerController {

	JsonArray customerList;
	JsonArray orderList;
	JsonArray orderDetailList;

	private JsonArray getCustomerInfo() throws FileNotFoundException, IOException, JsonException {

		JsonArray customerList;

		try (FileReader reader = new FileReader("src\\main\\resources\\customers.json")) {
			Object obj = Jsoner.deserializeMany(reader);
			customerList = (JsonArray) obj;
		}
		return (JsonArray) customerList.get(0);
	}

	private JsonArray getOrderInfo() throws FileNotFoundException, IOException, JsonException {

		JsonArray orderList;

		try (FileReader reader = new FileReader("src\\main\\resources\\orders.json")) {
			// Read JSON file
			Object obj = Jsoner.deserializeMany(reader);

			orderList = (JsonArray) obj;
			System.out.println(orderList);

			// Iterate over employee array
//            orderList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

		}
		return (JsonArray) orderList.get(0);

	}

	private JsonArray getOrderDetailInfo(BigDecimal id) throws JsonException, FileNotFoundException, IOException {

		JsonArray orderDetailList;
		JsonArray orderDetailListForOrderId = new JsonArray();

		try (FileReader reader = new FileReader("src\\main\\resources\\orderDetails.json")) {
			// Read JSON file
			Object obj = Jsoner.deserializeMany(reader);

			orderDetailList = (JsonArray) ((JsonArray) obj).get(0);
			System.out.println(orderDetailList);

			orderDetailList.forEach(ord -> {
				JsonObject orderDetail = (JsonObject) ord;
				BigDecimal orderId = (BigDecimal) orderDetail.get("OrderID");
				System.out.println("OrderId = " + orderId + ", id = " + id);
				if (orderId.equals(id)) {
					// add to list
					orderDetailListForOrderId.add(ord);
				}

			});
		}
		return orderDetailListForOrderId;

	}

	private JsonObject getCustomerById(String id) throws FileNotFoundException, IOException, JsonException {

		JsonObject customer = null;
		String custId;

		if (customerList == null) {
			customerList = getCustomerInfo();
		}

		for (Object obj : customerList) {
			customer = (JsonObject) obj;

			custId = (String) customer.get("CustomerID");
			System.out.println("Here..." + customer + " id " + id + " id " + custId);
			if (custId.equals(id)) {
				// add to list
				break;
			}
		}

		return customer;
	}

	private JsonArray getOrdersByCustId(String id) throws FileNotFoundException, IOException, JsonException {

		JsonArray customerOrderList = new JsonArray();

		if (orderList == null) {
			orderList = (JsonArray) getOrderInfo();
		}

		// Iterate over order array
		orderList.forEach(ord -> {
			JsonObject order = (JsonObject) ord;
			String custId = (String) order.get("CustomerID");
			if (custId.equals(id)) {
				// add to list
				customerOrderList.add(ord);
			}

		});

		return customerOrderList;
	}

//	/getcustomerbycustomerid/ 2
//	/getcustomers 1
//	/getorders 3
//	/getordersbycustomerid/ 5
//	/getorderdetailsbyorderid 4
	
	@RequestMapping("/")
	public String index() {
		return "/getcustomers/<br>/getcustomers/custId<br>/getorders<br>/getorderdetails/id<br>/getorders/custId";
	}
	


	@RequestMapping("/getcustomers/{custId}")
//	@ResponseBody
	public JsonObject getcustomerbycustomerid(@PathVariable String custId) throws FileNotFoundException, IOException, JsonException {
		return this.getCustomerById(custId);
	}

	@RequestMapping("/getcustomers")
	public JsonArray getcustomers() throws FileNotFoundException, IOException, JsonException {
		System.out.println(this.getCustomerInfo());
		return this.getCustomerInfo();
	}

	@RequestMapping("/getorders/{custId}")
	public JsonArray getordersbycustomerid(@PathVariable String custId)
			throws FileNotFoundException, IOException, JsonException {
		return this.getOrdersByCustId(custId);
	}

	@RequestMapping("/getorders")
	public JsonArray getorders() throws FileNotFoundException, IOException, JsonException {
		return this.getOrderInfo();
	}

	@RequestMapping("/getorderdetails/{orderId}")
	public JsonArray getorderdetailsbyorderid(@PathVariable BigDecimal orderId) throws FileNotFoundException, JsonException, IOException {
		return this.getOrderDetailInfo(orderId);
	}

}
