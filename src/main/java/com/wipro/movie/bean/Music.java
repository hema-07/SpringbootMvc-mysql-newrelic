package com.wipro.movie.bean;

/**
 * Created by HE351544 on 11/9/2017.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="music")
public class Music {

    @Id
    @Column(name="musicid")
    private String musicid;

    @Column(name="musicname")
    private String musicname;

    @Column(name="filmname")
    private String filmname;

    @Column(name="filmlanguage")
    private String filmlanguage;

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public String getFilmlanguage() {
        return filmlanguage;
    }

    public void setFilmlanguage(String filmlanguage) {
        this.filmlanguage = filmlanguage;
    }

    public Music() {}

}
