package ua.newhouses.club.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.newhouses.club.db.DBmanager;
import ua.newhouses.club.dto.CarDTO;


public class CarDAO {
	
	private static final String GET_CAR_BY_ID = "Select * from car WHERE member_id = ?";
	
	public static ArrayList<CarDTO> getCars(String id) {
    	ArrayList<CarDTO> carList = new ArrayList<CarDTO>();
    	
    	Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps  = null;
    	
    	try {
    		conn = DBmanager.getConnection();
			ps = conn.prepareStatement(GET_CAR_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
			while (rs.next()) {
				CarDTO cars = new CarDTO();
				cars.setId(rs.getLong("member_id"));
				cars.setBrand(rs.getString("brand"));
				cars.setModel(rs.getString("model"));
				cars.setEngine(rs.getString("engine"));
				cars.setYear(rs.getString("year"));
				carList.add(cars);
			}
		} catch (SQLException ex) {
							
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
				
			}
		}
    	return carList;
    }
	
}
