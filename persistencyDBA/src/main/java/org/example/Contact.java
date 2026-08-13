package org.example;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(){/* S2 */}

    //Construtor para adicionar (o ID será gerado pelo banco)
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    //Construtor para listar/atualizar (o ID vem do banco)
    public Contact(int id, String name, String phoneNumber){
           this.id = id;
           this.name = name;
           this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return String.format
               ("ID: %d | Nome: %-20s | Telefone: %s",
                 id,      name,         phoneNumber
               );
    }

}
