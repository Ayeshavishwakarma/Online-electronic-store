package pack1;

public class ProductBean {
    private String pcode;
    private String pname;
    private String pcompany;
    private String pprice; // Changed to double
    private String pqty; // Changed to int
   

    // Default constructor
    public ProductBean() {}

    // Parameterized constructor
    public ProductBean(String pcode, String pname, String pcompany, String pprice, String pqty,String imagePath) {
        this.pcode = pcode;
        this.pname = pname;
        this.pcompany = pcompany;
        this.pprice = pprice;
        this.pqty = pqty;
    }

    // Getters and Setters
    public String getPcode() { return pcode; }
    public void setPcode(String pcode) { this.pcode = pcode; }
    
    public String getPname() { return pname; }
    public void setPname(String pname) { this.pname = pname; }
    
    public String getPcompany() { return pcompany; }
    public void setPcompany(String pcompany) { this.pcompany = pcompany; }
    
    public String getPprice() { return pprice; } // Changed to double
    public void setPprice(String pprice) { this.pprice = pprice; } // Changed to double
    
    public String getPqty() { return pqty; } // Changed to int
    public void setPqty(String pqty) { this.pqty = pqty; } // Changed to int
    
 

    @Override
    public String toString() {
        return "ProductBean{" +
                "pcode='" + pcode + '\'' +
                ", pname='" + pname + '\'' +
                ", pcompany='" + pcompany + '\'' +
                ", pprice=" + pprice +
                ", pqty=" + pqty +
                
                '}';
    }
}