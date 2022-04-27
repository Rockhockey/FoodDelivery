package com.FoodBox.DAO;

import java.sql.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	@Query(value="SELECT * FROM menu WHERE visible=TRUE ORDER BY cuisine_type ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuOrderCuisine();
	
	//View Menu Ordered by Price ASC
	@Query(value="SELECT *, price*offer AS CurrentPrice FROM menu WHERE visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuOrderPriceAsc();
	
	//View Menu Ordered by Price Desc
		@Query(value="SELECT *, price*offer AS CurrentPrice FROM menu WHERE visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
		List<Cuisines> ReadMenuOrderPriceDesc();
	
	/*View search menu ordered by cuisine
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT * FROM menu WHERE(name LIKE %:keyword1% OR cuisine_type LIKE %:keyword2% OR description LIKE %:keyword3%) AND visible=TRUE ORDER BY cuisine_type ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordCuisine (
			@Param("keyword1") String keyword1,
			@Param("keyword2") String keyword2,
			@Param("keyword3") String keyword3);
	
	/*View search menu ordered by Price ASC
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT *, price*offer as CurrentPrice FROM menu WHERE(name LIKE %:keyword1% OR cuisine_type LIKE %:keyword2% OR description LIKE %:keyword3%)"
		+ " AND visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordPriceAsc (
			@Param("keyword1") String keyword1,
			@Param("keyword2") String keyword2,
			@Param("keyword3") String keyword3);
	
	/*View search menu ordered by Price Desc
	 * 	input keyword to search for
	 */
	@Query(value=" SELECT *, price*offer as CurrentPrice FROM menu WHERE(name LIKE %:keyword1% OR cuisine_type LIKE %:keyword2% OR description LIKE %:keyword3%)"
		+ " AND visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuKeywordPriceDesc (
			@Param("keyword1") String keyword1,
			@Param("keyword2") String keyword2,
			@Param("keyword3") String keyword3);
	
	/*View search menu ordered by Price ASC
	 * 	input cuisine to search for
	 */
	@Query(value=" SELECT *, price*offer as CurrentPrice FROM menu "
			+ "WHERE cuisine_type LIKE %:foodType% AND visible=TRUE ORDER BY CurrentPrice ASC;", nativeQuery= true)
	List<Cuisines> ReadMenuCuisinePriceAsc (
			@Param("foodType") String cuisine);

	/*View search menu ordered by Price Desc
	 * 	input cuisine to search for
	 */
	@Query(value=" SELECT *, price*offer as CurrentPrice FROM menu "
			+ "WHERE cuisine_type LIKE %:foodType% AND visible=TRUE ORDER BY CurrentPrice DESC;", nativeQuery= true)
	List<Cuisines> ReadMenuCuisinePriceDesc (
			@Param("foodType") String cuisine);

}