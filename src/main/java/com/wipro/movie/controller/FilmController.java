package com.wipro.movie.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.movie.DemoprojectApplication;
import com.wipro.movie.Exception.FilmException;
import com.wipro.movie.bean.Film;
import com.wipro.movie.bean.Music;
import com.wipro.movie.bean.User;
import com.wipro.movie.repository.FilmRepository;
import com.wipro.movie.repository.MusicRepository;
import com.wipro.movie.repository.UserRepository;

@Controller
public class FilmController {

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MusicRepository musicRepository;

	private final Integer timeout = 30 * 60;

	private static Logger logger = Logger.getLogger(DemoprojectApplication.class.getName());

	@RequestMapping(value="/home")
	public String home() {
		return "home";
	}

	@RequestMapping(value="/film")
	public String film() {
		return "film";
	}

	@RequestMapping(value="/music")
	public String music() {
		return "music";
	}

	
	//--------------list film------------------------
	@RequestMapping(value="/filmindex")
	public String filmindex(Model model) {
		List<Film> list = (List<Film>) filmRepository.findAll();
		model.addAttribute("list",list);
		return "filmindex";
	}

	//--------------list music------------------------
	@RequestMapping(value="/musicindex")
	public String musicindex(Model model) {
		List<Music> list = (List<Music>) musicRepository.findAll();
		model.addAttribute("list",list);
		return "musicindex";
	}

	//------------------modify film-------------------------
	@RequestMapping(value="/film/expand")
	public String filmexpand(Model model) {

			List<Film> list = (List<Film>) filmRepository.findAll();
			model.addAttribute("list", list);
			return "filmexpand";
	}

	//------------------modify music-------------------------
	@RequestMapping(value="/music/expand")
	public String musicexpand(Model model) {

		List<Music> list = (List<Music>) musicRepository.findAll();
		model.addAttribute("list",list);
		return "musicexpand";
	}


	//--------------edit film----------------------------
	@GetMapping(value="/film/edit/{id}")
	public String editfilm(@PathVariable String id,Model model) {
		Film film = filmRepository.findOne(id);
		model.addAttribute("film",film);
		return "editfilm";
	}

	//--------------edit music----------------------------
	@GetMapping(value="/music/edit/{id}")
	public String editmusic(@PathVariable String id,Model model) {
		Music music = musicRepository.findOne(id);
		model.addAttribute("music",music);
		return "editmusic";
	}

	//---------------update film-----------------------------
	@PostMapping(value="/film/edit/update/{id}")
	public String updatefilm(@PathVariable String id,@RequestParam String filmid,@RequestParam String filmname,@RequestParam String language,@RequestParam int budget,Model model) {
		Film film = new Film();
		film.setFilmid(id);
		film.setFilmname(filmname);
		film.setLanguage(language);
		film.setBudget(budget);
		filmRepository.save(film);
		model.addAttribute("film",film);
		return "update";
	}

	//---------------update music------------------------------
	@PostMapping(value="/music/edit/update/{id}")
	public String updatemusic(@PathVariable String id,@RequestParam String musicid,@RequestParam String musicname,@RequestParam String filmname,@RequestParam String filmlanguage,Model model) {
		Music music = new Music();
		music.setMusicid(id);
		music.setMusicname(musicname);
		music.setFilmname(filmname);
		music.setFilmlanguage(filmlanguage);
		musicRepository.save(music);
		model.addAttribute("music",music);
		return "update";
	}

	//-----------delete film-------------------------------------
	@RequestMapping(value="/film/delete/{id}")
	public String delete(@PathVariable String id) {
		filmRepository.delete(id);
		return "update";
	}

	//-----------delete music-------------------------------------
	@RequestMapping(value="/music/delete/{id}")
	public String deletemusic(@PathVariable String id) {
		musicRepository.delete(id);
		return "update";
	}

	//-----------------------new film------------------------------
	@RequestMapping(value="/filmnew")
	public String addNewFilm() {
		return "filmnew";
	}

	//-----------------------new music------------------------------
	@RequestMapping(value="/musicnew")
	public String addNewMusic() {
		return "musicnew";
	}

	//-----------------------film new post mapping-------------------
	@PostMapping(value="/filmnew")
	public String newFilm(@RequestParam String filmid,@RequestParam String filmname,@RequestParam String language,@RequestParam int budget,Model model) {
		Film film = new Film();
		film.setFilmid(filmid);
		film.setFilmname(filmname);
		film.setLanguage(language);
		film.setBudget(budget);
		filmRepository.save(film);
		model.addAttribute("film",film);
		return "update";
	}

	//----------------------music new post mapping------------------------
	@PostMapping(value="/musicnew")
	public String newFilm(@RequestParam String musicid,@RequestParam String musicname,@RequestParam String filmname,@RequestParam String filmlanguage,Model model) {
		Music music = new Music();
		music.setMusicid(musicid);
		music.setMusicname(musicname);
		music.setFilmname(filmname);
		music.setFilmlanguage(filmlanguage);
		musicRepository.save(music);
		model.addAttribute("music",music);
		return "update";
	}
	
	@GetMapping(value="/")
	public String loginNew() {
		 return "login";
	       	}
	
	@PostMapping(value="/login")
	public String login(@RequestParam String username,@RequestParam String password,Model model,HttpServletRequest request,HttpServletResponse response) {
		User user = new User();
		user=userRepository.findOne(username);

			try {
				byte[] decodedBytes = Base64.getDecoder().decode(user.getToken());
				String decodeToken = username+""+password;
				String userSession = request.getParameter("username");
				if(userSession.equals(username)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
				}
				if(user.getUsername().equals(username)&& user.getPassword().equals(password) && decodeToken.equals(new String(decodedBytes))){
					//System.out.println("login");
					return "home";
				}
				else {
					return "error";

				}
			}catch (Exception e) {
				HttpSession session = request.getSession();
				session.invalidate();
				return "login";
			}


	}
	
	
	@GetMapping(value="/sign")
	public String sign() {
		return "signup";
	}
	
	
	@PostMapping(value="/signup")
	public String signup(@RequestParam String username,@RequestParam String password,Model model) {
		User user = new User();
		try {
			user.setUsername(username);
			user.setPassword(password);
			String encode = username + "" + password;
			byte[] encodedBytes = Base64.getEncoder().encode(encode.getBytes());
			//System.out.println("encodedBytes " + new String(encodedBytes));
			//String token=encodedBytes.toString();
			user.setToken(new String(encodedBytes));
			if(user.getUsername()==null || user.getPassword()==null || user.getToken()==null) {
				throw new FilmException();
			}
		}
		catch (FilmException e) {
			logger.error(e);
		}
		finally {
			userRepository.save(user);
			return "login";
		}


	}
	
	@GetMapping(value="/logoutsuccess")
	public String logoutsuccess() {
		return "logoutsuccess";
	}
	
	
	@GetMapping(value="/logout")
	public void logout(HttpServletResponse response,HttpServletRequest request) {
		try {
		HttpSession session = request.getSession();
		session.invalidate();
			response.sendRedirect("/logoutsuccess");

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

	}
	
}
