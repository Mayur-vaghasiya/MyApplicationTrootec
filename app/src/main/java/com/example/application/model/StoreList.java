package com.example.application.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class StoreList implements Serializable {
    @SerializedName("franquicias")
    @Expose
    private ArrayList<Franquicia> franquicias = null;

    public ArrayList<Franquicia> getFranquicias() {
        return franquicias;
    }

    public void setFranquicias(ArrayList<Franquicia> franquicias) {
        this.franquicias = franquicias;
    }

    public class Franquicia {

        @SerializedName("APIKEY")
        @Expose
        private String aPIKEY;
        @SerializedName("tokenInvu")
        @Expose
        private String tokenInvu;
        @SerializedName("negocio")
        @Expose
        private String negocio;
        @SerializedName("principal")
        @Expose
        private Boolean principal;
        @SerializedName("id_franquicia")
        @Expose
        private String idFranquicia;
        @SerializedName("franquicia")
        @Expose
        private String franquicia;
        @SerializedName("horaCierreLocal")
        @Expose
        private String horaCierreLocal;

        public String getAPIKEY() {
            return aPIKEY;
        }

        public void setAPIKEY(String aPIKEY) {
            this.aPIKEY = aPIKEY;
        }

        public String getTokenInvu() {
            return tokenInvu;
        }

        public void setTokenInvu(String tokenInvu) {
            this.tokenInvu = tokenInvu;
        }

        public String getNegocio() {
            return negocio;
        }

        public void setNegocio(String negocio) {
            this.negocio = negocio;
        }

        public Boolean getPrincipal() {
            return principal;
        }

        public void setPrincipal(Boolean principal) {
            this.principal = principal;
        }

        public String getIdFranquicia() {
            return idFranquicia;
        }

        public void setIdFranquicia(String idFranquicia) {
            this.idFranquicia = idFranquicia;
        }

        public String getFranquicia() {
            return franquicia;
        }

        public void setFranquicia(String franquicia) {
            this.franquicia = franquicia;
        }

        public String getHoraCierreLocal() {
            return horaCierreLocal;
        }

        public void setHoraCierreLocal(String horaCierreLocal) {
            this.horaCierreLocal = horaCierreLocal;
        }
    }
}
