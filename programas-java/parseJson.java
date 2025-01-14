import org.json.*;

public class Main {
    public static void main(String []args){

        try{

            //creacion del inputstream
            InputStream is = new FileInputStream("datos.json");

            //creamos el tokenizador 
            JSONTokener tokener = new JSONTokener(is);

            // pasamos a la  instancia de la clase JSONObject
            JSONObject obj = new JSONObject(tokener);

            //sacamos credenciales
            JSONObject credenciales = obj.getJSONObject("credenciales");

            String usuario = credenciales.getString("usuario");
            String clave = credenciales.getString("clave"); 

            System.out.println("usuario" + usuario + "clave" + clave);

            //dentro de credenciales tenemos imagenes
            JSONArray imagenes = credenciales.getJSONArray("imagenes");
            for(Object imagen: immagenes){
                System.out.println(imagen.toString());
            }
        } catch(Exception e){
            System.out.println("el error es el siguiente" + e.getMessage());
        }
    }
}