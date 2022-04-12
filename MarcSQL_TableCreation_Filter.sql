-- Table Creation

create table Menu (
	MenuID INT NOT NULL PRIMARY KEY, 
	Name VARCHAR(25) NOT NULL,
	Price FLOAT(5,2) NOT NULL CHECK(Price>=0),
	Cuisine VARCHAR(25),
	Description VARCHAR(500),
	Offer FLOAT(5,2) NOT NULL CHECK(Offer<=1 AND Offer>=0),
	Visible boolean NOT NULL
	);
	
	
--Filter
	SELECT Name, Price*Offer as CurrentPrice, Cuisine, Description,  FROM Menu
	WHERE Cuisine LIKE %(Param)% OR
		Name LIKE %(Param)% OR
		Description LIKE %(Param)%;
