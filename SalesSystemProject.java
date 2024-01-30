package SalesManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Java.bean.DBConnection;

public class SalesSystemProject {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int key ; 
		Connection con = DBConnection.getConnection();
		do {
		System.out.println("Please Select the table to perform operations ");
		System.out.println("Press 1 for Unit Table --- ");
		System.out.println("Press 2 for Part Table ---");
		System.out.println("Press 3 Order Table ---");
		System.out.println("Press 0 for Exit");
		System.out.print(" Enter Here : ");
		 key = scan.nextInt();
		
		
		if(key == 1 ){
			unitTable();
		}else if(key ==2) {
			partTable();
		}else if (key ==3) {
			orderTable();
		}else {
			System.out.println("Please Input Valid Input.........");
			System.out.println("----------------------------------------------------------------");
		}
		}while(key != 0);
		
	}
	
	// Unit Table..........
	
	public static void unitTable() {
		int key;
		do {
		System.out.println("select option : ");
		System.out.println("Press 1 for insert Detail ");
		System.out.println("Press 2 for update Detail ");
		System.out.println("Press 3 for Delete Detail ");
		System.out.println("Press 4 for Select by Name ");
		System.out.println("Press 5 for Select All ");
		System.out.println("Press 0 for Exit ");
		
		System.out.print("Enter here : ");
		 key = scan.nextInt();
		
		switch (key) {
		case 1:
			System.out.println("insertion Success full = " + unitInsert());
			System.out.println("------------------------------------------");
			break;
		case 2:
			System.out.println("Update Successfull = " + unitUpdate());
			System.out.println("------------------------------------------");
			break;
		case 3:
			System.out.println("Delete Successfull = " + unitDelete());
			System.out.println("------------------------------------------");
			break;
		case 4:
			unitSelectByName();
			System.out.println("------------------------------------------");
			break;
		case 5:
			selectAll();
			System.out.println("------------------------------------------");
			break;
		default:
			break;
		}
		}while(key != 0);
	}
	
	public static int unitInsert() {
		Connection con = DBConnection.getConnection();
		int unitInsert=0;
		System.out.print("Enter Unit_id : ");
		int unitId = scan.nextInt();
		System.out.print("Enter City : ");
		String city = scan.next();
		System.out.print("Enter Capisity : "); 
		String capacity = scan.next();
		
		 try {
			PreparedStatement ps= 
					con.prepareStatement("INSERT INTO unit values(?,?,?)");
			ps.setInt(1, unitId);
			ps.setString(2, city);
			ps.setString(3, capacity);
			
			unitInsert = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 return unitInsert;
		 
	}
	
		public static int unitUpdate() {
			Connection con = DBConnection.getConnection();
			int unitUpdate = 0;
			System.out.print("Enter Unit id : ");
			int unitId = scan.nextInt();
			
			System.out.print("Enter New City Name : ");
			String newCityName = scan.next();
			try {
				PreparedStatement ps =
						con.prepareStatement("UPDATE unit SET city = ? WHERE unit_id = ?");
				ps.setString(1, newCityName);
				ps.setInt(2, unitId);
				
				unitUpdate = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return unitUpdate;
		}
		
		public static int unitDelete() {
			Connection con = DBConnection.getConnection();
			int unitDelete = 0;
			System.out.print("Enter Unit id : ");
			int unitId = scan.nextInt();
			
			try {
				PreparedStatement ps =
						con.prepareStatement("DELETE FROM unit WHERE unit_Id = ?");
				ps.setInt(1, unitId);
				
				unitDelete = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return unitDelete;
		}
		
		public static void unitSelectByName() {
			Connection con = DBConnection.getConnection();
			System.out.println("which selection  : ");
			System.out.println("Press 1 for city : ");
			System.out.println("Press 2 for capasity : ");
			System.out.print("Enter Here : ");
			int key = scan.nextInt();
			
			if (key == 1 ) {
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("Select city from unit");
				
				while(rs.next()) {
					System.out.println( rs.getString(1)+"\t");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}else {
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select capacity from unit");
					
					while(rs.next()) {
						System.out.println( rs.getString(1)+"\t");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}
		
		public static void selectAll() {
			Connection con = DBConnection.getConnection();
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from unit");
				
				//Unit table header.....
				
				ResultSetMetaData rsm = rs.getMetaData();
				for(int i =1; i<=rsm.getColumnCount(); i++) {
					System.out.print(rsm.getColumnName(i)+ "\t ");
				}
				System.out.println();
				while(rs.next()) {
					System.out.print( rs.getInt(1)+" \t ");
					System.out.print(rs.getString(2)+" \t ");
					System.out.print(rs.getString(3));
					System.out.println();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Part Table........
		
		public static void partTable() {
			int key ;
			do{
			System.out.println("select option : ");
			System.out.println("Press 1 for insert Detail ");
			System.out.println("Press 2 for update Detail ");
			System.out.println("Press 3 for Delete Detail ");
			System.out.println("Press 4 for Select by Name ");
			System.out.println("Press 5 for Select All ");
			System.out.println("Press 0 for Exit ");
			
			System.out.print("Enter here : ");
			key = scan.nextInt();
			
			switch (key) {
			case 1:
				System.out.println("insertion Success full = " + partInsert());
				System.out.println("------------------------------------------");
				break;
			case 2:
				System.out.println("Update Successfull = " + partUpdate());
				System.out.println("------------------------------------------");
				break;
			case 3:
				System.out.println("Delete Successfull = " + partDelete());
				System.out.println("------------------------------------------");
				break;
			case 4:
				partSelectByName();
				System.out.println("------------------------------------------");
				break;
			case 5:
				partselectAll();
				System.out.println("------------------------------------------");
				break;
			default:
				break;
			}
			}while(key != 0);
		}
		
		public static int partInsert() {
			Connection con = DBConnection.getConnection();
			int partInsert=0;
			System.out.print("Enter part_id : ");
			int partId = scan.nextInt();
			System.out.print("Enter name : ");
			String name = scan.next();
			System.out.print("Enter color : "); 
			String color = scan.next();
			
			
			 try {
				PreparedStatement ps= 
						con.prepareStatement("INSERT INTO part values(?,?,?)");
				ps.setInt(1, partId);
				ps.setString(2, name);
				ps.setString(3, color);
		
				partInsert = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 return partInsert;
			 
		}
		
			public static int partUpdate() {
				
				Connection con = DBConnection.getConnection();
				int partUpdate = 0;
				
				System.out.print("Enter Part id : ");
				int partId = scan.nextInt();
				
				System.out.println("Please select update option : ");
				System.out.println("Press 1 for Name update --- ");
				System.out.println("Press 2 for Color Update -----");
				
				System.out.print("Enter Here : ");
				int key = scan.nextInt();
				
				switch (key) {
				case 1:
					try {
						System.out.print("Enter New Name : ");
						String newName = scan.next();
						
						PreparedStatement ps =
								con.prepareStatement("UPDATE part SET name = ? WHERE part_id = ?");
						ps.setString(1, newName);
						ps.setInt(2, partId);
						
						partUpdate = ps.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					break;
					
				case 2:
						try {
							System.out.print("Enter New Color : ");
							String newColor = scan.next();
							
							PreparedStatement ps =
									con.prepareStatement("UPDATE part SET color = ? WHERE part_id = ?");
							ps.setString(1, newColor);
							ps.setInt(2, partId);
							
							partUpdate = ps.executeUpdate();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					default:
						
					break;
				}
					return partUpdate;
			}

			
			public static int partDelete() {
				Connection con = DBConnection.getConnection();
				int partDelete = 0;
				System.out.print("Enter Unit id : ");
				int partId = scan.nextInt();
				
				try {
					PreparedStatement ps =
							con.prepareStatement("DELETE FROM part WHERE part_Id = ?");
					ps.setInt(1, partId);
					
					partDelete = ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				return partDelete;
			}
			
			public static void partSelectByName() {
				Connection con = DBConnection.getConnection();
				System.out.println("which selection  : ");
				System.out.println("Press 1 for name : ");
				System.out.println("Press 2 for color : ");
				
				System.out.print("Enter Here : ");
				int key = scan.nextInt();
				
				if (key == 1 ) {
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select name from part");
					
					while(rs.next()) {
						System.out.println( rs.getString(1)+"\t");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}else {
					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("Select color from part");
						
						while(rs.next()) {
							System.out.println( rs.getString(1)+"\t");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
			}
			
			public static void partselectAll() {
				Connection con = DBConnection.getConnection();
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select * from part");
					
					//Unit table header.....
					
					ResultSetMetaData rsm = rs.getMetaData();
					for(int i =1; i<=rsm.getColumnCount(); i++) {
						System.out.print(rsm.getColumnName(i)+ "\t");
					}
					System.out.println();
					while(rs.next()) {
						System.out.print( rs.getInt(1)+" \t");
						System.out.print(rs.getString(2)+" \t");
						System.out.print(rs.getString(3)+" \t");
						System.out.print(rs.getInt(4));
						System.out.println();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//Order Table.....
			
			public static void orderTable() {
				out:
					while(true) {
				System.out.println("select option : ");
				System.out.println("Press 1 Fill Order Details");
				System.out.println("Press 2 Order Place ");
				System.out.println("Press 3 You Want to check particular order Details ");
				System.out.println("Press 0 for Exit ");
				
				System.out.print("Enter here : ");
				int key = scan.nextInt();
				
				
				switch (key) {
				case 1:
					System.out.println("insertion Success full = " + orderInsert());
					System.out.println("------------------------------------------");
					break;
				case 2:
					System.out.println("Order Success full Complete = " + orderPlace());
					System.out.println("------------------------------------------");
					break;
				case 3:
					orderDetails();
					System.out.println("------------------------------------------");
					break;
				case 0:
					break out;
				default:
				}
				}
				
				
}
			
			public static int orderInsert() {
				Connection con = DBConnection.getConnection();
				int orderPlace=0;
				System.out.print("Enter date : ");
				 String date = scan.next();
				System.out.print("Enter Part ID ");
				int partId = scan.nextInt();
				System.out.print("Enter quantity : "); 
				int quantity = scan.nextInt();
				
				
				 try {
					
					 PreparedStatement ps= 
										con.prepareStatement("INSERT INTO order1(`date`,`part_id`,`qty`) values(?,?,?)");
					
					ps.setString (1, date);
					ps.setInt(2, partId);
					ps.setInt(3, quantity);
			
					orderPlace = ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 return orderPlace;
				 
			}
			
			public static int orderPlace() {
				Connection con = DBConnection.getConnection();
				int orderPlace=0;
				
				System.out.print("Enter Part ID ");
				int partId = scan.nextInt();
				System.out.print("Enter quantity : "); 
				int quantity = scan.nextInt();
				
				
				 try {
					 PreparedStatement ps= 
								con.prepareStatement("UPDATE order1 SET qty = qty - ? WHERE part_id = ? ");
					 ps.setInt(1,  quantity);
					 ps.setInt(2, partId);
					 
					 orderPlace = ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 return orderPlace;
				 
			}
			
			public static void orderDetails() {
				
				System.out.print("Enter order ID ");
				int order_id = scan.nextInt();
				Connection con = DBConnection.getConnection();
				
				try{
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT ord.order_id , ord.date , part.name, ord.qty from order1 ord "
							+ "JOIN part on ord.part_id = part.part_id where order_id = " + order_id  );
					ResultSetMetaData rsm = rs.getMetaData();
					for(int i=1; i<=rsm.getColumnCount(); i++) {
						System.out.print(rsm.getColumnName(i)+"\t\t");
					}
					System.out.println();
					while(rs.next()) {
						System.out.print(rs.getInt(1)+"\t\t");
						System.out.print(rs.getString(2)+"\t\t");
						System.out.print(rs.getString(3)+"\t\t");
						System.out.print(rs.getInt(4));
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
}
