package fpt.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fpt.edu.domain.FavoriteReport;
import fpt.edu.domain.FavoriteUserReport;
import fpt.edu.domain.Myfavorites;
import fpt.edu.model.Favorite;

public class FavoriteDAO extends AbstractEntityDAO<Favorite> {

	public FavoriteDAO() {
		super(Favorite.class);

	}
	
	public List<Myfavorites> MyfavoriteVideo(String username){
		String jpql = "select new fpt.edu.domain.Myfavorites(f.video.videoId, f.video.title, f.likedDate, f.video.poster, f.video.views, f.favoriteId)"
				+ " from Favorite f where f.user.username = :username";
		
		EntityManager em = JpaUtils.getEntityManager();
		
		List<Myfavorites> list = null;
		
		try {
			TypedQuery<Myfavorites> query = em.createQuery(jpql, Myfavorites.class);
			
			query.setParameter("username", username);
			list = query.getResultList();
		} finally {
			em.close();
		}
		
		return list;
	}
	
	public List<FavoriteReport> reportFavoritesByVideos(){
		String jpql = "select new fpt.edu.domain.FavoriteReport(f.video.title, count(f), min(f.likedDate), max(f.likedDate)) from Favorite f group by f.video.title ";
		
		EntityManager em = JpaUtils.getEntityManager();
		
		List<FavoriteReport> list = null;
		
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			
			list = query.getResultList();
		} finally {
			em.close();
		}
		
		return list;
	}

	public List<FavoriteUserReport> reportFavoriteUserByVideo(String videoId) {

		String jpql = "select new fpt.edu.domain.FavoriteUserReport(f.user.username, f.user.fullname, f.user.email, f.likedDate) from Favorite f where f.video.videoId = :videoId";
		
		EntityManager em = JpaUtils.getEntityManager();
		
		List<FavoriteUserReport> list = null;
		
		try {
			TypedQuery<FavoriteUserReport> query =  em.createQuery(jpql, FavoriteUserReport.class);
			
			query.setParameter("videoId", videoId);
			
			list = query.getResultList();
		} catch (Exception e) {
			em.close();
		}
		return list;

	}
}
