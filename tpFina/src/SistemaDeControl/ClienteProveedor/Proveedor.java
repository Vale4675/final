package SistemaDeControl.ClienteProveedor;

import SistemaDeControl.Interfaces.I_Convertir_JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Proveedor implements Serializable, I_Convertir_JsonObject {


    private String nombre;
    private String cuit; //formato xx-xxxxxxxx-x
    private String domicilioFiscal;
    private CondicionIVA condicionFiscal ;  //responsable inscripto, monotributista


    /**
     * CONSTRUCTORES
     * @param nombre   LEGAL, NO DE FANTASIA
     * @param cuit      FORMATO XX-XXXXXXXX-X
     * @param domicilioFiscal   CALLE Y NUMERO
     * @param condicionFiscal    MONOTRIBUTISTA, RESPONSABLE INSCRIPTO O EXENTO.
     */
    public Proveedor(String nombre, String cuit, String domicilioFiscal, CondicionIVA condicionFiscal){
        this.nombre = nombre;
        this.cuit = cuit;
        this.domicilioFiscal = domicilioFiscal;
        this.condicionFiscal = condicionFiscal;
    }


public  Proveedor()
{
    nombre = "";
    cuit = "";
    domicilioFiscal = "";
    condicionFiscal = CondicionIVA.DEFAULT;
}

/** getters and setters*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(String domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public CondicionIVA getCondicionFiscal() {
        return condicionFiscal;
    }

    public void setCondicionFiscal(CondicionIVA condicionFiscal) {
        this.condicionFiscal = condicionFiscal;
    }


    /**equals y hashcode*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proveedor proveedor)) return false;

        if (getNombre() != null ? !getNombre().equals(proveedor.getNombre()) : proveedor.getNombre() != null)
            return false;
        if (getCuit() != null ? !getCuit().equals(proveedor.getCuit()) : proveedor.getCuit() != null) return false;
        if (getDomicilioFiscal() != null ? !getDomicilioFiscal().equals(proveedor.getDomicilioFiscal()) : proveedor.getDomicilioFiscal() != null)
            return false;
        return getCondicionFiscal() == proveedor.getCondicionFiscal();
    }

    @Override
    public int hashCode() {
       return 123;
    }


/**tostring*/
    @Override
    public String toString() {
        return
                "\nProveedor{" +
                "\nnombre='" + nombre + '\'' +
                "\ncuit='" + cuit + '\'' +
                "\ndomicilioFiscal='" + domicilioFiscal + '\'' +
                "\ncondicionFiscal=" + condicionFiscal +
                "\n-----------------------------------";
    }

    /**Json
     *
     * @return
     * @throws JSONException
     */
    @Override
    public JSONObject convertirJsonObject() throws JSONException {
        JSONObject jsonObject = new JSONObject (  );
        jsonObject.put ("Nombre ",nombre) ;
        jsonObject.put ( "Cuit",cuit );
        jsonObject.put ( "Domicilio Fiscal",domicilioFiscal );
        jsonObject.put ( "Condicion Fiscal",condicionFiscal );
        return jsonObject;
    }
}
