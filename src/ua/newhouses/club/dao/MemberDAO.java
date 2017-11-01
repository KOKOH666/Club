package ua.newhouses.club.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import ua.newhouses.club.db.DBmanager;
import ua.newhouses.club.dto.MemberDTO;

public class MemberDAO {
	
	private static Logger log = Logger.getLogger(MemberDAO.class);
	private static final String GET_ALL_MEMBERS = "select * from member order by name";
	private static final String GET_MEMBER_BY_ID = "Select * from member WHERE ID = ?";
	private static final String DELETE_MEMBER_BY_ID = "delete from users where uname=?";
	private static final String ADD_MEMBER = "insert into users(name, sname, email, password, registeredon) values (?, ?, ?, ?, ? )";
	private static final String UPDATE_MEMBER = "update users set password=?, email=?, registeredon=?\"\r\n" + 
			"                    + \"where uname=?";
	private static Connection conn;
	
	public static MemberDTO getMemberById(String id) {
		log.debug("Get member by id: "+ id +" - method started");
		MemberDTO member = new MemberDTO();
    	
    	Statement stmt = null;
    	ResultSet rs = null;
    	Connection conn = null;
    	PreparedStatement ps  = null;
		
		try {
			conn = DBmanager.getConnection();
			ps = conn.prepareStatement(GET_MEMBER_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
			while (rs.next()) {
				
				member.setName(rs.getString("name"));
				member.setId(rs.getLong("id"));
				member.setSname(rs.getString("sname"));
				member.setDate(rs.getString("date"));
				member.setAboutme(rs.getString("aboutme"));
				
				member.setCars(CarDAO.getCars(rs.getString("id")));
				}
			
			System.getProperty("console.encoding","Cp1251");
			log.debug(member.toString());
		} catch (SQLException ex) {
			log.error("Get member by id: "+id+" "+ex.getMessage()+" - error message");
		} finally {
			
			try {
				if(stmt!= null) {
					stmt.close();
				}
				if (rs!=null) {
					rs.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException ex) {
				log.error("Get member by id: "+id+" "+ex.getMessage()+" - error message");
			}
		}
		log.debug("Get member by id: "+id+" - method finished");
		log.info("Get member by id: "+id+" - method over");
		 return member;
		 
    }
    
	public static ArrayList<MemberDTO> getAllMembers() {
		log.debug("Get all members - method started");
    	ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
    	
    	 
    	Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			conn = DBmanager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(GET_ALL_MEMBERS);
			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setName(rs.getString("name"));
				member.setId(rs.getLong("id"));
				member.setSname(rs.getString("sname"));
				member.setDate(rs.getString("date"));
				member.setAboutme(rs.getString("aboutme"));
				
				member.setCars(CarDAO.getCars(rs.getString("id")));
	
				memberList.add(member);
				
				
			}
			
		} catch (SQLException ex) {
			log.error("Get all members - error message");
		} finally {
		
			try {
				if(stmt!= null) {
					stmt.close();
				}
				if (rs!=null) {
					rs.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException ex) {
			log.error("Get all members - error message");
			}
		}
		log.debug("Get all members - method finished");
		log.info("Get all members - method over");
        return memberList;
    }	
	
	
	 public static void deleteUser(String x) {
	
			Connection conn = null;
			
			try {
	        	conn = DBmanager.getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_MEMBER_BY_ID);
	            preparedStatement.setString(1, x);
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	 public static void addUser(MemberDTO member) {
		  
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement(ADD_MEMBER);
	            // Parameters start with 1
	            preparedStatement.setString(1, member.getName());
	            preparedStatement.setString(2, member.getSname());
	            preparedStatement.setString(3, member.getEmail());            
	            preparedStatement.setDate(4, new java.sql.Date(member.getRegisteredon().getTime()));
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	  public static void updateUser(MemberDTO member) {
		   
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MEMBER);
	                
	            // Parameters start with 1
	            System.out.println(new java.sql.Date(member.getRegisteredon().getTime()));
	            preparedStatement.setString(1, member.getPassword());
	            preparedStatement.setString(2, member.getEmail());
	            preparedStatement.setDate(3, new java.sql.Date(member.getRegisteredon().getTime()));
	            preparedStatement.setString(4, member.getName());
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
