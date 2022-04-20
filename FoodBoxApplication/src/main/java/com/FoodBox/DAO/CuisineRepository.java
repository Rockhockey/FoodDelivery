package com.FoodBox.DAO;

import java.sql.*;
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
<<<<<<< HEAD
	
	
=======
	// View menu ordered by Cuisine
	public static String ViewMenu(Connection con) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY Cuisine ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// View menu ordered by Price acending
	public static String ViewMenuPriceAsc(Connection con) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY CurrentPrice ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// View menu ordered by Price decending
	public static String ViewMenuPriceDes(Connection con) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY CurrentPrice DESC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// View menu ordered by Discount Acending
	public static String ViewMenuDisctAsc(Connection con) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY PercebtOff ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// View menu ordered by Discount Descending
	public static String ViewMenuDisctDesc(Connection con) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer AS CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Visible=TRUE ORDER BY PercebtOff DESC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// search for keyword and View menu ordered by Cuisine Take in String keyword as Param variable	
	public static String ViewMenuKeywordCuisine(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE(Name LIKE %"+Param+"% OR Cuisine="+Param+"% OR Description LIKE %"+Param+"%) AND Visible=TRUE ORDER BY Cuisine ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}
	// search for keyword and View menu ordered by Price Ascending Take in String keyword as Param variable	
	public static String ViewMenuKeywordPriceAsc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE(Name LIKE %"+Param+"% OR Cuisine="+Param+"% OR Description LIKE %"+Param+"%) AND Visible=TRUE ORDER BY Price ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// search for keyword and View menu ordered by Price Descending Take in String keyword as Param variable	
	public static String ViewMenuKeywordPriceDesc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE(Name LIKE %"+Param+"% OR Cuisine="+Param+"% OR Description LIKE %"+Param+"%) AND Visible=TRUE ORDER BY Price DESC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// search for keyword and View menu ordered by Discount Ascending Take in String keyword as Param variable
	public static String ViewMenuKeywordDisctAsc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE(Name LIKE %"+Param+"% OR Cuisine="+Param+"% OR Description LIKE %"+Param+"%) AND Visible=TRUE ORDER BY PercentOff ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	// search for keyword and View menu ordered by Discount Descending Take in String keyword as Param variable
	public static String ViewMenuKeywordDisctDesc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE(Name LIKE %"+Param+"% OR Cuisine="+Param+"% OR Description LIKE %"+Param+"%) AND Visible=TRUE ORDER BY PercentOff DESC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr + "\n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	//View 1 cuisine on menu Take in String Cuisine as Param variable
	public static String ViewMenuCuisine(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Cuisine="+Param+" AND Visible=TRUE";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	//View 1 cuisine on menu ordered by price Ascending Take in String Cuisine as Param variable
	public static String ViewMenuCuisinePriceAsc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Cuisine="+Param+" AND Visible=TRUE ORDER BY Price ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	//View 1 cuisine on menu ordered by price Descending Take in String Cuisine as Param variable
	public static String ViewMenuCuisinePriceDesc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Cuisine="+Param+" AND Visible=TRUE ORDER BY Price DESC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	//View 1 cuisine on menu ordered by Discount Ascending Take in String Cuisine as Param variable
	public static String ViewMenuCuisineDisctAsc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Cuisine="+Param+" AND Visible=TRUE ORDER BY PercentOff ASC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}

	//View 1 cuisine on menu ordered by Discount Descending Take in String Cuisine as Param variable	
	public static String ViewMenuCuisineDisctDesc(Connection con, String Param) throws SQLException {
		String query = "SELECT Name, Price, (1-Offer)*100 AS PercentOff, Price*Offer as CurrentPrice, Cuisine, Description, Picture FROM Menu WHERE Cuisine="+Param+" AND Visible=TRUE ORDER BY PercentOff DESC";
		try (Statement stmt = con.createStatement()) {
		  ResultSet rs = stmt.executeQuery(query);
		  String result = "";
		  while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			float discount = rs.getFloat("PercentOff");
			float CurrentPrice= rs.getFloat("CurrentPrice");
			String Cuisine = rs.getString("Cuisine");
			String Descr = rs.getString("Description");
			String ImageLink = rs.getString("Picture");
			result= result + name + "," + price + "," + discount + "," + CurrentPrice + "," + Cuisine + "," + Descr +","+ImageLink+"/n";
		  }
		  return result;
		} catch (SQLException e) {
		  JDBCTutorialUtilities.printSQLException(e);
		}
	}	
>>>>>>> parent of e04fe67 (Merge branch 'main' of https://github.com/Rockhockey/FoodDelivery)
}