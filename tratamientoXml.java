public class Main {
    public static void main(String []args){
        File file = new File(datos.xml);
        DocumentBuildFactory documentBuilder =  DocumentBuildFactory.newInstance();ç

        try {
            DocumentBuilder documentBuilders = documentBuildFactory.newDocumentBuilder();

            try{
                //analizamos documento
                Document document = documentBuilders.parse(file);

                //obtenemos usuario y clave

                String usuario = document.getElementsByTagName("usuario").item(0).getTextContent();
                String clave = docuent.getElementsByTagName("clave").item(0).getTextContent(); 

            }
        }
    }
}