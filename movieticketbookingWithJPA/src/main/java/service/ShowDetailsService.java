package service;

import dao.ShowDetailsDao;
import daoImpl.ShowDetailsDaoImpl;

public class ShowDetailsService {
	
	ShowDetailsDao showDetailsDao = new ShowDetailsDaoImpl();
	
	public int getShowId(int theatreId,String date,String time)
	{
		return showDetailsDao.getShowId(theatreId, date, time);
	}

}
