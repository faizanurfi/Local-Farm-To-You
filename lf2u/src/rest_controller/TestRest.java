package rest_controller;

import static org.junit.Assert.*;
import javax.ws.rs.core.*;

import org.junit.Test;

import com.google.gson.GsonBuilder;

import org.junit.Before;

public class TestRest {

	REST_controller rc = new REST_controller();
	
	//farmer tests started
	
	@Test
	public void test1() {
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.createFarmerAccountPOST(json);
		assertEquals(json, r);
	}
	
	@Test
	public void test2(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.updateFarmerAccountPOST(123, json);
		assertEquals(json, r);
	}
	
	@Test
	public void test3(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewAllFarmerAccountsGET();
		assertEquals(json, r);
	}
	
	@Test
	public void test4(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewFarmersByZipGET("60010");
		assertEquals(json, r);
	}
	
	@Test
	public void test5(){
		Response r = rc.viewFarmerProductsGET(123);
	}
	
	@Test
	public void test6(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.postProductToFarmStore(123, json);
		assertEquals(json, r);
	}
	
	@Test
	public void test7(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.modifyStoreProduct(123, 345, json);
		assertEquals(json, r);
	}
	
	@Test
	public void test8(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.getFarmStoreProductDetails(123, 345);
		assertEquals(json, r);
	}
	
	@Test
	public void test9(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.getAllFarmerReports(123);
		assertEquals(json, r);
	}
	
	@Test
	public void test10(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.getFarmerReport(127, 701);
		assertEquals(json, r);
	}
	
	@Test
	public void test11(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.getFarmerReportWithSDED(127, 703, "20161019", "20161019");
		assertEquals(json, r);
	}
	
	@Test
	public void test12(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.getDeliveryCharge(123);
		assertEquals(json, r);
	}
	
	@Test
	public void test13(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.updateDeliveryCharge(123, json);
		assertEquals(json, r);
	}
	
	//farmer tests ended
	
	//customer tests started
	
	@Test
	public void test14(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.createCustomerAccountPOST(json);
		assertEquals(json, r);
	}
	
	@Test
	public void test15(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.updateCustomerAccountPOST(85, json);
		assertEquals(json, r);
	}
	
	@Test
	public void test16(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewCustomerAccount(85);
		assertEquals(json, r);
	}
	
	@Test
	public void test17(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.createOrder(85, json);
		assertEquals(json, r);
	}
	
	@Test
	public void test18(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewAllOrders(85);
		assertEquals(json, r);
	}
	
	@Test
	public void test19(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewOrder(85, 97);
		assertEquals(json, r);
	}
	
	@Test
	public void test20(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.cancelOrder(85, 97);
		assertEquals(json, r);
	}
	
	//customer tests ended
	
	//manager tests started
	
	@Test
	public void test21(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewCatalog();
		assertEquals(json, r);
	}
	
	@Test
	public void test22(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.addProductToCatalog(json);
		assertEquals(json, r);
	}
	
	@Test
	public void test23(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.updateProductGenCatalog(125, json);
		assertEquals(json, r);
	}
	
	@Test
	public void test24(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewAllAccounts();
		assertEquals(json, r);
	}
	
	@Test
	public void test25(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewAccount(79);
		assertEquals(json, r);
	}
	
	@Test
	public void test26(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewAllReports();
		assertEquals(json, r);
	}
	
	@Test
	public void test27(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewReport(2);
		assertEquals(json, r);
	}
	
	@Test
	public void test28(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.viewReport(3);
		assertEquals(json, r);
	}
	
	//manager tests ended
	
	//search tests started
	
	@Test
	public void test29(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.search("farm", "smith");
		assertEquals(json, r);
	}
	
	@Test
	public void test30(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.search("customer", "virgil");
		assertEquals(json, r);
	}
	
	@Test
	public void test31(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.search("order", "97");
		assertEquals(json, r);
	}
	
	@Test
	public void test32(){
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.updateDeliveryStatus(97, json);
		assertEquals(json, r);
	}
}
