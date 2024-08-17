import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        try {
            selecaoCandidatos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {
            "Nayderson",
            "Bruno",
            "Carlos",
            "Diana",
            "Eduardo",
            "Fernanda",
            "Gabriel",
            "Helena",
            "Igor"
        };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        System.out.printf("%-15s %-20s%n", "Candidato", "Salário Pretendido");
        System.out.println("-------------------------------");

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("%-15s %-20.2f%n", candidato, salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado.");
                analisarCandidato(salarioPretendido);
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }

        if (candidatosSelecionados == 0) {
            System.out.println("Nenhum candidato foi selecionado.");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligue para o candidato.");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Envie uma contra-proposta para o candidato.");
        } else {
            System.out.println("Esperar outros candidatos.");
        }
    }
}
