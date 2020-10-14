package com.example.musicalstructureapp;


public class MyList{

    private String songName;
    private String ArtistName;
    private int imag;
    public MyList( int imag , String songName, String ArtistName) {
        this.songName = songName;
        this.ArtistName = ArtistName;
        this.imag= imag;
    }
    public String getsongName() {
        return songName;
    }
    public void setimag(int imag) {
        this.imag = imag;
    }
    public int getimag() {
        return imag;
    }
    public void setsongName(String songName) {
        this.songName = songName;
    }
    public String getArtistName() {
        return ArtistName;
    }
    public void setImgId(String ArtistName) {
        this.ArtistName = ArtistName;
    }
}