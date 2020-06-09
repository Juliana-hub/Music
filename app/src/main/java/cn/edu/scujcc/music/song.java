package cn.edu.scujcc.music;

import java.util.Objects;

public class song {
    private static song INSTANCE =null;
    private String songId;
    private String songName;
    private String singer;
    private String status;
    private String url;

    private song(){};
    public static song getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new song();

        }
        return INSTANCE;

    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof song)) return false;
        song song = (song) o;
        return Objects.equals(songName, song.songName) &&
                Objects.equals(singer, song.singer) &&
                Objects.equals(status, song.status) &&
                Objects.equals(url, song.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, singer, status, url);
    }

    @Override
    public String toString() {
        return "song{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                ", status='" + status + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
