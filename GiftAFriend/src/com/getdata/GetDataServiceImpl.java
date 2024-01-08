package com.getdata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetDataServiceImpl {
	
	public ArrayList<SecretSanta> getNamesWithNoToFriend(){	
		 ArrayList<SecretSanta> listWithNoToFriend = new ArrayList<>(); 
		 try(Connection connection = ConnectionJDBC.getConnection()) {                                     
            
	            // Prepare SQL. 
	            String query = ("SELECT * " + 
	                            "FROM testsanta where ToName is null");  
	             
	            // Set prepared statement. 
	            PreparedStatement ps = connection.prepareStatement(query);  
	            
	            // Execute SQL. 
	            ResultSet rs = ps.executeQuery();                                                           
	             
	            // Get data from database. 
	          
	            while (rs.next()) {   
	            	SecretSanta person = new SecretSanta(); 
	                person.setPersonId(rs.getInt("PersonId")); 
	                person.setFromName(rs.getString("FromName"));
	                person.setToName(rs.getString("ToName"));
	                listWithNoToFriend.add(person);
	            }	           
			}         
	        catch(SQLException ex) {             
	            ex.printStackTrace();   
	        } 
		 return listWithNoToFriend;
	    }
	
	public ArrayList<SecretSanta> getNamesWithNoFromFriend(){
		ArrayList<SecretSanta> listWithNoFromFriend = new ArrayList<>(); 
		 try(Connection connection = ConnectionJDBC.getConnection()) {                                     
           
	            // Prepare SQL. 
	            String query = ("SELECT * " + 
	                            "FROM testsanta where FromName not in (select distinct ToName from testsanta  where ToName is not null)");  
	             
	            // Set prepared statement. 
	            PreparedStatement ps = connection.prepareStatement(query);  
	            
	            // Execute SQL. 
	            ResultSet rs = ps.executeQuery();                                                           
	             
	            // Get data from database. 
	          
	            while (rs.next()) {   
	            	SecretSanta person = new SecretSanta(); 
	                person.setPersonId(rs.getInt("PersonId")); 
	                person.setFromName(rs.getString("FromName"));
	                //person.setToName(rs.getString("ToName"));
	                listWithNoFromFriend.add(person);
	            }	           
			}         
	        catch(SQLException ex) {             
	            ex.printStackTrace();   
	        } 
		 return listWithNoFromFriend;
	}

	public SecretSanta getRandomElement(List<SecretSanta> list, String fromFriendName)
	    {
		 SecretSanta ToFriend=new SecretSanta();   
		 Random rand = new Random();
	   for(int i=0;i<list.size();i++){
	     int randomIndex = rand.nextInt(list.size());
	     ToFriend=list.get(randomIndex);
	     if(!(fromFriendName.equals(ToFriend.getFromName().toLowerCase()))){
	    	 return ToFriend;
	     }
	   }   
	   return ToFriend;  
	 }
    
	public boolean updateToName(String fromName,String ToName){
		try(Connection connection = ConnectionJDBC.getConnection()) {                                     
            
            // Prepare SQL. 
            String query = ("update testSanta set ToName=? where FromName=?");  
             
            // Set prepared statement. 
            PreparedStatement ps = connection.prepareStatement(query);  
            ps.setString(1, ToName);
            ps.setString(2, fromName);
            // Execute SQL. 
            ps.executeUpdate(); 
            connection.setAutoCommit(false);
            connection.commit();
            return true; 
	}catch(SQLException ex) {             
            ex.printStackTrace();   
            return false; 
        }
		
	}
    
	public String getFriend(String fromName){
		try(Connection connection = ConnectionJDBC.getConnection()) {                                     
            
            // Prepare SQL. 
            String query = ("SELECT ToName " + 
                            "FROM testSanta where FromName like ? ");  
             
            // Set prepared statement. 
            PreparedStatement ps = connection.prepareStatement(query);  
            ps.setString(1, fromName);
            // Execute SQL. 
            ResultSet rs = ps.executeQuery();                                                           
             
            // Get data from database.          
            while (rs.next()) {            	
                return rs.getString("ToName");
            }	           
		}         
        catch(SQLException ex) {             
            ex.printStackTrace();   
        }
		return null;
	}
}
