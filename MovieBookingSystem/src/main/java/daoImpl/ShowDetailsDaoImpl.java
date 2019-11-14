package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dao.ShowDetailsDao;
import utilities.ConnectionFactory;

public class ShowDetailsDaoImpl implements ShowDetailsDao {

	public int getShowId(int theatreId, String date, String time) {

		String selectQuery = "SELECT showId FROM showdetails where theatreId=" + theatreId + " and " + "date='" + date
				+ "' and time='" + time + "'";
		int showId = 0;
		try {

			Statement st = ConnectionFactory.getconnection().createStatement();
			ResultSet rs = st.executeQuery(selectQuery);
			if (!(rs.next()))
				{
				ShowDetailsDaoImpl obj = new ShowDetailsDaoImpl();
				obj.setShowId(theatreId, date, time);
				}
			ResultSet rs1 = st.executeQuery(selectQuery);
			while(rs1.next())
				showId  = rs1.getInt("showId");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return showId;
	}

	private void setShowId(int theatreId, String date, String time) {
		
		String insertQuery = "insert into showdetails (theatreId,date,time) values (" + theatreId + ",'" + date + "','"
				+ time + "')";
		try {
			PreparedStatement ps = ConnectionFactory.getconnection().prepareStatement(insertQuery);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
