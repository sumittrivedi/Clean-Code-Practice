package dao;

import java.util.List;

public interface MovieDao {
	
	List<String> movieByLocation(String locationChoice);
}
