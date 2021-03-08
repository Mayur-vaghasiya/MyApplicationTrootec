package com.example.application.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryList implements Serializable {

    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;
    private final static long serialVersionUID = 5110255170666203939L;

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public class Datum implements Serializable {

        @SerializedName("modificadores")
        @Expose
        private ArrayList<Modificadore> modificadores = null;
        @SerializedName("idmenu")
        @Expose
        private String idmenu;
        @SerializedName("precioSugerido")
        @Expose
        private String precioSugerido;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("imagen")
        @Expose
        private String imagen;
        @SerializedName("codigo")
        @Expose
        private String codigo;
        @SerializedName("impuesto")
        @Expose
        private Integer impuesto;
        @SerializedName("codigoBarra")
        @Expose
        private String codigoBarra;
        @SerializedName("precio_abierto")
        @Expose
        private Boolean precioAbierto;
        @SerializedName("comision")
        @Expose
        private String comision;
        @SerializedName("tipo_comision")
        @Expose
        private String tipoComision;
        @SerializedName("descTipoComision")
        @Expose
        private String descTipoComision;
        @SerializedName("impuestoAplicado")
        @Expose
        private Boolean impuestoAplicado;
        @SerializedName("tipo")
        @Expose
        private String tipo;
        @SerializedName("tipo_desc")
        @Expose
        private String tipoDesc;
        @SerializedName("descripcion")
        @Expose
        private Object descripcion;
        @SerializedName("permite_descuentos")
        @Expose
        private Boolean permiteDescuentos;
        @SerializedName("categoria")
        @Expose
        private Categoria categoria;
        private final static long serialVersionUID = -8226005410621733303L;

        public ArrayList<Modificadore> getModificadores() {
            return modificadores;
        }

        public void setModificadores(ArrayList<Modificadore> modificadores) {
            this.modificadores = modificadores;
        }

        public String getIdmenu() {
            return idmenu;
        }

        public void setIdmenu(String idmenu) {
            this.idmenu = idmenu;
        }

        public String getPrecioSugerido() {
            return precioSugerido;
        }

        public void setPrecioSugerido(String precioSugerido) {
            this.precioSugerido = precioSugerido;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public Integer getImpuesto() {
            return impuesto;
        }

        public void setImpuesto(Integer impuesto) {
            this.impuesto = impuesto;
        }

        public String getCodigoBarra() {
            return codigoBarra;
        }

        public void setCodigoBarra(String codigoBarra) {
            this.codigoBarra = codigoBarra;
        }

        public Boolean getPrecioAbierto() {
            return precioAbierto;
        }

        public void setPrecioAbierto(Boolean precioAbierto) {
            this.precioAbierto = precioAbierto;
        }

        public String getComision() {
            return comision;
        }

        public void setComision(String comision) {
            this.comision = comision;
        }

        public String getTipoComision() {
            return tipoComision;
        }

        public void setTipoComision(String tipoComision) {
            this.tipoComision = tipoComision;
        }

        public String getDescTipoComision() {
            return descTipoComision;
        }

        public void setDescTipoComision(String descTipoComision) {
            this.descTipoComision = descTipoComision;
        }

        public Boolean getImpuestoAplicado() {
            return impuestoAplicado;
        }

        public void setImpuestoAplicado(Boolean impuestoAplicado) {
            this.impuestoAplicado = impuestoAplicado;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getTipoDesc() {
            return tipoDesc;
        }

        public void setTipoDesc(String tipoDesc) {
            this.tipoDesc = tipoDesc;
        }

        public Object getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(Object descripcion) {
            this.descripcion = descripcion;
        }

        public Boolean getPermiteDescuentos() {
            return permiteDescuentos;
        }

        public void setPermiteDescuentos(Boolean permiteDescuentos) {
            this.permiteDescuentos = permiteDescuentos;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        public class Modificadore implements Serializable {

            @SerializedName("idmodificador")
            @Expose
            private String idmodificador;
            private final static long serialVersionUID = -3509904208850096313L;

            public String getIdmodificador() {
                return idmodificador;
            }

            public void setIdmodificador(String idmodificador) {
                this.idmodificador = idmodificador;
            }

        }

        public class Categoria implements Serializable {

            @SerializedName("idcategoriamenu")
            @Expose
            private String idcategoriamenu;
            @SerializedName("nombremenu")
            @Expose
            private String nombremenu;
            @SerializedName("porcentaje")
            @Expose
            private String porcentaje;
            @SerializedName("impuesto")
            @Expose
            private String impuesto;
            @SerializedName("codigo")
            @Expose
            private String codigo;
            @SerializedName("orden")
            @Expose
            private String orden;
            @SerializedName("printers")
            @Expose
            private ArrayList<Printer> printers = null;
            private final static long serialVersionUID = 7720917384547692240L;

            public String getIdcategoriamenu() {
                return idcategoriamenu;
            }

            public void setIdcategoriamenu(String idcategoriamenu) {
                this.idcategoriamenu = idcategoriamenu;
            }

            public String getNombremenu() {
                return nombremenu;
            }

            public void setNombremenu(String nombremenu) {
                this.nombremenu = nombremenu;
            }

            public String getPorcentaje() {
                return porcentaje;
            }

            public void setPorcentaje(String porcentaje) {
                this.porcentaje = porcentaje;
            }

            public String getImpuesto() {
                return impuesto;
            }

            public void setImpuesto(String impuesto) {
                this.impuesto = impuesto;
            }

            public String getCodigo() {
                return codigo;
            }

            public void setCodigo(String codigo) {
                this.codigo = codigo;
            }

            public String getOrden() {
                return orden;
            }

            public void setOrden(String orden) {
                this.orden = orden;
            }

            public ArrayList<Printer> getPrinters() {
                return printers;
            }

            public void setPrinters(ArrayList<Printer> printers) {
                this.printers = printers;
            }

            public class Printer implements Serializable {

                @SerializedName("id_printer")
                @Expose
                private String idPrinter;
                @SerializedName("desc_printer")
                @Expose
                private String descPrinter;
                @SerializedName("ip")
                @Expose
                private String ip;
                @SerializedName("idtipo")
                @Expose
                private String idtipo;
                @SerializedName("desc_tipo")
                @Expose
                private String descTipo;
                @SerializedName("isDouble")
                @Expose
                private Boolean isDouble;
                @SerializedName("cutPaper")
                @Expose
                private Boolean cutPaper;
                private final static long serialVersionUID = -5217060892018423347L;

                public String getIdPrinter() {
                    return idPrinter;
                }

                public void setIdPrinter(String idPrinter) {
                    this.idPrinter = idPrinter;
                }

                public String getDescPrinter() {
                    return descPrinter;
                }

                public void setDescPrinter(String descPrinter) {
                    this.descPrinter = descPrinter;
                }

                public String getIp() {
                    return ip;
                }

                public void setIp(String ip) {
                    this.ip = ip;
                }

                public String getIdtipo() {
                    return idtipo;
                }

                public void setIdtipo(String idtipo) {
                    this.idtipo = idtipo;
                }

                public String getDescTipo() {
                    return descTipo;
                }

                public void setDescTipo(String descTipo) {
                    this.descTipo = descTipo;
                }

                public Boolean getIsDouble() {
                    return isDouble;
                }

                public void setIsDouble(Boolean isDouble) {
                    this.isDouble = isDouble;
                }

                public Boolean getCutPaper() {
                    return cutPaper;
                }

                public void setCutPaper(Boolean cutPaper) {
                    this.cutPaper = cutPaper;
                }

            }

        }
    }
}
