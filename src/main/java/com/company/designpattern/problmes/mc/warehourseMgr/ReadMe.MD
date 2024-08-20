Seller Inventory Inwarding and Slot Booking
Problem Statement
You are tasked with designing and implementing a system to manage sellers inventory in flipkart warehouses. Any seller which wants to sell on flipkart has to register themself on the platform. The registration requires very basic details such as email_id of the seller. Every seller has a rating associated with them based on their sales and performance. After registering themselves on flipkart, they are assigned a default rating of 1.
Seller’s can add new products that they want to sell on flipkart with basic details such as product name, product id (This will be unique) and product price. In order to sell their products, sellers need to first send their inventory to Flipkart warehouses. There are multiple warehouses owned by Flipkart across India, and in order to send their goods to a warehouse, sellers first need to complete the warehouse onboarding process (this process will happen independently for every warehouse). Every warehouse will have a different capacity of the number of items it can accommodate on that date. Whenever sellers want to send inventory to any flipkart warehouse, they will have to select a day from the available list of days when the warehouse has capacity to accommodate their inventory.
Your task is to help build a system which supports the above functionalities

Requirements:
The system should allow seller’s to register themselves to flipkart. Assign them a default rating of 1 on registration.
Eg: REGISTER_SELLER(seller_id)  // [Registers seller with passed id and assigns them a default rating of 1]

Each seller can add products to their catalog with a unique product_id. Product details should include product_name and price.
ADD_PRODUCT(product_id, product_name, seller_id)
System should allow flipkart to add new warehouses to their list of warehouses. Assume 0 warehouses initially.
ADD_WAREHOUSE(warehouse_id)
Every warehouse will have a capacity which defines the number of items that warehouse can accommodate on that day. This capacity can different for every day in a warehouse. Initially, assume 0 capacity on all days. The system should allow flipkart to ingest available capacity in the warehouse on a date level. (Note: item here means 1 unit of a product)
ADD_CAPACITY(warehouse_id, date, capacity)
By default, sellers are not onboarded to any warehouse, and the system should allow sellers to onboard themselves to a warehouse. Sellers can onboard themselves to any number of warehouses. The seller cannot send inventory to a warehouse they have not onboarded to.
ONBOARD_WAREHOUSE(seller_id, warehouse_id)
Expose a functionality to display the available capacity in the warehouse for next 10 days from the passed date.
WAREHOUSE_CAPACITY(warehouse_id, start_date)
Sellers can request for available dates to send their products to any flipkart warehouse. The request will contain product_id and corresponding quantities that the seller wants to send, along with the date after which they want to send. System should return all possible warehouse X dates available for accommodating the inventory. Note: Availability  should only come for warehouses that the seller is onboarded to and for the dates which have sufficient capacity available. Capacity is said to be sufficient if the warehouse has available_capacity >= total number of items the seller wants to send. Note: There is no concept of partial availability, either the warehouse X date accommodates the entire consignment, or none of it.
GET_SLOTS(seller_id, List<Item,Quantity>,start_date)
Based on the available days and warehouses, sellers can reserve capacity on a particular day in a particular warehouse to send their inventory to. The reservation request will have warehouse, date, number_of_units, product_id to reserve. Post reservation, the available capacity should get adjusted accordingly
RESERVE_SLOT(seller_id, List<Item, Quantity>, date, warehouse_id)
For every slot reservation, the seller has to pay a cost which is computed as [number_of_units * 10 - (10 * seller_rating)]

For every 150 units of inventory reserved by a seller for inwarding in any warehouse, the seller rating increases by 1. Max rating of a seller can go to 10

Sample test cases:
REGISTER_SELLER(sameer.maniyar)  //  [Registers seller with id sameer.maniyar@flipkart.com with a default rating of 1]
REGISTER_SELLER(ravi.sharma)
ADD_WAREHOUSE(“blr_wh”) // [Registers a warehouse with id blr_wh]
ADD_WAREHOUSE(“delhi_wh”)
ADD_CAPACITY(“blr_wh”, 2024-06-01, 100)
ADD_CAPACITY(“blr_wh”, 2024-06-02, 170)
ADD_CAPACITY(“blr_wh”, 2024-06-03, 80)
ADD_CAPACITY(“delhi_wh”, 2024-06-03, 300)
WAREHOUSE_CAPACITY(“delhi_wh”,2024-06-01)
Output:
2024-06-03 - Available capacity: 300
ADD_PRODUCT(“PID1”,”Maggie”, “sameer.maniyar”) // Adds product with LID
ADD_PRODUCT(“PID2”,”One Plus 8”, “sameer.maniyar”)
ADD_PRODUCT(“PID3”,”Iphone11”, “sameer.maniyar")
ADD_PRODUCT(“PID4”,“LG AC”, “ravi.sharma”)
ONBOARD_WAREHOUSE(“sameer.maniyar”, “blr_wh”) // [Onboards sameer.maniyar to blr_wh warehouse]
GET_SLOTS(“sameer.maniyar”, [“PID1” - 50, “PID2” - 110], “2024-06-01”)
Output:
[blr_wh, 2024-06-02] // [Total capacity needed is 50+110 = 160. blr_wh is the only warehouse sameer.maniyar is onboarded to and in blr_wh only 2nd june has capacity > 160 available]
ONBOARD_WAREHOUSE(“sameer.maniyar”, “delhi_wh”)
GET_SLOTS(“sameer.maniyar”, [“PID1” - 50, “PID2” - 110], “2024-06-01”)
Output:
[blr_wh, 2024-06-02]
[delhi_wh, 2024-06-03]
RESERVE_SLOT(“sameer.maniyar”, [“PID1” - 50, “PID2” - 110], “2024-06-03”, “delhi_wh”)
Output: Success. Amount = 1590 // [160 * 10 - (10*1)]
WAREHOUSE_CAPACITY(“delhi_wh”,2024-06-01)
2024-06-03 - Available capacity: 140
GET_SLOTS(“ravi.sharma”,[“PID4” - 100], “2024-06-01”)
Output: No slots available // [Since ravi has not onboarded to any warehouse]
ONBOARD_WAREHOUSE(“ravi.sharma”, “delhi_wh”)
GET_SLOTS(“ravi.sharma”, [“PID4” - 100], “2024-06-01”)
Output:
[“delhi_wh”, “2024-06-03”] // [Now that ravi has onboarded to delhi_wh and there is sufficient capacity available on 2024-06-03, we show that slot]
RESERVE_SLOT(“ravi.sharma”, [“PID4” - 100], “2024-06-01”, “blr_wh”)
Output:
False, ravi.sharma is not onboarded to blr_wh

Bonus:
Implement an alternate slotting strategy. In this strategy, if there is no single day with sufficient capacity for what the seller wants to inward, give a list of slots across days for the seller to be able to inward their entire inventory. Make this slotting strategy pluggable in nature.
Eg:
REGISTER_SELLER(sameer.maniyar)  
REGISTER_WAREHOUSE(“blr_wh”)
ADD_PRODUCT(“PID1”, “sameer.maniyar)
ADD_CAPACITY(“blr_wh”, 2024-06-01, 100)
ADD_CAPACITY(“blr_wh”, 2024-06-02, 170)
GET_SLOTS_BONUS(“sameer.maniyar”, [“PID1” - 250], “2024-06-01”)
Output:
[blr_wh - (2024-06-01 - 100 ), (2024-06-02 - 150)]

Expectation:
1. Make sure that you have working and demoable & functionally correct code.
2. Use proper abstractions, separation of concerns, proper entity modeling
3. Use appropriate design patterns wherever required.
4. The code should be modular, extensible, readable and unit-testable.
5. Proper exception handling is required.
6. Concurrency handling (BONUS / Good to have) 






  


