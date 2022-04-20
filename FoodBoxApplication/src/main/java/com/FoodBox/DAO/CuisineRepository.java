package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.FoodBox.model.Cuisines;
import org.springframework.data.repository.query.*;

public interface CuisineRepository extends JpaRepository<Cuisines, Integer>{

	
	/*for CRUD
	CREATE --- POST
	READ --- GET
	UPDATE --- PUT
	DELETE --- DELETE
	
	implements methods from CRUD repository as well
	built in methods like findAll(), count(), delete()
	
	-- OUR CUSTOM finder methods go here (filter)
	*/
	
	
	 
	 
	//View menu ordered by cuisine
	@Query(value="SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice,"
			+ " Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY Cuisine ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuOrderCuisine();
	
	//View Menu Ordered by Price ASC
	@Query(value="SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice,"
			+ " Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuOrderPriceAsc();
	
	//View Menu Ordered by Price Desc
		@Query(value="SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice,"
				+ " Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
		List<Cuisines> ReadMenuOrderPriceDesc();
		
	//View Menu Ordered by Discount Desc
		@Query(value="SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice,"
				+ " Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY PercentOff DESC;", nativeQuery= true)
		List<Cuisines> ReadMenuOrderDiscountDesc();
	
	/*View search menu ordered by cuisine
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE(Name LIKE %:keyword1% OR Cuisine=%:keyword2% OR Description LIKE %:keyword3%) AND Visible=TRUE ORDER BY Cuisine ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordCuisine (
			@Param("keyword1") String keyword1,
			@Param("keyword2") String keyword2,
			@Param("keyword3") String keyword3);
	
	/*View search menu ordered by Price ASC
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE(Name LIKE %:keyword1% OR Cuisine=%:keyword2% OR Description LIKE %:keyword3%) AND Visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordPriceAsc (
			@Param("keyword1") String keyword1,
			@Param("keyword2") String keyword2,
			@Param("keyword3") String keyword3);
	
	/*View search menu ordered by Price Desc
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE(Name LIKE %:keyword1% OR Cuisine=%:keyword2% OR Description LIKE %:keyword3%) AND Visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordPriceDesc (
			@Param("keyword1") String keyword1,
			@Param("keyword2") String keyword2,
			@Param("keyword3") String keyword3);
	
	/*View search menu ordered by Discount Desc
	 * 	input keyword to search for
	 */	
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE(Name LIKE %:keyword1% OR Cuisine=%:keyword2% OR Description LIKE %:keyword3%) AND Visible=TRUE ORDER BY PercentOff DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordDiscountDesc(
	@Param("keyword1") String keyword1,
	@Param("keyword2") String keyword2,
	@Param("keyword3") String keyword3);
	
	/*View search menu ordered by Price ASC
	 * 	input cuisine to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE Cuisine=%:foodType% AND Visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuCuisinePriceAsc (
			@Param("foodType") String cuisine);
	
	/*View search menu ordered by Price Desc
	 * 	input cuisine to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE Cuisine=%:foodType% AND Visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuCuisinePriceDesc (
			@Param("foodType") String cuisine);
	
	/*View search menu ordered by Discount Desc
	 * 	input cuisine to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE Cuisine=%:foodType% AND Visible=TRUE ORDER BY PercentOff DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuCuisineDiscountDesc (
			@Param("foodType") String cuisine);


}