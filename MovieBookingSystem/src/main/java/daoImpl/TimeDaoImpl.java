package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dao.TimeDao;
import dto.TimeDto;
import utilities.ConnectionFactory;

public class TimeDaoImpl implements TimeDao {

	public ArrayList<TimeDto> getTime() {
		
		ArrayList<TimeDto> times = new ArrayList<TimeDto>();
		String sqlQuery = "select time from showtiming";

		try {
			Statement st = ConnectionFactory.getconnection().createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			while(rs.next()) 
			{
				TimeDto timeDto = new TimeDto();
				timeDto.setTime(rs.getString("time"));
				times.add(timeDto);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return times;
	}
}
