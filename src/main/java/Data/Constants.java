package Data;

public class Constants {
    //public static String localURL=webdriver().driver().url();
    public static final String CONNECTION_STRING =
            "jdbc:sqlserver://localhost\\SQLEXPRESS;" +
                    "integratedSecurity=true;" +
                    "trustServerCertificate=true;";
    public static final String tableName="[MidtermSwoop].[dbo].[Swoop]";
    public static final String guestCount="2-5 სტუმარი";
    public static final String priceFilter="200 ₾ - 300 ₾";
    public static final double preDefinedStartingPrice=200;
    public static final double preDefinedLastPrice=300;
    public static final String priceFilterName="ფასი";
    public static final String URL="https://swoop.ge/";
    public final boolean HEADLESS = false;
    public final int SLOWMO = 500;
    public  static String entertainmentUrl="https://swoop.ge/category/4/gartoba/?page=";

    public static  Object[][] SEARCH_QUERIES = new Object[][]{
            {"ითამაშე მაფია მეგობრებთან ერთად"},
            {"შეიკრიბე მეგობრებთან ერთად და ითამაშე მაფია"},
            {"განიტვირთე და აღადგინე სხეული მაღალტექნოლოგიური სპა კაფსულით"},
            {"დაიწყე ტექნოლოგიური თავგადასავალი რობოტიკის და პროგრამირების კურსზე"},
            {"გაატარეთ მხიარული წუთები საყვარელ ადამიანებთან ერთად"},
            {"დაისვენე საყვარელ ადამიანთან ერთად - სვანეთი, მესტია"},
            {"დაისვენე მეგობრებთან ერთად - სვანეთი, მესტია"},
            {"განიტვირთე და ივარჯიშე ერთ სივრცეში - აუზი, დარბაზი და საუნა შაბათ-კვირას"},
            {"მენიუ 6 ან 10 სტუმარზე"}
    };

}
