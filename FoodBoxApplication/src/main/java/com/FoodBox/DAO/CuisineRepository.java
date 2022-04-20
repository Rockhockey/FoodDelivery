package com.FoodBox.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FoodBox.model.Cuisines;

@Repository
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
	
	/*View search menu ordered by cuisine
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE(Name LIKE %?1% OR Cuisine=%?1% OR Description LIKE %?1%) AND Visible=TRUE ORDER BY Cuisine ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordCuisine (String keyword);
	
	/*View search menu ordered by Price ASC
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE(Name LIKE %?1% OR Cuisine=%?1% OR Description LIKE %?1%) AND Visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordPriceAsc (String keyword);
	
	/*View search menu ordered by Price Desc
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE(Name LIKE %?1% OR Cuisine=%?1% OR Description LIKE %?1%) AND Visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordPriceDesc (String keyword);
	
	/*View search menu ordered by Price ASC
	 * 	input cuisine to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE Cuisine=%?1% AND Visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuCuisinePriceAsc (String keyword);
	
	/*View search menu ordered by Price Desc
	 * 	input cuisine to search for
	 */
	@Query(value=" SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu "
			+ "WHERE Cuisine=%?1% AND Visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuCuisinePriceDesc (String keyword);
	
	/*
	@Query(value=" ", nativeQuery= true)
	List<Cuisines> ReadMenu ();
*/
}