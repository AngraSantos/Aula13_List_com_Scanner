package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Aplicacao {
    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Funcionario> list = new ArrayList<>();
        
    System.out.print("Quantos funcionários foram registrados? ");
    int f = input.nextInt();

    for(int i = 0; i < f; i++){
        System.out.println();
        System.out.println("Funcionário #" + (i + 1) + ":"); 
        System.out.print("id: ");
        Integer id = input.nextInt();
        while(hasId(list, id)){
            System.out.println("Id já capturado! Tente Novamente: ");
            id = input.nextInt();
        }
        
        System.out.print("Nome: ");
        input.nextLine();
        String name = input.nextLine();
        System.out.print("Salário: ");
        Double salary = input.nextDouble();

        Funcionario func = new Funcionario(id, name, salary);
        list.add(func);          
    }

    System.out.println();
    System.out.print("Insira o ID do funcionário que terá aumento salárial: ");
    int idSalary = input.nextInt();

    Integer pos = position(list, idSalary);

    if(pos == null){
        System.out.println("Esse ID não existe!");
    }else {
        System.out.print("Entre com a porcentagem: ");
        double percent = input.nextDouble();
        list.get(pos).increaseSalary(percent);
    }
    System.out.println();
    System.out.println("Lista de funcionários: ");
  
    for(Funcionario func : list){
        System.out.println(func);
    }

    input.close();
}
    public static Integer position(List<Funcionario> list, int id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }   
        return null;     
    }

    public static Boolean hasId(List<Funcionario> list, int id){
        Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return func != null;
    }

}
