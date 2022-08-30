package com.deshayes.gestiondestock.exception;

public enum ErrorCodes {

    ARTICLES_NOT_FOUND(1000),
    ARTICLES_NOT_VALID(1000),
    CATEGORY_NOT_FOUND(2000),
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT__NOT_FOUND(4000),
    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),
    ENTREPRISE_NOT_FOUND(6000),
    FOURNISSUER_NOT_FOUND(7000),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_VENTE_NOT_FOUND(10000),
    MVT_NOT_FOUND(11000),
    ;


    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
