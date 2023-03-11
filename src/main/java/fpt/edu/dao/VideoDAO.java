package fpt.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fpt.edu.model.Video;

public class VideoDAO extends AbstractEntityDAO<Video> {

	public VideoDAO() {
		super(Video.class);

	}

	public List<Video> findAllVideoByTitle(String keyword) {
		String jpql = "select v from Video v where v.title like :keyword";

		EntityManager em = JpaUtils.getEntityManager();
		List<Video> list = null;

		try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);

			query.setParameter("keyword", "%" + keyword + "%");
			list = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			em.close();
		}
		return list;
	}

	public Long countVideo() {
		String jpql = "select count(v.videoId) from Video v";

		EntityManager em = JpaUtils.getEntityManager();

		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		return query.getSingleResult();
		
	}
	
	public List<Video> fillVideoInPage(int index){
		String jpql = "select * from Videos order by videoId offset ? rows fetch next 8 rows only";
		EntityManager em = JpaUtils.getEntityManager();
		
		Query query = em.createNativeQuery(jpql, Video.class);
		query.setParameter(1, (index-1)*8);
		List<Video> list = query.getResultList();
		
		return list;
	}
}
