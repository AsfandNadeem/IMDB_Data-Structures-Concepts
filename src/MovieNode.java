

public class MovieNode {

	String colour, num_Ciritic_fot_Reviews, duration, gross, genre, title, num_voted_users, cast_total_fb_likes,
			face_num_in_posters, plot_keywords, imdb_Link, num_user_for_reviews, language, country, content_rating,
			buget, year, imdb_score, aspect_ratio, movie_fb_likes;

	MovieActorList MA;// Linkedlist of actors of a certain movie
	DirectorNode MD;// Referencing a director node containing the director of
					// the movie

	public MovieNode(String colour, String num_Ciritic_fot_Reviews, String duration, String gross, String genre,
			String title, String num_voted_users, String cast_total_fb_likes, String face_num_in_posters,
			String plot_keywords, String imdb_Link, String num_user_for_reviews, String language, String country,
			String content_rating, String buget, String year, String imdb_score, String aspect_ratio,
			String movie_fb_likes, MovieActorList mA, DirectorNode mD) {//constructor
		super();
		this.colour = colour;
		this.num_Ciritic_fot_Reviews = num_Ciritic_fot_Reviews;
		this.duration = duration;
		this.gross = gross;
		this.genre = genre;
		this.title = title;
		this.num_voted_users = num_voted_users;
		this.cast_total_fb_likes = cast_total_fb_likes;
		this.face_num_in_posters = face_num_in_posters;
		this.plot_keywords = plot_keywords;
		this.imdb_Link = imdb_Link;
		this.num_user_for_reviews = num_user_for_reviews;
		this.language = language;
		this.country = country;
		this.content_rating = content_rating;
		this.buget = buget;
		this.year = year;
		this.imdb_score = imdb_score;
		this.aspect_ratio = aspect_ratio;
		this.movie_fb_likes = movie_fb_likes;
		MA = mA;
		MD = mD;
	}

}
