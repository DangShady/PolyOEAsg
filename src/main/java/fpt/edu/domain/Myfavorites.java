package fpt.edu.domain;

import java.util.Date;

public class Myfavorites {
	private String videoId;
	private String videoTitle;
	private Date likeDate;
	private String poster;
	private int views;
	private int favoriteId;
	
	
	public Myfavorites() {
		
	}


	public Myfavorites(String videoId, String videoTitle, Date likeDate, String poster, int views, int favoriteId) {
		super();
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.likeDate = likeDate;
		this.poster = poster;
		this.views = views;
		this.favoriteId = favoriteId;
	}

	public String getVideoId() {
		return videoId;
	}



	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}


	public Date getLikeDate() {
		return likeDate;
	}



	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}




	public String getPoster() {
		return poster;
	}




	public void setPoster(String poster) {
		this.poster = poster;
	}



	public int getViews() {
		return views;
	}



	public void setViews(int views) {
		this.views = views;
	}


	public int getFavoriteId() {
		return favoriteId;
	}


	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}






	
	
}
