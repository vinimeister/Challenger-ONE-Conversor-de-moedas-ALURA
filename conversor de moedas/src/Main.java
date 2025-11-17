import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Map;
import com.google.gson.Gson;

class ExchangeRateResponse {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBase_code() { return base_code; }
    public Map<String, Double> getConversion_rates()  { return conversion_rates; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite sua idade: ");
            int idade = scanner.nextInt();
            System.out.println("Olá, " + nome + "! você tem " + idade + " anos.");

            System.out.println("\nConectando à API de moedas...");

            URL url = new URL("https://v6.exchangerate-api.com/v6/a08bd511a8fe3fc0c08bfabf/latest/USD");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código HTTP recebido: " + statusCode);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String linha;
            StringBuilder resposta = new StringBuilder();

            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }

            reader.close();
            connection.disconnect();

            System.out.println("\nJSON recebido:");
            System.out.println(resposta.toString());

            Gson gson = new Gson();
            ExchangeRateResponse exchangeRate = gson.fromJson(resposta.toString(), ExchangeRateResponse.class);

            System.out.println("\nVamos converter moedas!");

            scanner.nextLine();

            System.out.println("Para qual moeda você quer converter? (Ex: BRL, EUR, JPY)");
            String moeda = scanner.nextLine().toUpperCase();

            System.out.println("Digite o valor em DÓLAR que deseja converter:");
            double valorUSD = scanner.nextDouble();

            Map<String, Double> taxas = exchangeRate.getConversion_rates();

            if (taxas.containsKey(moeda)) {
                double taxa = taxas.get(moeda);
                double resultado = valorUSD * taxa;

                System.out.printf("\n%.2f USD equivalem a %.2f %s\n", valorUSD, resultado, moeda);

            } else {
                System.out.println("Desculpe, não encontrei a moeda \"" + moeda + "\"");
            }

            System.out.println("\nIsso é tudo pessoal!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
