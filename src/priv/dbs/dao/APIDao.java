package priv.dbs.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import priv.dbs.model.Movie;

public class APIDao extends HibernateDaoSupport {
	
	public Movie getMovie(int ID) {
		String hql = "FROM Movie WHERE id=" + ID;
		List<Movie> movies = (List<Movie>) getHibernateTemplate().find(hql);
		if (movies.size() == 0) return null;
		return movies.get(0);
	}
}