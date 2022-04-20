package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.FoodBox.model.Cart;
import com.FoodBox.model.Cuisines;

public interface CartRepository extends JpaRepository<Cart, Integer> {	
	
	// i believe some other methods go here.. need to figure out
	//View current Cart
	@Query(value="SELECT Menu.Name, Menu.Price*Menu.Offer as CurrentPrice, Cart.Quantity FROM Cart INNER JOIN Menu ON Cart.Item=Menu.MenuID;", nativeQuery= true)
	List<Cuisines> ReadCart();

	//View Total Cost of current Cart
	@Query(value="SELECT SUM(Menu.Price*Menu.Offer*Cart.Quantity) FROM Cart INNER JOIN Menu ON Cart.Item=Menu.MenuID;", nativeQuery= true)
	List<Cuisines> CartCost();
	
	//Move info from Cart to Orders
		@Query(value="INSERT INTO Orders( OrderNumber, UserID, OrderTime, Cost) Values(sequence_Orders.nextval, "
				+ "?1, SYSDATETIME(), SELECT SUM(Menu.Price*Menu.Offer*Cart.Quantity) FROM Cart INNER JOIN Menu ON Cart.Item=Menu.MenuID;)", nativeQuery= true)
		List<Cuisines> CartToOrders(Integer ID);
		
		//Move info from Cart to Order History
		@Query(value="INSERT INTO OrderHistory( OHKey, OrderNumber, Item, Quantity) VALUES (SELECT  sequence_OrderHistory.nextval, "
				+ "sequence_Orders.currval, Item, Quantity) FROM Cart;", nativeQuery= true)
		List<Cuisines> CartToOH();
}
