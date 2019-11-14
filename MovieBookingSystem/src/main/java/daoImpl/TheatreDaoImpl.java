package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dao.TheatreDao;
import dto.TheatreDto;
import utilities.ConnectionFactory;

public class TheatreDaoImpl implements TheatreDao {
	
	public int getTheatreId(String theatreName)
	{
		String theatreIdQuery = "SELECT TheatreID from theatredetails where TheatreName='"+theatreName+"'";
		int theatreId = 0;
		try {
			Statement st = ConnectionFactory.getconnection().createStatement();
			ResultSet rs = st.executeQuery(theatreIdQuery);
			while(rs.next())
				 theatreId = rs.getInt("TheatreId");
			} 
		
		catch (SQLException e) {			
			e.printStackTrace();
		}
		return theatreId;
	}
	
	
	public ArrayList<TheatreDto> theatreByMovie(String locationChoice, String movieChoice)
	{
		String theatreByChoice = "SELECT TheatreName from theatredetails where LocationID in"
				+ " (select LocationID from locationdetails where LocationName='"+locationChoice+"') and TheatreID in "
				+ "(select TheatreID from moviedetails where MovieName='"+movieChoice+"')";
		ArrayList<TheatreDto> theatreList = new ArrayList<TheatreDto>();
		try {
			Statement st = ConnectionFactory.getconnection().createStatement();
			ResultSet rs = st.executeQuery(theatreByChoice);
			while(rs.next())
				{
				TheatreDto theatre = new TheatreDto();
				theatre.setTheatreName(rs.getString("TheatreName"));
				theatreList.add(theatre);
				}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return theatreList;
	}
	
}

