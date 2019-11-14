package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dao.MovieDao;
import dto.MovieDto;
import utilities.ConnectionFactory;

public class MovieDaoImpl implements MovieDao {

	
	public ArrayList<MovieDto> movieByLocation(String locationChoice)
	{
		ArrayList<MovieDto> arr = new ArrayList<MovieDto>();
		String movieByLocation = "select distinct MovieName from moviedetails where moviedetails.TheatreID IN (select TheatreID from theatredetails where theatredetails.LocationId IN (select LocationId from locationdetails where locationdetails.LocationName='"+locationChoice+"'));";
		
		try {
			Statement st = ConnectionFactory.getconnection().createStatement();
			ResultSet rs = st.executeQuery(movieByLocation);
			while(rs.next())
			{
				MovieDto movieDto = new MovieDto();
				movieDto.setMovieName(rs.getString("MovieName"));
				arr.add(movieDto);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return arr;
	}
	
	
	
}