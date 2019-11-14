package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dto.LocationDto;
import dao.LocationDao;
import utilities.ConnectionFactory;

public class LocationDaoImpl implements LocationDao{
	
	String selectQuery = "select LocationName  from locationdetails";
	
	public ArrayList<LocationDto> getLocation()
	{
		ArrayList<LocationDto> locations = new ArrayList<LocationDto>();
		
		try {
			Statement st = ConnectionFactory.getconnection().createStatement();
			ResultSet rs = st.executeQuery(selectQuery);
			while(rs.next())
			{
				LocationDto locationDto = new LocationDto();
				locationDto.setLocationName(rs.getString("LocationName"));
				locations.add(locationDto);
			}
				
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return locations;
	}
	
}
