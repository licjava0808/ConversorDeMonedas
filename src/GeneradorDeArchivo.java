import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivo {
    public void guardarJson(List<String>lista){
        try {
            FileWriter fileWriter = new FileWriter("registro_consultas.txt");
            for (String resultado: lista){
                fileWriter.write(resultado);
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Historial de consultas guardado correctamente en 'registro_consultas.txt'");
        }catch (IOException e){
            System.out.println("Error al intentar guardar el historial de consultas:"+e.getMessage());
        }
    }
}
