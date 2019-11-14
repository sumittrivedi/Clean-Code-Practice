package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AvailableSeatDao;
import dto.AvailableSeatDto;
import utilities.ConnectionFactory;

public class AvailableSeatDaoImpl implements AvailableSeatDao {

	@Override
	public void updateAvailableSeat(AvailableSeatDto dto, int premiumSeatChoice, int executiveSeatChoice) {

		int showId = dto.getShowId();

		String query = "update availableseatdetails set PremiumAvailability=PremiumAvailability-" + premiumSeatChoice
				+ " , ExecutiveAvailabilty =ExecutiveAvailabilty-" + executiveSeatChoice + " where showId =" + showId
				+ "";

		try {
			PreparedStatement ps = ConnectionFactory.getconnection().prepareStatement(query);
			ps.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void setAvailableSeat(int showId) {

		int premiumSeats = 20;
		int executiveSeats = 80;
		String insertAvlSeats = "insert into availableseatdetails (showId,PremiumAvailability,ExecutiveAvailabilty) values ("
				+ showId + "," + premiumSeats + "," + executiveSeats + ")";
		try {
			PreparedStatement ps = ConnectionFactory.getconnection().prepareStatement(insertAvlSeats);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public AvailableSeatDto getAvailableSeat(int showId) {
		AvailableSeatDto availableSeatDto = new AvailableSeatDto();
		String selectQuery = "SELECT * FROM availableseatdetails where showId=" + showId + "";

		try {
			Statement st = ConnectionFactory.getconnection().createStatement();
			ResultSet rs = st.executeQuery(selectQuery);
			if (!(rs.next()))
				new AvailableSeatDaoImpl().setAvailableSeat(showId);
			ResultSet rs1 = st.executeQuery(selectQuery);
			while(rs1.next())
			{
			availableSeatDto.setShowId(rs1.getInt("showId"));
			availableSeatDto.setExecutiveAvailabilty(rs1.getInt("ExecutiveAvailabilty"));
			availableSeatDto.setPremiumAvailability(rs1.getInt("PremiumAvailability"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return availableSeatDto;

	}

}
