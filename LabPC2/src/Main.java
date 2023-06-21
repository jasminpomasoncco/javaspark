
import com.google.gson.Gson;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static spark.Spark.*;
import static upc.service2.JsonUtil.*;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        get("/info", (req, res) -> "Este es un ejemplo de Spark");
        get("/persona", (req, res) -> {
            Collection<Persona> personas = PersonaRepository.findAll();
            res.type("application/json");
            return new Gson().toJson(personas);
        });
        get("/persona/:id", (req, res) -> PersonaRepository.getById(Integer.parseInt(req.params("id"))), json());
        post("/persona", (req, res) -> {
            String nombre = req.queryParams("nombre"); //recibe el par?metro nombre
            String edad = req.queryParamOrDefault("edad", "0"); //recibe el par?metro edad. Si no est?, lo pone en cero (0)
            Persona persona = PersonaRepository.addPersona(nombre, edad); //lo registra en el listado
            res.type("application/json"); //prepara el tipo a responder...
            return new Gson().toJson(persona); //.. y devuelve el objeto creado
        });
    }
}