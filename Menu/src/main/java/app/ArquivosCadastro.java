package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

class ArquivosCadastro {

    private HashMap<String, Perfil> pessoas;

    public ArquivosCadastro(HashMap<String, Perfil> pessoas) {
        this.pessoas = pessoas;
    }

    public void exportarDados() {
        salvarArquivo("cadastros-exportados.txt");
    }

    public void fazerBackup() {
        salvarArquivo("backup-cadastros.txt");
    }

    private void salvarArquivo(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();

        for (String nome : pessoas.keySet()) {
            Perfil perfil = pessoas.get(nome);

            conteudo.append("Nome: ").append(nome).append(System.lineSeparator());
            conteudo.append("Idade: ").append(perfil.idade()).append(System.lineSeparator());
            conteudo.append("Cidade: ").append(perfil.cidade()).append(System.lineSeparator());
            conteudo.append("Email: ").append(perfil.email()).append(System.lineSeparator());
            conteudo.append("Telefone: ").append(perfil.telefone()).append(System.lineSeparator());
            conteudo.append("Endereco: ").append(perfil.endereco()).append(System.lineSeparator());
            conteudo.append("Observacao: ").append(perfil.observacao()).append(System.lineSeparator());
            conteudo.append("------------------------------").append(System.lineSeparator());
        }

        try {
            Files.writeString(Path.of(nomeArquivo), conteudo.toString());
            System.out.println("Arquivo gerado: " + nomeArquivo);
        } catch (IOException erro) {
            System.out.println("Nao foi possivel gerar o arquivo.");
        }
    }
}
