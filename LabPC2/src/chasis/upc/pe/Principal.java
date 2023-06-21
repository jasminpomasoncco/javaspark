package chasis.upc.pe;

import static spark.Spark.get;


import com.google.gson.Gson;

public class Principal {
	
	public static void main(String[] args){
		 get("/chasis", (req, res) -> {
	            Chasis chasis = new Chasis();
	            res.type("application/json");
	            return new Gson().toJson(chasis);
	        });
	}

}
