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
        }
    }
}