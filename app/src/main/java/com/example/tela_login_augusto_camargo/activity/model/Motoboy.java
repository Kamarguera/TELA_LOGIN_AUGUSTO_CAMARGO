package com.example.tela_login_augusto_camargo.activity.model;

public class Motoboy {

    private String contatoMotoboy, nomeMotoboy;
    private String avaliacaoMotoboy;



    public Motoboy(String contatoMotoboy, String nomeMotoboy, String avaliacaoMotoboy) {
        this.contatoMotoboy = contatoMotoboy;
        this.nomeMotoboy = nomeMotoboy;
        this.avaliacaoMotoboy = avaliacaoMotoboy;
    }




    public String getContatoMotoboy() {
        return contatoMotoboy;
    }

    public void setContatoMotoboy(String contatoMotoboy) {
        this.contatoMotoboy = contatoMotoboy;
    }

    public String getNomeMotoboy() {
        return nomeMotoboy;
    }

    public void setNomeMotoboy(String nomeMotoboy) {
        this.nomeMotoboy = nomeMotoboy;
    }

    public String getAvaliacaoMotoboy() {
        return avaliacaoMotoboy;
    }

    public void setAvaliacaoMotoboy(String avaliacaoMotoboy) {
        this.avaliacaoMotoboy = avaliacaoMotoboy;
    }

}
