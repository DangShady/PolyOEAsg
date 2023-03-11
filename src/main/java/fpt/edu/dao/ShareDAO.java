package fpt.edu.dao;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fpt.edu.domain.ShareFriends;
import fpt.edu.model.Share;


public class ShareDAO extends AbstractEntityDAO<Share>{

	public ShareDAO() {
		super(Share.class);
		
	}

	public List<ShareFriends> reportFavoriteUserByVideo(String videoId) {

		String jpql = "select new fpt.edu.domain.FavoriteUserReport(f.user.username, f.user.fullname, f.user.email, f.likedDate) from Favorite f where f.video.videoId = :videoId";
		
		EntityManager em = JpaUtils.getEntityManager();
		
		List<ShareFriends> list = null;
		
		try {
			TypedQuery<ShareFriends> query =  em.createQuery(jpql, ShareFriends.class);
			
			query.setParameter("videoId", videoId);
			
			list = query.getResultList();
		} catch (Exception e) {
			em.close();
		}
		return list;

	}
}

