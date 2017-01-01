package lf2u.rest.service;

import static org.junit.Assert.*;

import javax.ws.rs.core.*;

import org.junit.Test;
import java.lang.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.json.*;

public class TestRest {

	RestApiService rc = new RestApiService();
	
	//farmer tests started
	
	@Test
	public void test1() throws JSONException{
        try{
		String json = "{\"farm_info\": {\"name\": \"SafeHouse Farm Alpacas\", \"address\": \"25550 W Cuba Rd, Barrington, IL 60010\", \"phone\": \"847-651-2140\", \"web\": \"http://www.openher.com\"}, \"personal_info\": {\"name\": \"John Smith\", \"email\": \"john.smith@example.com\", \"phone\": \"123-456-7890\"}, \"delivers_to\": [\"60010\", \"60011\", \"60067\"]}";
		Response r = rc.createFarmerAccountPOST(json);
		assertEquals("3", r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test33() throws JSONException{
        try{
		String json = "{\"farm_info\": {\"name\": \"SafeHouse Farm Alpacas\", \"address\": \"25550 W Cuba Rd, Barrington, IL 60010\", \"phone\": \"847-651-2140\"}, \"personal_info\": {\"name\": \"John Smith\", \"email\": \"john.smith@example.com\", \"phone\": \"123-456-7890\"}, \"delivers_to\": [\"60010\", \"60011\", \"60067\"]}";
		Response r = rc.createFarmerAccountPOST(json);
		
		assertEquals("1", r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	/*@Test
	public void test2() throws JSONException{
        try{
		String json2 = "{\"farm_info\": {\"name\": \"Tall Trees\", \"address\": \"25550 W Cuba Rd, Barrington, IL 60010\", \"phone\": \"847-651-2140\", \"web\": \"\"}, \"personal_info\": { \"name\": \"Eva Smith\", \"email\": \"eva.smith@example.com\", \"phone\": \"123-456-7890\"}, \"delivers_to\": [\"60010\", \"60011\"]}";
		Response r2 = rc.updateFarmerAccountPOST(2, json2);
		assertEquals(null, r2.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test34() throws JSONException{
        try{
		String json2 = "{\"farm_info\": {\"name\": \"Tall Trees\", \"address\": \"25550 W Cuba Rd, Barrington, IL 60010\", \"phone\": \"847-651-2140\"}, \"personal_info\": { \"name\": \"Eva Smith\", \"email\": \"eva.smith@example.com\", \"phone\": \"123-456-7890\"}, \"delivers_to\": [\"60010\", \"60011\"]}";
		Response r2 = rc.updateFarmerAccountPOST(1, json2);
		assertEquals(null, r2.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}*/
	
	@Test
	public void test3() throws Exception{
        try{
		Response r = rc.viewAllFarmerAccountsGET();
		String json = "{\n  \t\"fid\": \"1\",\n  \t\"farm_info\": {\n  \t\t\"name\": \"Tall Trees\",\n  \t\t\"address\": \"25550 W Cuba Rd, Barrington, IL 60010\",\n  \t\t\"phone\": \"847-651-2140\",\n  \t\t\"web\": \"\"\n  \t},\n  \t\"personal_info\": {\n  \t\t\"name\": \"Eva Smith\",\n  \t\t\"email\": \"eva.smith@example.com\",\n  \t\t\"phone\": \"123-456-7890\"\n  \t},\n  \t\"delivers_to\": [\"60010\", \"60011\"]\n  }";
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test4() throws Exception{
        try{
		String json = "[{\n  \t\"fid\": \"1\",\n  \t\"name\": \"Tall Trees\"\n  }]";
		Response r = rc.viewFarmersByZipGET("60010");
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test35() throws Exception{
        try{
		String json = "[{\n  \t\"fid\": \"1\",\n  \t\"name\": \"Tall Trees\"\n  }]";
		Response r = rc.viewFarmerAccountGET(1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test5() throws Exception{
        try{
		String json = "[{\n    \"fspid\": \"345\",\n    \"name\": \"Potatoes\",\n    \"note\": \"These Russets are ideal for light and fluffy mashed potatoes.\",\n    \"start_date\": \"10-01\",\n    \"end_date\": \"\",\n    \"price\": 0.29,\n    \"product_unit\": \"lb\",\n    \"image\": \"\"\n  },\n  {\n    \"fspid\": \"346\",\n    \"name\": \"Eggplant\",\n    \"note\": \"Deep purple skin; average size is 2lb\",\n    \"start_date\": \"08-15\",\n    \"end_date\": \"10-30\",\n    \"price\": 2.75,\n    \"product_unit\": \"piece\",\n    \"image\": \"\"\n  }]";
		Response r = rc.viewFarmerProductsGET(1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test6() throws JSONException{
        try{
		String json = "{\n    \"gcpid\": \"1\",\n    \"note\": \"These Russets are ideal for light and fluffy mashed potatoes.\",\n    \"start_date\": \"10-01\",\n    \"end_date\": \"\",\n    \"price\": 0.29,\n    \"product_unit\": \"lb\",\n    \"image\": \"\"\n  }";
		Response r = rc.postProductToFarmStore(1, json);
		String json1 = "{\n    \"fspid\": \"345\"\n  }";
		assertEquals(json1, r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test7() throws JSONException{
        try{
		String json = "{\"farm_info\": {\"name\": \"dfas\"}}";
		Response r = rc.modifyStoreProduct(1, 1, json);
		assertEquals(null, r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test8() throws Exception{
        try{
		String json = "{\n    \"fspid\": \"1\",\n    \"note\": \"These Russets are ideal for light and fluffy mashed potatoes.\",\n    \"start_date\": \"10-01\",\n    \"end_date\": \"\",\n    \"price\": 0.29,\n    \"product_unit\": \"lb\",\n    \"image\": \"\"\n  }";
		Response r = rc.getFarmStoreProductDetails(1, 1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test9() throws Exception{
        try{
		String json = "[{\n  \t\"frid\": \"701\",\n  \t\"name\": \"Orders to deliver today\"\n  }, {\n  \t\"frid\": \"702\",\n  \t\"name\": \"Orders to deliver tomorrow\"\n  }, {\n  \t\"frid\": \"703\",\n  \t\"name\": \"Revenue report\"\n  }, {\n  \t\"frid\": \"704\",\n  \t\"name\": \"Orders delivery report\"\n  }]";
		Response r = rc.getAllFarmerReports(1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test10() throws Exception{
        try{
		String json = "{\n  \t\"frid\": 701,\n  \t\"name\": \"Orders to deliver today\",\n  \t\"orders\": [{\n  \t\t\"oid\": \"456\",\n  \t\t\"products_total\": 10.57,\n  \t\t\"delivery_charge\": 5.00,\n  \t\t\"order_total\": 15.57,\n  \t\t\"status\": \"open\",\n  \t\t\"order_date\": \"20161020\",\n  \t\t\"planned_delivery_date\": \"20161021\",\n  \t\t\"actual_delivery_date\": \"\",\n  \t\t\"ordered_by\": {\n  \t\t\t\"name\": \"Virgil B\",\n  \t\t\t\"email\": \"virgil@example.com\",\n  \t\t\t\"phone\": \"312-456-7890\"\n  \t\t},\n  \t\t\"delivery_address\": \"10 West 31st ST, Chicago IL 60616\",\n  \t\t\"note\": \"Room SB-214\",\n  \t\t\"order_detail\": [{\n  \t\t\t\"fspid\": 345,\n  \t\t\t\"name\": \"Potatoes\",\n  \t\t\t\"order_size\": \"8 lb\",\n  \t\t\t\"price\": \"0.29 per lb\",\n  \t\t\t\"line_item_total\": 2.32\n  \t\t}, {\n  \t\t\t\"fspid\": 346,\n  \t\t\t\"name\": \"Eggplant\",\n  \t\t\t\"order_size\": \"3 piece\",\n  \t\t\t\"price\": \"2.75 per piece\",\n  \t\t\t\"line_item_total\": 8.25\n  \t\t}]\n  \t}, {\n  \t\t\"oid\": \"459\",\n  \t\t\"products_total\": 7.50,\n  \t\t\"delivery_charge\": 5.00,\n  \t\t\"order_total\": 12.50,\n  \t\t\"status\": \"open\",\n  \t\t\"order_date\": \"20161020\",\n  \t\t\"planned_delivery_date\": \"20161021\",\n  \t\t\"actual_delivery_date\": \"\",\n  \t\t\"ordered_by\": {\n  \t\t\t\"name\": \"John Doe\",\n  \t\t\t\"email\": \"john.doe@example.com\",\n  \t\t\t\"phone\": \"123-456-7890\"\n  \t\t},\n  \t\t\"delivery_address\": \"123 Main ST, Chicago IL 60617\",\n  \t\t\"note\": \"Please leave with building attendant.\",\n  \t\t\"order_detail\": [{\n  \t\t\t\"fspid\": 347,\n  \t\t\t\"name\": \"Tomatoes\",\n  \t\t\t\"order_size\": \"5 lb\",\n  \t\t\t\"price\": \"1.50 per lb\",\n  \t\t\t\"line_item_total\": 7.50\n  \t\t}]\n  \t}]\n  }";
		Response r = rc.getFarmerReport(1, 701);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test11() throws Exception{
        try{
		String json = "{\n  \t\"frid\": 703,\n  \t\"name\": \"Revenue report\",\n  \t\"start_date\": \"20161019\",\n  \t\"end_date\": \"20161019\",\n  \t\"orders_placed\": 9,\n  \t\"orders_cancelled\": 2,\n  \t\"orders_delivered\": 7,\n  \t\"products_revenue\": 513.98,\n  \t\"delivery_revenue\": 15\n  }";
		Response r = rc.getFarmerReportWithSDED(1, 703, "20161019", "20161019");
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test12() throws Exception{
        try{
		String json = "{\n  \t\"delivery_charge\": 9.95\n  }";
		Response r = rc.getDeliveryCharge(1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test13() throws JSONException{
        try{
		String json = "{\n  \t\"delivery_charge\": 5.00\n }";
		Response r = rc.updateDeliveryCharge(123, json);
		assertEquals(json, r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	//farmer tests ended
	
	//customer tests started
	
	@Test
	public void test14() throws JSONException{
        try{
		String json = "{\n  \t\"name\": \"Virgil B\",\n  \t\"street\": \"10 West 31st Street, #214\",\n  \t\"zip\": \"60616\",\n  \t\"phone\": \"312-567-5146\",\n  \t\"email\": \"virgilb@example.com\"\n  }";
		Response r = rc.createCustomerAccountPOST(json);
		assertEquals("1", r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test15() throws JSONException{
        try{
		String json = "{\n  \t\"name\": \"Virgil B\",\n  \t\"street\": \"1405 W Palatine Rd, Hoffman Estates\",\n  \t\"zip\": \"60192\",\n  \t\"phone\": \"847-963-8845\",\n  \t\"email\": \"virgilb@example.com\"\n  }";
		Response r = rc.updateCustomerAccountPOST(85, json);
		assertEquals(null, r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test16() throws Exception{
        try{
		String json = "{\n  \t\"cid\": \"1\",\n  \t\"name\": \"Virgil B\",\n  \t\"street\": \"10 West 31st Street, #214\",\n  \t\"zip\": \"60616\",\n  \t\"phone\": \"312-567-5146\",\n  \t\"email\": \"virgilb@example.com\"\n  }";
		Response r = rc.viewCustomerAccount(1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test17() throws JSONException{
        try{
		String json = "{\n  \t\"fid\": \"1\",\n  \t\"order_detail\": [\n      { \"fspid\": \"1\",\n         \"amount\": 1.5\n       },\n       { \"fspid\": \"1\",\n         \"amount\": 8\n       }\n    ],\n    \"delivery_note\": \"Please leave with building attendant.\"\n  }";
		Response r = rc.createOrder(1, json);
		assertEquals("1", r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test18() throws Exception{
        try{
		String json = "[{\n  \t\"oid\": \"1\",\n  \t\"order_date\": \"20161021\",\n  \t\"planned_delivery_date\": \"20161022\",\n  \t\"actual_delivery_date\": \"\",\n  \t\"status\": \"open\",\n  \t\"fid\": \"123\"\n  }]";
		Response r = rc.viewAllOrders(1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test19() throws Exception{
        try{
		String json = "{\n  \t\"oid\": \"1\",\n  \t\"order_date\": \"20161021\",\n  \t\"planned_delivery_date\": \"20161022\",\n  \t\"actual_delivery_date\": \"\",\n  \t\"status\": \"open\",\n  \t\"farm_info\": {\n      \"fid\": \"123\",\n  \t\t\"name\": \"Tall Trees\",\n  \t\t\"address\": \"25550 W Cuba Rd, Barrington, IL 60010\",\n  \t\t\"phone\": \"847-651-2140\",\n  \t\t\"web\": \"\"\n  \t},\n  \t\"order_detail\": [{\n  \t\t\"fspid\": \"345\",\n  \t\t\"name\": \"Potatoes\",\n  \t\t\"amount\": \"1.5 lb\",\n  \t\t\"price\": \"0.29 per lb\",\n  \t\t\"line_item_total\": 0.43\n  \t}, {\n  \t\t\"fspid\": \"346\",\n  \t\t\"name\": \"Eggplant\",\n  \t\t\"amount\": \"8 piece\",\n  \t\t\"price\": \"2.75 per piece\",\n  \t\t\"line_item_total\": 22.00\n  \t}],\n  \t\"delivery_note\": \"Please leave with building attendant.\",\n  \t\"products_total\": 22.43,\n  \t\"delivery_charge\": 5.00,\n  \t\"order_total\": 27.43\n  }";
		Response r = rc.viewOrder(1, 1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	/*@Test
	public void test20() throws Exception{
        try{
		Response r = rc.cancelOrder(1, 1);
		assertEquals("false", r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}*/
	
	//customer tests ended
	
	//manager tests started
	
	@Test
	public void test21() throws Exception{
        try{
		String json = "[{\n  \t\"gcpid\": \"125\",\n  \t\"name\": \"Potatoes\"\n  }, {\n  \t\"gcpid\": \"126\",\n  \t\"name\": \"Tomatoes\"\n  }, {\n  \t\"gcpid\": \"127\",\n  \t\"name\": \"Eggplant\"\n  }]";
		Response r = rc.viewCatalog();
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test22() throws JSONException{
        try{
		String json = "{\n  \t\"name\": \"Potatoes\"\n  }\n  ";
		Response r = rc.addProductToCatalog(json);
		assertEquals("1", r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test23() throws JSONException{
        try{
		String json = "{\n  \t\"name\": \"Potatoes (red)\"\n  }\n  ";
		Response r = rc.updateProductGenCatalog(125, json);
		assertEquals(null, r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test24() throws Exception{
        try{
		String json = "[{\n    \"mid\": \"1\",\n    \"name\": \"Super User\",\n    \"created_by\": \"System\"\n    \"create_date\": \"20161001\",\n    \"phone\": \"123-0987-654\",\n    \"email\": \"superuser@example.com\"\n  }]";
		Response r = rc.viewAllAccounts();
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test25() throws Exception{
        try{
		String json = "[{\n    \"mid\": \"1\",\n    \"name\": \"Super User\",\n    \"created_by\": \"System\"\n    \"create_date\": \"20161001\",\n    \"phone\": \"123-0987-654\",\n    \"email\": \"superuser@example.com\"\n  }]";
		Response r = rc.viewAccount(1);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test26() throws Exception{
        try{
		String json = "[{\n  \t\"mrid\": \"1\",\n  \t\"name\": \"Orders placed today\"\n  }, {\n  \t\"mrid\": \"2\",\n  \t\"name\": \"Orders placed yesterday\"\n  }, {\n  \t\"mrid\": \"3\",\n  \t\"name\": \"Revenue for previous month\"\n  }, {\n  \t\"mrid\": \"4\",\n  \t\"name\": \"Revenue yesterday\"\n  }, {\n  \t\"mrid\": \"5\",\n  \t\"name\": \"Revenue yesterday by zip code\"\n  }]";
		Response r = rc.viewAllReports();
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test27() throws Exception{
        try{
		String json = "{\n  \t\"mrid\": \"2\",\n  \t\"name\": \"Orders placed yesterday\",\n  \t\"orders_placed\": 19,\n  \t\"orders_delivered\": 11,\n  \t\"orders_open\": 5,\n  \t\"orders_cancelled\": 3\n  }";
		Response r = rc.viewReport(2);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test28() throws Exception{
        try{
		String json = "{\n  \t\"mrid\": \"3\",\n  \t\"name\": \"Revenue for last month\",\n  \t\"start_date\": \"20160901\",\n  \t\"end_date\": \"20160930\",\n  \t\"orders_placed\": 84,\n  \t\"orders_delivered\": 80,\n  \t\"orders_open\": 1,\n  \t\"orders_cancelled\": 3,\n  \t\"total_revenue\": 2222.25,\n  \t\"total_products_revenue\": 1638.25,\n  \t\"total_delivery_revenue\": 584,\n  \t\"lf2u_management_fee\": 0.03,\n  \t\"total_lftu_fees\": 66.67,\n  \t\"total_payable_to_farms\": 2155.59,\n  \t\"by_farmer\": [{\n  \t\t\"fid\": \"123\",\n  \t\t\"name\": \"Tall Trees\",\n  \t\t\"orders_placed\": 35,\n  \t\t\"orders_delivered\": 34,\n  \t\t\"orders_open\": 1,\n  \t\t\"orders_cancelled\": 0,\n  \t\t\"total_revenue\": 896.50,\n  \t\t\"products_revenue\": 726.50,\n  \t\t\"delivery_revenue\": 170,\n  \t\t\"lftu_fees\": 26.90,\n  \t\t\"payable_to_farm\": 869.61\n  \t}, {\n  \t\t\"fid\": \"127\",\n  \t\t\"name\": \"Spotted Cow\",\n  \t\t\"orders_placed\": 49,\n  \t\t\"orders_delivered\": 46,\n  \t\t\"orders_open\": 0,\n  \t\t\"orders_cancelled\": 3,\n  \t\t\"total_revenue\": 1325.75,\n  \t\t\"products_revenue\": 911.75,\n  \t\t\"delivery_revenue\": 414,\n  \t\t\"lftu_fees\": 39.77,\n  \t\t\"payable_to_farm\": 1285.98\n  \t}]\n  }";
		Response r = rc.viewReport(3);
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	//manager tests ended
	
	//search tests started
	
	@Test
	public void test29() throws Exception{
        try{
		String json = "[{\n  \t\"fid\": \"123\",\n  \t\"farm_info\": {\n  \t\t\"name\": \"Tall Trees\",\n  \t\t\"address\": \"25550 W Cuba Rd, Barrington, IL 60010\",\n  \t\t\"phone\": \"847-651-2140\",\n  \t\t\"web\": \"\"\n  \t},\n  \t\"personal_info\": {\n  \t\t\"name\": \"Eva Smith\",\n  \t\t\"email\": \"eva.smith@example.com\",\n  \t\t\"phone\": \"123-456-7890\"\n  \t},\n  \t\"delivers_to\": [\"60010\", \"60011\"]\n  }]";
		Response r = rc.search("farm", "smith");
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test30() throws Exception{
        try{
		String json = "[{\n  \t\"cid\": \"85\",\n  \t\"name\": \"Virgil B\",\n  \t\"street\": \"10 West 31st Street, #214\",\n  \t\"zip\": \"60616\",\n  \t\"phone\": \"312-567-5146\",\n  \t\"email\": \"virgilb@example.com\"\n  }]";
		Response r = rc.search("customer", "virgil");
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test31() throws Exception{
        try{
		String json = "[{\n  \t\"oid\": \"1\",\n  \t\"order_date\": \"20161021\",\n  \t\"planned_delivery_date\": \"20161022\",\n  \t\"actual_delivery_date\": \"\",\n  \t\"status\": \"open\",\n  \t\"customer_info\": {\n  \t\t\"cid\": \"85\",\n  \t\t\"name\": \"Virgil B\",\n  \t\t\"street\": \"1405 W Palatine Rd, Hoffman Estates\",\n  \t\t\"zip\": \"60192\",\n  \t\t\"phone\": \"847-963-8845\",\n  \t\t\"email\": \"virgilb@example.com\"\n  \t},\n  \t\"farm_info\": {\n  \t\t\"fid\": \"123\",\n  \t\t\"name\": \"Tall Trees\",\n  \t\t\"address\": \"25550 W Cuba Rd, Barrington, IL 60010\",\n  \t\t\"phone\": \"847-651-2140\",\n  \t\t\"web\": \"\"\n  \t},\n  \t\"order_detail\": [{\n  \t\t\"fspid\": \"345\",\n  \t\t\"name\": \"Potatoes\",\n  \t\t\"amount\": \"1.5 lb\",\n  \t\t\"price\": \"0.29 per lb\",\n  \t\t\"line_item_total\": 0.43\n  \t}, {\n  \t\t\"fspid\": \"346\",\n  \t\t\"name\": \"Eggplant\",\n  \t\t\"amount\": \"8 piece\",\n  \t\t\"price\": \"2.75 per piece\",\n  \t\t\"line_item_total\": 22.00\n  \t}],\n  \t\"delivery_note\": \"Please leave with building attendant.\",\n  \t\"products_total\": 22.43,\n  \t\"delivery_charge\": 5.00,\n  \t\"order_total\": 27.43\n  }]";
		Response r = rc.search("order", "1");
		assertEquals(json, r.getEntity());
        }
        catch(Exception js){
            System.out.println(js.getMessage());
        }
	}
	
	@Test
	public void test32() throws JSONException{
        try{
		String json = "{\n  \t\"status\": \"delivered\"\n  }";
		Response r = rc.updateDeliveryStatus(1, json);
		assertEquals("false", r.getEntity());
        }
        catch(JSONException js){
            System.out.println(js.getMessage());
        }
	}
}
