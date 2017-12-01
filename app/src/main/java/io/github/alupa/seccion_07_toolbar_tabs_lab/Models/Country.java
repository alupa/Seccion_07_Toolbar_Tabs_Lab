package io.github.alupa.seccion_07_toolbar_tabs_lab.Models;

/**
 * Created by Alvaro on 26-10-2017.
 */

public class Country {

    private String name;
    private String code;

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlagURL(){
        return "http://www.geognos.com/api/en/countries/flag/" + code + ".png";
    }

    // Importante!! Sobreescribimos el método toString de nuestra clase POJO Country
    // Para que cuando el Spinner llame internamente cada objeto, use el name para ser mostrado
    // como único valor posible en la lista desplegable
    @Override
    public String toString() {
        return name;
    }

}
