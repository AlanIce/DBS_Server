package priv.dbs.service;

import com.google.gson.Gson;

import priv.dbs.dao.APIDao;
import priv.dbs.model.Movie;

public class APIService {
	private APIDao apiDao;
	
	private Gson gson;
	
	public APIService() {
		System.out.println("APIService Init...");
		gson = new Gson();
	}
	
	public String getMovie(int id) {
		Movie movie = apiDao.getMovie(id);
		if (movie == null) 
			return "{\"result\":\"fail\", \"msg\":\"no such a movie\"}";

		String json = "{\"result\":\"success\", \"data\":";
		String movieJson = gson.toJson(movie);
		json += (movieJson + "}");
		return json;
	}

	public APIDao getApiDao() {
		return apiDao;
	}

	public void setApiDao(APIDao apiDao) {
		this.apiDao = apiDao;
	}
	
}
