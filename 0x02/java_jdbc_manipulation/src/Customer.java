public class Customer {
    private Integer id;
    private String name;
    private Integer age;
    private String cpf;
    private String rg;

    public Customer() {}

    public Customer(Integer id, String name, Integer age, String cpf, String rg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.rg = rg;
    }

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public String getCpf() { return cpf; }
    public String getRg() { return rg; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setRg(String rg) { this.rg = rg; }

    @Override
    public String toString() {
        return "Customer{id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", cpf='" + cpf + '\'' +
               ", rg='" + rg + '\'' +
               '}';
    }
}
